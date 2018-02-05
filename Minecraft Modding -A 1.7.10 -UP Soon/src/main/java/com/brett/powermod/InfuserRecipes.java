package com.brett.powermod;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfuserRecipes {

	private static final InfuserRecipes SMELTING_BASE = new InfuserRecipes();

	private Map fuelList = new HashMap();
	private Map smeltingList = new HashMap();
	private Map smeltingList2 = new HashMap();

	public static InfuserRecipes smelting() {
		return SMELTING_BASE;
	}
	
	private InfuserRecipes(){
		//this.addRecipie(TMItem.tutCrop, new ItemStack(TMItem.tutGrenade), 0.8F);
		//this.addRecipie(Item.getItemFromBlock(TMBlock.tutChest), new ItemStack(TMItem.tutHelmet), 0.8F);
	}
	
	public void addRecipie(Item item, Item item2, ItemStack itemstack){
		this.addLists(item, item2, itemstack);
	}
	public void addRecipie(Block block, Block block2, ItemStack itemstack){
		this.addLists(block, block2, itemstack);
	}
	
	public void addRecipie(Item item, Block block, ItemStack itemstack){
		this.putLists(new ItemStack(item, 1, 32767), new ItemStack(block, 1, 32767), itemstack);
	}
	public void addRecipie(Block item, Item block, ItemStack itemstack){
		this.putLists(new ItemStack(item, 1, 32767), new ItemStack(block, 1, 32767), itemstack);
	}
	
	public void addRecipie(ItemStack item, Block block, ItemStack itemstack){
		this.putLists(item, new ItemStack(block, 1, 32767), itemstack);
	}
	public void addRecipie(Block item, ItemStack block, ItemStack itemstack){
		this.putLists(new ItemStack(item, 1, 32767), block, itemstack);
	}
	
	public void addRecipie(ItemStack item, Item block, ItemStack itemstack){
		this.putLists(item, new ItemStack(block, 1, 32767), itemstack);
	}
	public void addRecipie(Item item, ItemStack block, ItemStack itemstack){
		this.putLists(new ItemStack(item, 1, 32767), block, itemstack);
	}
	
	public void addLists(Item item, Item item2, ItemStack itemstack){
		this.putLists(new ItemStack(item, 1, 32767), new ItemStack(item2, 1, 32767), itemstack);
	}
	public void addLists(Block block, Block block2, ItemStack itemstack){
		this.putLists(new ItemStack(block, 1, 32767), new ItemStack(block2, 1, 32767), itemstack);
	}
	
	public void putLists(ItemStack itemstack, ItemStack itemstack2, ItemStack itemstackOut){
		this.smeltingList.put(itemstack, itemstackOut);
		this.smeltingList.put(itemstack2, itemstackOut);
	}

	public ItemStack getSmeltingResult(ItemStack itemstack) {
		Iterator iterator = this.smeltingList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}
			entry = (Entry) iterator.next();
		} while (!canBeSmelted(itemstack, (ItemStack) entry.getKey()));
		return (ItemStack) entry.getValue();
	}

	private boolean canBeSmelted(ItemStack itemstack, ItemStack itemstack2) {
		System.out.println(itemstack2.getItem() == itemstack.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack.getItemDamage()));
		return itemstack2.getItem() == itemstack.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack.getItemDamage());
	}
	
}