package com.brett.nimbix.items;

import com.brett.nimbix.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class Dust {
	public static void Main(){
		Init();
		Register();
	}
	
	public static Item FluxDust;
	public static Item CopperDust;
	public static Item LeadDust;
	public static Item TinDust;
	public static Item IronDust;
	public static Item CoalDust;
	public static Item CharcoalDust;
	public static Item GoldDust;
	public static Item DiamondDust;
	
	public static Item FluxIngot;
	public static Item CopperIngot;
	public static Item LeadIngot;
	public static Item TinIngot;
	
	public static void Init(){
		FluxDust = new Flux().setCreativeTab(MainClass.modTab).setUnlocalizedName("FluxDust").setRegistryName("FluxDust");
		CopperDust = new CopperDust().setCreativeTab(MainClass.modTab).setUnlocalizedName("CopperDust").setRegistryName("CopperDust");
		TinDust = new TinDust().setCreativeTab(MainClass.modTab).setUnlocalizedName("TinDust").setRegistryName("TinDust");
		IronDust = new IronDust().setCreativeTab(MainClass.modTab).setUnlocalizedName("IronDust").setRegistryName("IronDust");
		CoalDust = new CoalDust().setCreativeTab(MainClass.modTab).setUnlocalizedName("CoalDust").setRegistryName("CoalDust");
		CharcoalDust = new CharcoalDust().setCreativeTab(MainClass.modTab).setUnlocalizedName("CharcoalDust").setRegistryName("CharcoalDust");
		GoldDust = new GoldDust().setCreativeTab(MainClass.modTab).setUnlocalizedName("GoldDust").setRegistryName("GoldDust");
		DiamondDust = new DiamondDust().setCreativeTab(MainClass.modTab).setUnlocalizedName("DiamondDust").setRegistryName("DiamondDust");
		LeadDust = new LeadDust().setCreativeTab(MainClass.modTab).setUnlocalizedName("LeadDust").setRegistryName("LeadDust");
		
		FluxIngot = new FluxIngot().setCreativeTab(MainClass.modTab).setUnlocalizedName("FluxIngot").setRegistryName("FluxIngot");
		CopperIngot = new CopperIngot().setCreativeTab(MainClass.modTab).setUnlocalizedName("CopperIngot").setRegistryName("CopperIngot");
		TinIngot = new TinIngot().setCreativeTab(MainClass.modTab).setUnlocalizedName("TinIngot").setRegistryName("TinIngot");
		LeadIngot = new LeadIngot().setCreativeTab(MainClass.modTab).setUnlocalizedName("LeadIngot").setRegistryName("LeadIngot");
	}
	public static void Register(){
		GameRegistry.register(FluxDust);
		GameRegistry.register(CopperDust);
		GameRegistry.register(TinDust);
		GameRegistry.register(IronDust);
		GameRegistry.register(CoalDust);
		GameRegistry.register(CharcoalDust);
		GameRegistry.register(GoldDust);
		GameRegistry.register(DiamondDust);
		GameRegistry.register(LeadDust);
		
		GameRegistry.register(FluxIngot);
		GameRegistry.register(CopperIngot);
		GameRegistry.register(TinIngot);
		GameRegistry.register(LeadIngot);
		
		OreDictionary.registerOre("ingotLead", LeadIngot);
		OreDictionary.registerOre("ingotCopper", CopperIngot);
		OreDictionary.registerOre("ingotTin", TinIngot);
		
		OreDictionary.registerOre("dustLead", LeadDust);
		OreDictionary.registerOre("dustCopper", CopperDust);
		OreDictionary.registerOre("dustTin", TinDust);
		OreDictionary.registerOre("dustIron", IronDust);
		OreDictionary.registerOre("dustCoal", CoalDust);
		OreDictionary.registerOre("dustCharcoal", CharcoalDust);
		OreDictionary.registerOre("dustGold", GoldDust);
		OreDictionary.registerOre("dustDiamond", DiamondDust);
	}
}
