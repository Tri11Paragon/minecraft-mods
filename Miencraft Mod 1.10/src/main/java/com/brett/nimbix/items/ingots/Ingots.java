package com.brett.nimbix.items.ingots;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.blocks.CopperOre;
import com.brett.nimbix.blocks.LeadOre;
import com.brett.nimbix.blocks.SolarCollector;
import com.brett.nimbix.blocks.SolarFluxOre;
import com.brett.nimbix.blocks.TestBlock;
import com.brett.nimbix.blocks.TinOre;

public class Ingots {
	public static void Main(){
		Init();
		Register();
	}
	
	public static Item copperIngot;
	public static Item tinIngot;
	public static Item leadIngot;
	public static Item bronzeIngot;
	public static Item solarIngot;
	public static Item steelIngot;
	public static Item tritaniumIngot;
	
	public static void Init(){
		copperIngot = new copperIngot().setCreativeTab(MainClass.modTab).setUnlocalizedName("copperIngot").setRegistryName("copperIngot");
		tinIngot = new tinIngot().setCreativeTab(MainClass.modTab).setUnlocalizedName("tinIngot").setRegistryName("tinIngot");
		leadIngot = new leadIngot().setCreativeTab(MainClass.modTab).setUnlocalizedName("leadIngot").setRegistryName("leadIngot");
		bronzeIngot = new bronzeIngot().setCreativeTab(MainClass.modTab).setUnlocalizedName("bronzeIngot").setRegistryName("bronzeIngot");
		solarIngot = new solarIngot().setCreativeTab(MainClass.modTab).setUnlocalizedName("solarIngot").setRegistryName("solarIngot");
		steelIngot = new steelIngot().setCreativeTab(MainClass.modTab).setUnlocalizedName("steelIngot").setRegistryName("steelIngot");
		tritaniumIngot = new tritaniumIngot().setCreativeTab(MainClass.modTab).setUnlocalizedName("tritaniumIngot").setRegistryName("tritaniumIngot");
	}
	public static void Register(){
		GameRegistry.register(copperIngot);
		OreDictionary.registerOre("ingotCopper", copperIngot);
		
		GameRegistry.register(tinIngot);
		OreDictionary.registerOre("ingotTin", tinIngot);
		
		GameRegistry.register(leadIngot);
		OreDictionary.registerOre("ingotLead", leadIngot);
		
		GameRegistry.register(bronzeIngot);
		OreDictionary.registerOre("ingotBronze", bronzeIngot);
		
		GameRegistry.register(solarIngot);
		OreDictionary.registerOre("ingotSolar", solarIngot);
		
		GameRegistry.register(steelIngot);
		OreDictionary.registerOre("ingotSteel", steelIngot);
		
		GameRegistry.register(tritaniumIngot);
		OreDictionary.registerOre("tritaniumIngot", tritaniumIngot);
		
		System.out.println("REGISTERSED");
	}
}
