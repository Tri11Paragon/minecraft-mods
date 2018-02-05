package com.brett.nimbix.tileentitys;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileTritaniumChest extends TileEntity implements ITickable, IInventory {
	
	private ItemStack[] chestContents = new ItemStack[27];
	
	@Override
    public String getName()
    {
        return "container.TritaniumChest";
    }

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return chestContents.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO Auto-generated method stub
		return chestContents[index];
	}

	@Override
    public ItemStack decrStackSize(int index, int count)
    {
        ItemStack itemstack = ItemStackHelper.getAndSplit(this.chestContents, index, count);

        if (itemstack != null)
        {
            this.markDirty();
        }

        return itemstack;
    }

	@Override
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(this.chestContents, index);
    }

	@Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack)
    {
        this.chestContents[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}
	
	public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.chestContents = new ItemStack[this.getSizeInventory()];

            NBTTagList nbttaglist = compound.getTagList("Items", 10);

            for (int i = 0; i < nbttaglist.tagCount(); ++i)
            {
                NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
                int j = nbttagcompound.getByte("Slot") & 255;

                if (j >= 0 && j < this.chestContents.length)
                {
                    this.chestContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
                }
            }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

            NBTTagList nbttaglist = new NBTTagList();

            for (int i = 0; i < this.chestContents.length; ++i)
            {
                if (this.chestContents[i] != null)
                {
                    NBTTagCompound nbttagcompound = new NBTTagCompound();
                    nbttagcompound.setByte("Slot", (byte)i);
                    this.chestContents[i].writeToNBT(nbttagcompound);
                    nbttaglist.appendTag(nbttagcompound);
                }
            }

            compound.setTag("Items", nbttaglist);

        return compound;
    }

	@Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
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
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
    public int getField(int id)
    {
        return 0;
    }
	@Override
    public void setField(int id, int value)
    {
    }
	@Override
    public int getFieldCount()
    {
        return 0;
    }

	@Override
	public void clear() {
		// TODO Auto-generated method stub
        for (int i = 0; i < this.chestContents.length; ++i)
        {
            this.chestContents[i] = null;
        }
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
