package com.brett.nimbix.tileentitys;

import com.brett.nimbix.blocks.Infuser;
import com.brett.recipies.InfuserRecipes;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityInfuser extends TileEntity implements ISidedInventory {

	private static final int[] slotsTop = new int[] { 0 };
	private static final int[] slotsBottom = new int[] { 2, 1 };
	private static final int[] slotsSides = new int[] { 1 };

	private ItemStack[] furnaceItemStacks = new ItemStack[3];

	public int furnaceBurnTime;
	public int currentBurnTime;
	public int furnaceCookTime;

	private String furnaceName;

	public void furnaceName(String string){
		this.furnaceName = string;
	}
	
	@Override
	public int getSizeInventory() {
		return this.furnaceItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		/*switch (slot){
		
		case 0:
			System.out.println("OUT: " + 0);
			return this.furnaceItemStacks[0];
		case 1:
			System.out.println("OUT: " + 1);
			return this.furnaceItemStacks[1];
		case 2:
			System.out.println("OUT: " + 2);
			return this.furnaceItemStacks[2];
		case 3:
			System.out.println("OUT: " + 3);
			return this.furnaceItemStacks[2];
		default:
			System.out.println("OUT: " + 4);
			return this.furnaceItemStacks[0];
		}*/
		return this.furnaceItemStacks[slot];
		/*if (slot == 1 || slot == 0 || slot == 2){
			return this.furnaceItemStacks[slot];
		} else if (slot == 3) {
			return this.furnaceItemStacks[slot-1];
		}*/
		//return null;
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (par1 == 1 || par1 == 0 || par1 == 2){
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
		/*else if (par1 == 3) {
			if (this.furnaceItemStacks[par1-1] != null) {
				ItemStack itemstack;
				if (this.furnaceItemStacks[par1-1].stackSize <= par2) {
					itemstack = this.furnaceItemStacks[par1-1];
					this.furnaceItemStacks[par1-1] = null;
					return itemstack;
				} else {
					itemstack = this.furnaceItemStacks[par1-1].splitStack(par2);

					if (this.furnaceItemStacks[par1-1].stackSize == 0) {
						this.furnaceItemStacks[par1-1] = null;
					}
					return itemstack;
				}
			} else {
				return null;
			}
		} */
		
		return null;
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
		if (slot == 1 || slot == 0 || slot == 2){
			this.furnaceItemStacks[slot] = itemstack;
		} else if (slot == 3) {
			//this.furnaceItemStacks[slot-1] = itemstack;
		} else {
			
		}

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}

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

		this.furnaceBurnTime = tagCompound.getShort("BurnTime");
		this.furnaceCookTime = tagCompound.getShort("CookTime");
		this.currentBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

		if (tagCompound.hasKey("CustomName", 8)) {
			this.furnaceName = tagCompound.getString("CustomName");
		}
	}

	public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setShort("BurnTime", (short) this.furnaceBurnTime);
		tagCompound.setShort("CookTime", (short) this.furnaceBurnTime);
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

		if (this.hasCustomName()) {
			tagCompound.setString("CustomName", this.furnaceName);
		}
		return tagCompound;
	}

	public int getCookProgressScaled(int par1) {
		return this.furnaceCookTime * par1 / 200;
	}

	public int getBurnTimeRemainingScaled(int par1) {
		if (this.currentBurnTime == 0) {
			this.currentBurnTime = 200;
		}

		return this.furnaceBurnTime * par1 / this.currentBurnTime;
	}

	public boolean isBurning() {
		return this.furnaceBurnTime > 0;
	}

	public void updateEntity() {
		boolean flag = this.furnaceBurnTime > 0;
		boolean flag1 = false;

		if (this.furnaceBurnTime > 0) {
			--this.furnaceBurnTime;
		}

		if (!this.worldObj.isRemote) {
			if (this.furnaceBurnTime == 0 && this.canSmelt()) {
				this.currentBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

				if (this.furnaceBurnTime > 0) {
					flag1 = true;
					if (this.furnaceItemStacks[1] != null) {
						--this.furnaceItemStacks[1].stackSize;

						if (this.furnaceItemStacks[1].stackSize == 0) {
							this.furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(this.furnaceItemStacks[1]);
						}
					}
				}
			}

			if (this.isBurning() && this.canSmelt()) {
				++this.furnaceCookTime;
				if (this.furnaceCookTime == 200) {
					this.furnaceCookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			} else {
				this.furnaceCookTime = 0;
			}
		}

		if (flag != this.furnaceBurnTime > 0) {
			flag1 = true;
			//Infuser.updateBlockState(this.furnaceBurnTime > 0, this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ());
		}

		if (flag1) {
			this.markDirty();
		}
	}

	private boolean canSmelt() {
		if (this.furnaceItemStacks[0] == null || this.furnaceItemStacks[2] == null) {
			return false;
		} else {
			ItemStack itemstack = InfuserRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
			ItemStack itemstack2 = InfuserRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[2]);
			if (itemstack == null || itemstack2 == null) {System.out.println("YOU ARE WRONG"); return false;}
			if (this.furnaceItemStacks[2] == null) {System.out.println("HELP ME"); return false;}
			if (!this.furnaceItemStacks[2].isItemEqual(itemstack) || !this.furnaceItemStacks[2].isItemEqual(itemstack2)) {System.out.println("FALSE PART 2" + 0);return false;}
			int result = furnaceItemStacks[2].stackSize + itemstack.stackSize;
			return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize();
		}
	}

	public void smeltItem() {
		if (this.canSmelt()) {
			ItemStack itemstack = InfuserRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
			ItemStack itemstack2 = InfuserRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[2]);

			if (this.furnaceItemStacks[2] == null) {
				System.out.println("COPED STAGE FALSE" + 0);
				//this.furnaceItemStacks[2] = itemstack.copy();
			} else if (this.furnaceItemStacks[2].getItem() == itemstack.getItem()) {
				System.out.println("STAGE 2 " + 0);
				//this.furnaceItemStacks[2].stackSize += itemstack.stackSize;
			}
			
			this.furnaceItemStacks[0].stackSize -= 1;
			this.furnaceItemStacks[2].stackSize -= 1;
			
			if(this.furnaceItemStacks[0].stackSize >= 0){
				this.furnaceItemStacks[0] = null;
				this.furnaceItemStacks[2] = null;
			}
		}
	}
	
	public static int getItemBurnTime(ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR){
				Block block = Block.getBlockFromItem(item);
				
				if (block == Blocks.COAL_BLOCK){
					return 6500;
				}
				
				return GameRegistry.getFuelValue(new ItemStack(item));
				
			}
			if (item == Items.COAL){
				return 1600;
			}
			return GameRegistry.getFuelValue(itemstack);
		}
	}

	public static boolean isItemFuel(ItemStack itemstack){
		return getItemBurnTime(itemstack) > 0;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(new BlockPos(this.pos.getX(), this.pos.getY(), this.pos.getZ())) != this ? false : player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack itemstack) {
		return par1 == 2 ? false : (par1 == 1 ? isItemFuel(itemstack) : true);
	}

	
	
	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
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
		return this.hasCustomName() ? this.furnaceName : "Infuser";
	}

	@Override
	public boolean hasCustomName() {
		return this.furnaceName != null && this.furnaceName.length() > 0;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == side.DOWN ? slotsBottom : (side == side.UP ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn,
			EnumFacing direction) {
		return this.isItemValidForSlot(direction.getIndex(), itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack,
			EnumFacing direction) {
		return direction != EnumFacing.DOWN || direction != EnumFacing.UP || stack.getItem() == Items.BUCKET;
	}

}