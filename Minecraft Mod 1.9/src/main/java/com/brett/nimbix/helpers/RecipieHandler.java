package com.brett.nimbix.helpers;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.brett.nimbix.items.Dust;

public class RecipieHandler {
	
	public static void registerCrafting(){
		GameRegistry.addRecipe(new ItemStack(Dust.FluxDust, 4), new Object[]{"xxx", "yyy", "xxx", 'x', Items.REDSTONE, 'y', Items.IRON_INGOT});
	}
	
	public static void registerSmelting(){
		
	}

	public void registerArmor(ItemStack itemMaterial, ItemStack healment, ItemStack chestplate, ItemStack legs, ItemStack boots){
		GameRegistry.addRecipe(healment, new Object[]{"xxx", "xox", "ooo", 'x', itemMaterial});
		GameRegistry.addRecipe(chestplate, new Object[]{"xox", "xxx", "xxx", 'x', itemMaterial});
		GameRegistry.addRecipe(legs, new Object[]{"xxx", "xox", "xox", 'x', itemMaterial});
		GameRegistry.addRecipe(boots, new Object[]{"ooo", "xox", "xox", 'x', itemMaterial});
	}
	
	public void registerTool(){
		
	}
}
