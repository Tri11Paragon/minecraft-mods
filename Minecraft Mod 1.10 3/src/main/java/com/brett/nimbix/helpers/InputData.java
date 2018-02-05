package com.brett.nimbix.helpers;

import net.minecraft.item.ItemStack;

public class InputData {
	
	private ItemStack stack1;
	private ItemStack stack2;
	
	public InputData(ItemStack stack1, ItemStack stack2) {
		this.stack1 = stack1;
		this.stack2 = stack2;
	}

	public ItemStack getStack1() {
		return stack1;
	}

	public void setStack1(ItemStack stack1) {
		this.stack1 = stack1;
	}

	public ItemStack getStack2() {
		return stack2;
	}

	public void setStack2(ItemStack stack2) {
		this.stack2 = stack2;
	}
	
}
