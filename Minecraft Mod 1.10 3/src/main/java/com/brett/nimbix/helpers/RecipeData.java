package com.brett.nimbix.helpers;

import net.minecraft.item.ItemStack;

public class RecipeData {
	
	private ItemStack inputOne;
	private ItemStack inputTwo;
	private ItemStack output;
	
	public RecipeData(ItemStack inputOne, ItemStack inputTwo, ItemStack output) {
		this.inputOne = inputOne;
		this.inputTwo = inputTwo;
		this.output = output;
	}

	public ItemStack getInputOne() {
		return inputOne;
	}

	public void setInputOne(ItemStack inputOne) {
		this.inputOne = inputOne;
	}

	public ItemStack getInputTwo() {
		return inputTwo;
	}

	public void setInputTwo(ItemStack inputTwo) {
		this.inputTwo = inputTwo;
	}

	public ItemStack getOutput() {
		return output;
	}

	public void setOutput(ItemStack output) {
		this.output = output;
	}
	
}
