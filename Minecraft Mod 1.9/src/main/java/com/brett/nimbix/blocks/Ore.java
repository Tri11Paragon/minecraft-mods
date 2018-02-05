package com.brett.nimbix.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.items.Flux;

public class Ore {
	public static void Main(){
		Init();
		Register();
	}
	
	public static Block Copper;
	public static Block Tin;
	public static Block Lead;
	
	public static void Init(){
		Copper = new CopperOre(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("CopperOre").setRegistryName("CopperOre");
		Tin = new TinOre(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("TinOre").setRegistryName("TinOre");
		Lead = new LeadOre(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("LeadOre").setRegistryName("LeadOre");

	}
	public static void Register(){
		GameRegistry.register(Copper);
		GameRegistry.register(new ItemBlock(Copper), Copper.getRegistryName());
		OreDictionary.registerOre("oreCopper", Copper);
		
		GameRegistry.register(Tin);
		GameRegistry.register(new ItemBlock(Tin), Tin.getRegistryName());
		OreDictionary.registerOre("oreTin", Tin);
		
		GameRegistry.register(Lead);
		GameRegistry.register(new ItemBlock(Lead), Lead.getRegistryName());
		OreDictionary.registerOre("oreLead", Lead);
		
		System.out.println("REGISTERSED");
	}
}
