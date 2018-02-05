package com.brett.nimbix.container.slot;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class slotTestTile extends Slot {
	
	public slotTestTile(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.getItem() == Items.REDSTONE || stack.getItem() == Item.getItemFromBlock(Blocks.REDSTONE_BLOCK);
	}
	
}
