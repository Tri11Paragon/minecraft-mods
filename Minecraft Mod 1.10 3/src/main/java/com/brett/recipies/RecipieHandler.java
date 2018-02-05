package com.brett.recipies;

import javax.crypto.Mac;

import com.brett.nimbix.blocks.BlockManager;
import com.brett.nimbix.items.ItemManager;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class RecipieHandler {
	
	public static void registerCrafting(){
		GameRegistry.addRecipe(new ItemStack(BlockManager.mine, 1), new Object[]{"cyc", "yxy", "cpc", 'x', ItemManager.machineFrame, 'y', ItemManager.ironGear, 'c', Items.IRON_INGOT, 'p', Items.IRON_PICKAXE});
		GameRegistry.addRecipe(new ItemStack(ItemManager.ironProcessorCore, 1), new Object[]{"zyz", "yxy", "zyz", 'x', Items.REDSTONE, 'y', Items.IRON_INGOT, 'z', Items.GOLD_INGOT});
		GameRegistry.addRecipe(new ItemStack(ItemManager.ironGear, 1), new Object[]{" y ", "yyy", " y ", 'x', Items.REDSTONE, 'y', Items.IRON_INGOT, 'z', Items.GOLD_INGOT});
		GameRegistry.addRecipe(new ItemStack(ItemManager.ironCPU, 1), new Object[]{"zyz", "yxy", "zyz", 'x', ItemManager.ironProcessorCore, 'y', new ItemStack(Items.DYE, 1, 4), 'z', Items.REDSTONE});
		GameRegistry.addRecipe(new ItemStack(ItemManager.staffofpower, 1), new Object[]{" yp", "yzy", "xy ", 'x', ItemManager.ironCPU, 'y', Blocks.DIAMOND_BLOCK, 'z', Items.DIAMOND_PICKAXE, 'p', BlockManager.bigMine});
		GameRegistry.addRecipe(new ItemStack(ItemManager.machineFrame, 1), new Object[]{"zyz", "yxy", "zyz", 'x', ItemManager.ironCPU, 'y', Blocks.GLASS, 'z', Items.IRON_INGOT});
		GameRegistry.addRecipe(new ItemStack(BlockManager.bigMine, 1), new Object[]{"cyc", "xxx", "ypy", 'x', BlockManager.mine, 'y', ItemManager.ironGear, 'c', Blocks.IRON_BLOCK, 'p', Items.DIAMOND_PICKAXE});
	}
}
