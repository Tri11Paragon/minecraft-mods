package com.brett.recipies;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {
	
	public static void register(){
		
	}
	
	public static void registerOre(String name, Block block){
		OreDictionary.registerOre(name, block);
	}
	public static void registerItem(String name, Item item){
		OreDictionary.registerOre(name, item);
	}
	
}
