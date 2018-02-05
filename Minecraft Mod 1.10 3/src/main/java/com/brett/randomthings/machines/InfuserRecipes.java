package com.brett.randomthings.machines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.plaf.InputMapUIResource;

import com.brett.nimbix.helpers.InputData;
import com.brett.nimbix.helpers.RecipeData;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfuserRecipes {

	private static final InfuserRecipes SMELTING_BASE = new InfuserRecipes();

	private Map fuelList = new HashMap();
	private Map smeltingList = new HashMap();
	private Map<RecipeData, RecipeData> smeltingResultList = new HashMap();

	public static InfuserRecipes smelting() {
		return SMELTING_BASE;
	}
	
	private InfuserRecipes(){
		this.addRecipie(Blocks.DIRT, Blocks.COBBLESTONE, new ItemStack(Blocks.STONE));
		this.addRecipie(new ItemStack(Blocks.STONE, 1, 5), Blocks.COBBLESTONE, new ItemStack(Blocks.STONE, 1));
		this.addRecipie(new ItemStack(Blocks.STONE, 1, 3), Blocks.COBBLESTONE, new ItemStack(Blocks.STONE, 1));
		this.addRecipie(new ItemStack(Blocks.STONE, 1, 1), Blocks.COBBLESTONE, new ItemStack(Blocks.STONE, 1));
		this.addRecipie(Items.APPLE, Blocks.DIAMOND_ORE, new ItemStack(Items.GOLDEN_APPLE));
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
		//this.setLists(new ItemStack(item, 1, 32767), new ItemStack(item2, 1, 32767), itemstack);
	}
	public void addLists(Block block, Block block2, ItemStack itemstack){
		this.putLists(new ItemStack(block, 1, 32767), new ItemStack(block2, 1, 32767), itemstack);
	}
	
	public void putLists(ItemStack itemstack, ItemStack itemstack2, ItemStack itemstackOut){
		this.smeltingList.put(itemstack, itemstackOut);
		this.smeltingResultList.put(new RecipeData(itemstack, itemstack2, itemstackOut), new RecipeData(itemstack, itemstack2, itemstackOut));
		System.out.println("WE HAVE PUT THE ITEMS THEY ARE: " + itemstack.getUnlocalizedName() + " ; " + itemstack2.getUnlocalizedName());
	}
	
	/**
	 * 
	 * This is VERY CRAPPY CODE
	 * DO NOT USE THIS.
	 * TODO: FIX THIS PLEASE!!!!
	 * 
	 * I fixed it.
	 */
	
	public ItemStack getSmeltingResult(InputData data)
    {
        for (Entry<RecipeData, RecipeData> entry : this.smeltingResultList.entrySet())
        {
            if (this.compareItemStacks(data.getStack1(), (ItemStack)entry.getKey().getInputOne()) && this.compareItemStacks(data.getStack2(), (ItemStack)entry.getKey().getInputTwo()))
            {
                return (ItemStack)entry.getValue().getOutput();
            }
        }

        return null;
    }

	
	public ItemStack getSmeltingResult(ItemStack itemStack1, ItemStack itemStack2) {
		
		
		/**
		 * This is my old code. Shhhhhh. ¯\_(ツ)_/¯
		 */
		/*if (itemStack1.getItem() == Items.IRON_INGOT && itemStack2.getItem() == Items.IRON_INGOT) {
			return new ItemStack(Items.GOLD_INGOT);
		} else if (itemStack1.getItem() == Items.GOLD_INGOT && itemStack2.getItem() == Items.IRON_INGOT) {
			return new ItemStack(Items.DIAMOND);
		} else if (itemStack1.getItem() == Items.GOLD_INGOT && itemStack2.getItem() == Items.DIAMOND) {
			return new ItemStack(Blocks.DIAMOND_BLOCK);
		}*/
		return getSmeltingResult(new InputData(itemStack1, itemStack2));
		
		// I know this code works. 
		/*Iterator iterator = this.smeltingList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}
			entry = (Entry) iterator.next();
		} while (!canBeSmelted(itemStack1, (ItemStack) entry.getKey()));
		//System.out.println((ItemStack) entry.getValue());
		return (ItemStack) entry.getValue();*/
		
	}
	public boolean getCanBeSmelted(InputData data) {
		 for (Entry<RecipeData, RecipeData> entry : this.smeltingResultList.entrySet())
	        {
	            if (this.compareItemStacks(data.getStack1(), (ItemStack)entry.getKey().getInputOne()) && this.compareItemStacks(data.getStack2(), (ItemStack)entry.getKey().getInputTwo()))
	            {
	                return true;
	            }
	        }

	        return false;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }
	
	public boolean canBeSmelted(ItemStack itemstack, ItemStack itemstack2) {
		//System.out.println(itemstack2.getItem() == itemstack.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack.getItemDamage()));
		return itemstack2.getItem() == itemstack.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack.getItemDamage());
	}
	
}