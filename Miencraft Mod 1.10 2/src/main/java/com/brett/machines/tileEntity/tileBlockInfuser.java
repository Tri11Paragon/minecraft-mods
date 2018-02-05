package com.brett.machines.tileEntity;

import javax.annotation.Nullable;

import com.brett.recipies.InfuserRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class tileBlockInfuser extends TileEntity implements ITickable, ICapabilityProvider, ISidedInventory {

	private ItemStackHandler handler;
	private int cooldown;
	
    private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime;
    private String furnaceCustomName;
	
	private ItemStack[] furnaceItemStacks = new ItemStack[3];
	
	public tileBlockInfuser() {
		this.cooldown=0;
		this.handler=new ItemStackHandler(3);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.cooldown = nbt.getInteger("Cooldown");
		this.handler.deserializeNBT(nbt.getCompoundTag("ItemStackHandler"));
		
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");

            if (j >= 0 && j < this.furnaceItemStacks.length)
            {
                this.furnaceItemStacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
        this.cookTime = nbt.getInteger("CookTime");
        this.totalCookTime = nbt.getInteger("CookTimeTotal");

        if (nbt.hasKey("CustomName", 8))
        {
            this.furnaceCustomName = nbt.getString("CustomName");
        }
		
		super.readFromNBT(nbt);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("Cooldown", this.cooldown);
		nbt.setTag("ItemStackHandler", this.handler.serializeNBT());
		nbt.setInteger("CookTime", this.cookTime);
		nbt.setInteger("CookTimeTotal", this.totalCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.furnaceItemStacks.length; ++i)
        {
            if (this.furnaceItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        nbt.setTag("Items", nbttaglist);

        if (this.hasCustomName())
        {
        	nbt.setString("CustomName", this.furnaceCustomName);
        }

		return super.writeToNBT(nbt);
	}
	
	
	
	@Override
	public void update() {
		if (this.worldObj != null && !this.worldObj.isRemote) {
			//IItemHandler handler = this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
			this.cooldown++;
			this.cooldown %= 100;
			//System.out.println("SLOTS " + furnaceItemStacks[0].getUnlocalizedName() + ", " + furnaceItemStacks[1].getUnlocalizedName() + ", " + furnaceItemStacks[2].getUnlocalizedName());
			if (this.handler != null && this.handler.getStackInSlot(1) != null && this.handler.getStackInSlot(0) != null){
				if (InfuserRecipes.smelting().getCanBeSmelted(this.handler.getStackInSlot(0), this.handler.getStackInSlot(1))){
					this.handler.setStackInSlot(0, decreaseItemStackSize(this.handler.getStackInSlot(0), 1));
					this.handler.setStackInSlot(1, decreaseItemStackSize(this.handler.getStackInSlot(1), 1));
					//this.handler.setStackInSlot(2, InfuserRecipes.smelting().getCanBeSmelted(this.handler.getStackInSlot(0), this.handler.getStackInSlot(1)));
				}
			}
		}
	}
	
	public ItemStack decreaseItemStackSize(ItemStack stack, int i){
		System.out.println("Removed Stack " + (stack.stackSize - i) + " : " + (stack.stackSize));
		if ((stack.stackSize - i) >= 1){
			return new ItemStack(stack.getItem(), (stack.stackSize - i));
		}
		return null;
	}
	
	public void setItemStacks(int index, ItemStack stack){
		furnaceItemStacks[index] = stack;
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		int metadata = getBlockMetadata();
		return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.readFromNBT(tag);
	}

	@Override
	public NBTTagCompound getTileData() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
			return (T) this.handler;
		}
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	
	public int getSizeInventory()
    {
        return this.furnaceItemStacks.length;
    }

    /**
     * Returns the stack in the given slot.
     */
    @Nullable
    public ItemStack getStackInSlot(int index)
    {
        return this.furnaceItemStacks[index];
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    @Nullable
    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
    }

    /**
     * Removes a stack from the given slot and returns it.
     */
    @Nullable
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
    }
    public void setInventorySlotContents(int index, @Nullable ItemStack stack)
    {
        boolean flag = stack != null && stack.isItemEqual(this.furnaceItemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.furnaceItemStacks[index]);
        this.furnaceItemStacks[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }

        if (index == 0 && !flag)
        {
            this.markDirty();
        }
    }

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return !player.isSpectator();
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return 100;
            case 1:
                return this.currentItemBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }
	@Override
    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                
                break;
            case 1:
                this.currentItemBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getName()
    {
        return this.hasCustomName() ? this.furnaceCustomName : "container.infuser";
    }

    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName()
    {
        return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
    }

    public void setCustomInventoryName(String p_145951_1_)
    {
        this.furnaceCustomName = p_145951_1_;
    }
    
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Furnace isBurning
     */
    public boolean isBurning()
    {
        return this.cooldown > 0;
    }

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		// TODO Auto-generated method stub
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        if (direction == EnumFacing.DOWN && index == 1)
        {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
            {
                return false;
            }
        }

        return true;
	}
	
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if (index == 2)
        {
            return true;
        }
        else if (index != 1)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = this.furnaceItemStacks[1];
            return true;
        }
    }
    public void clear()
    {
        for (int i = 0; i < this.furnaceItemStacks.length; ++i)
        {
            this.furnaceItemStacks[i] = null;
        }
    }
}
