package com.brett.nimbix.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest.Type;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.brett.crafters.BlockGrinder;
import com.brett.machines.BlockClass;
import com.brett.nimbix.MainClass;

public class Ore {
	public static void Main(){
		Init();
		Register();
		BlockClass.init();
		BlockClass.register();
	}
	
	public static Block Copper;
	public static Block Tin;
	public static Block Lead;
	public static Block SolarFluxOre;
	public static Block TestBlock;
	public static Block SolarCollector;
	public static Block Infuser;
	public static Block lamp;
	public static Block testTile;
	public static Block fusionCrafter;
	public static Block kaboom;
	public static Block mine;
	public static Block bigKaboom;
	public static Block crackedBedrock;
	public static Block tester;
	
	public static void Init(){
		Copper = new CopperOre(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("CopperOre").setRegistryName("CopperOre");
		Tin = new TinOre(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("TinOre").setRegistryName("TinOre");
		Lead = new LeadOre(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("LeadOre").setRegistryName("LeadOre");
		SolarFluxOre = new SolarFluxOre(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("SolarFluxOre").setRegistryName("SolarFluxOre");
		TestBlock = new TestBlock (Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("TestBlock").setRegistryName("TestBlock");
		SolarCollector = new SolarCollector(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("SolarCollector").setRegistryName("SolarCollector");
		Infuser = new Infuser().setCreativeTab(MainClass.modTab).setUnlocalizedName("Infuser").setRegistryName("Infuser");
		lamp = new lamp().setCreativeTab(MainClass.modTab).setUnlocalizedName("lamp").setRegistryName("lamp");
		testTile = new testTile(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("testTile").setRegistryName("testTile");
		fusionCrafter = new BlockGrinder().setCreativeTab(MainClass.modTab).setUnlocalizedName("fusionCrafters").setRegistryName("fusionCrafters");
		kaboom = new kaboom().setCreativeTab(MainClass.modTab).setUnlocalizedName("kaboom").setRegistryName("kaboom");
		mine = new mine().setCreativeTab(MainClass.modTab).setUnlocalizedName("mine").setRegistryName("mine");
		bigKaboom = new bigKaboom().setCreativeTab(MainClass.modTab).setUnlocalizedName("bigKaboom").setRegistryName("bigKaboom");
		crackedBedrock = new CrackedBedrock(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("crackedBedrock").setRegistryName("crackedBedrock");
		tester = new Tester().setCreativeTab(MainClass.modTab).setUnlocalizedName("Tester").setRegistryName("Tester");
	}
	public static void register(Block block){
		GameRegistry.register(block);
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
		
		GameRegistry.register(SolarFluxOre);
		GameRegistry.register(new ItemBlock(SolarFluxOre), SolarFluxOre.getRegistryName());
		
		GameRegistry.register(TestBlock);
		GameRegistry.register(new ItemBlock(TestBlock), TestBlock.getRegistryName());
		
		GameRegistry.register(SolarCollector);
		GameRegistry.register(new ItemBlock(SolarCollector), SolarCollector.getRegistryName());
		
		GameRegistry.register(Infuser);
		GameRegistry.register(new ItemBlock(Infuser), Infuser.getRegistryName());
		
		GameRegistry.register(lamp);
		GameRegistry.register(new ItemBlock(lamp), lamp.getRegistryName());
		
		GameRegistry.register(fusionCrafter);
		GameRegistry.register(new ItemBlock(fusionCrafter), fusionCrafter.getRegistryName());
		
		GameRegistry.register(testTile);
		GameRegistry.register(new ItemBlock(testTile), testTile.getRegistryName());
		GameRegistry.register(kaboom);
		GameRegistry.register(new ItemBlock(kaboom), kaboom.getRegistryName());
		GameRegistry.register(crackedBedrock);
		GameRegistry.register(new ItemBlock(crackedBedrock), crackedBedrock.getRegistryName());
		GameRegistry.register(bigKaboom);
		GameRegistry.register(new ItemBlock(bigKaboom), bigKaboom.getRegistryName());
		GameRegistry.register(tester);
		GameRegistry.register(new ItemBlock(tester), tester.getRegistryName());
		GameRegistry.register(mine);
		GameRegistry.register(new ItemBlock(mine), mine.getRegistryName());
		
		System.out.println("REGISTERSED");
	}
}
