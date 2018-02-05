package com.brett.randomthings.machines.Container;

import com.brett.randomthings.machines.InfuserRecipes;
import com.brett.randomthings.machines.tileEntity.tileBlockInfuser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerInfuser extends Container {
	
	private tileBlockInfuser te;
	
	IItemHandler handler;
	
	private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime;
    private int cooldown;
	
	public ContainerInfuser(IInventory playerInv, tileBlockInfuser te) {
		this.te = te;
		this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		
		this.addSlotToContainer(new SlotItemHandler(handler, 0, 34, 17));
		this.addSlotToContainer(new SlotItemHandler(handler, 1, 56, 17));
		
		this.addSlotToContainer(new SlotItemHandler(handler, 2, 107, 35));
		
		int xPos = 8;
		int yPos = 84;
				
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
			}
		}
				
		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, xPos + x * 18, yPos + 58));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return !playerIn.isSpectator();
	}
	@Override
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);

            if (this.cookTime != this.te.getField(0))
            {
                icontainerlistener.sendProgressBarUpdate(this, 0, this.te.getField(0));
            }

            if (this.currentItemBurnTime != this.te.getField(1))
            {
                icontainerlistener.sendProgressBarUpdate(this, 1, this.te.getField(1));
            }
            
            if (this.cooldown != this.te.getField(2))
            {
                icontainerlistener.sendProgressBarUpdate(this, 2, this.te.getField(2));
            }

            if (this.totalCookTime != this.te.getField(3))
            {
                icontainerlistener.sendProgressBarUpdate(this, 3, this.te.getField(3));
            }
        }
		
		this.cookTime = this.te.getField(0);
		this.currentItemBurnTime = this.te.getField(1);
		this.cooldown = this.te.getField(2);
        this.totalCookTime = this.te.getField(3);
		
		te.setItemStacks(0, handler.getStackInSlot(0));
		te.setItemStacks(1, handler.getStackInSlot(1));
		te.setItemStacks(2, handler.getStackInSlot(2));
		
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.te.setField(id, data);
    }
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(0);
		Slot slot2 = (Slot) this.inventorySlots.get(1);
		
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			ItemStack itemstack2 = slot2.getStack();
			itemstack = itemstack1.copy();
			
			if(par2 == 2){
				if(!this.mergeItemStack(itemstack1, 3, 39, true)){
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}else if(par2 != 1 && par2 != 0){
				if(InfuserRecipes.smelting().getSmeltingResult(itemstack1, itemstack2) != null){
					if(!this.mergeItemStack(itemstack1, 0, 1, false)){
						return null;
					}
				}else if(par2 >=3 && par2 < 30){
					if(!this.mergeItemStack(itemstack1, 30, 39, false)){
						return null;
					}
				}else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
					return null;
				}
			}else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
				return null;
			}
			if(itemstack1.stackSize == 0){
				slot.putStack((ItemStack)null);
			}else{
				slot.onSlotChanged();
			}
			if(itemstack1.stackSize == itemstack.stackSize){
				return null;
			}
			slot.onPickupFromSlot(player, itemstack1);
		}
		return itemstack;
	}

}
