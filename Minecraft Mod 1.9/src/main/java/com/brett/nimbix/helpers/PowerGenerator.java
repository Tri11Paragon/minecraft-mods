package com.brett.nimbix.helpers;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PowerGenerator extends TileEntity implements IPowerGenerator, ITickable, ISidedInventory {
	
	private static final int[] slotsTop = new int[] { 0 };
	private static final int[] slotsBottom = new int[] { 2, 1 };
	private static final int[] slotsSides = new int[] { 1 };

	private ItemStack[] furnaceItemStacks = new ItemStack[1];
	
	public int furnaceBurnTime;
	public int currentBurnTime;
	private String furnaceName;
	
	public int powerProduction;
	public int powerStorage;
	public int maxPower;
	
	public void furnaceName(String string){
		this.furnaceName = string;
	}
	
	@Override
	public int getSizeInventory() {
		return this.furnaceItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.furnaceItemStacks[slot];
	}
	
	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.furnaceItemStacks[par1] != null) {
			ItemStack itemstack;
			if (this.furnaceItemStacks[par1].stackSize <= par2) {
				itemstack = this.furnaceItemStacks[par1];
				this.furnaceItemStacks[par1] = null;
				return itemstack;
			} else {
				itemstack = this.furnaceItemStacks[par1].splitStack(par2);

				if (this.furnaceItemStacks[par1].stackSize == 0) {
					this.furnaceItemStacks[par1] = null;
				}
				return itemstack;
			}
		} else {
			return null;
		}
	}
	
	public int getPower(){
		return powerStorage;
	}
	
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (this.furnaceItemStacks[slot] != null) {
			ItemStack itemstack = this.furnaceItemStacks[slot];
			this.furnaceItemStacks[slot] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		this.furnaceItemStacks[slot] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}

	}
	
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.furnaceName : "Generator";
	}

	public boolean hasCustomInventoryName() {
		return this.furnaceName != null && this.furnaceName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		NBTTagList tagList = tagCompound.getTagList("Items", 10);
		this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < tagList.tagCount(); ++i) {
			NBTTagCompound tabCompound1 = tagList.getCompoundTagAt(i);
			byte byte0 = tabCompound1.getByte("Slot");

			if (byte0 >= 0 && byte0 < this.furnaceItemStacks.length) {
				this.furnaceItemStacks[byte0] = ItemStack.loadItemStackFromNBT(tabCompound1);
			}
		}
		this.powerProduction = tagCompound.getInteger("Production");
		this.powerStorage = tagCompound.getInteger("PowerStorage");
		this.maxPower = tagCompound.getInteger("MaxPower");
		this.furnaceBurnTime = tagCompound.getShort("BurnTime");
		this.currentBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

		if (tagCompound.hasKey("CustomName", 8)) {
			this.furnaceName = tagCompound.getString("CustomName");
		}
	}

	public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setShort("BurnTime", (short) this.furnaceBurnTime);
		tagCompound.setShort("CookTime", (short) this.furnaceBurnTime);
		tagCompound.setInteger("Production", powerProduction);
		tagCompound.setInteger("PowerStorage", powerStorage);
		tagCompound.setInteger("MaxPower", maxPower);
		NBTTagList tagList = new NBTTagList();

		for (int i = 0; i < this.furnaceItemStacks.length; ++i) {
			if (this.furnaceItemStacks[i] != null) {
				NBTTagCompound tagCompound1 = new NBTTagCompound();
				tagCompound1.setByte("Slot", (byte) i);
				this.furnaceItemStacks[i].writeToNBT(tagCompound1);
				tagList.appendTag(tagCompound1);
			}
		}

		tagCompound.setTag("Items", tagList);

		if (this.hasCustomInventoryName()) {
			tagCompound.setString("CustomName", this.furnaceName);
		}
		return tagCompound;
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1) {
		if (this.currentBurnTime == 0) {
			this.currentBurnTime = 200;
		}

		return this.furnaceBurnTime * par1 / this.currentBurnTime;
	}

	public boolean isBurning() {
		return this.furnaceBurnTime > 0;
	}
	
	private boolean canSmelt() {
		if (this.furnaceItemStacks[0] == null) {
			return false;
		} else {
			ItemStack itemstack = this.furnaceItemStacks[0];
			if(getItemBurnTime(itemstack) > 0){return true;}
			return false;
		}
	}
	
	public static int getItemBurnTime(ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR){
				Block block = Block.getBlockFromItem(item);
				
				//if(block == TMBlock.tutBlock){
					//return 200;
				//}
				
				//if(block.getMaterial() == Material.rock){
					//return 300;
				//}
				
			}
			
			//if(item == Items.redstone) return 200;
			//if(item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("EMERALD")) return 300;
			return GameRegistry.getFuelValue(itemstack);
		}
	}

	
	@Override
	public void producePower() {
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (this.furnaceBurnTime > 0) {
			if(powerStorage + powerProduction < maxPower){
				powerStorage += powerProduction;
				--this.furnaceBurnTime;
			}
		} else {
			if(furnaceItemStacks[0] != null){
				this.furnaceBurnTime += getItemBurnTime(furnaceItemStacks[0]);
				furnaceItemStacks[0].stackSize--;
			}
		}
	}
	
	public static boolean isItemFuel(ItemStack itemstack){
		return getItemBurnTime(itemstack) > 0;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return furnaceItemStacks[index];
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
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
		return isItemFuel(stack);
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ITextComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn,
			EnumFacing direction) {
		// TODO Auto-generated method stub
		return isItemFuel(itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack,
			EnumFacing direction) {
		// TODO Auto-generated method stub
		return false;
	}

}
