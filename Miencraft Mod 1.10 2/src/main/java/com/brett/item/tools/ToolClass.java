package com.brett.item.tools;

import java.util.Set;

import com.brett.nimbix.MainClass;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ToolClass {
	
	public static ToolMaterial QuantumMateiral = EnumHelper.addToolMaterial("QuantumM", 550, 5000, 18, 8, 12);
	public static ToolMaterial AdvQuantumMateiral = EnumHelper.addToolMaterial("AdvQuantumM", 1050, 0, 50, 18, 16);
	
	public static Item QuantumPickaxe;
	public static Item QuantumAxe;
	public static Item QuantumShovel;
	public static Item QuantumSword;
	
	public static Item AdvancedQuantumPickaxe;
	public static Item AdvancedQuantumAxe;
	public static Item AdvancedQuantumShovel;
	public static Item AdvancedQuantumSword;
	
	public static void Main(){
		init();
		register();
	}
	
	public static void init(){
		QuantumPickaxe = new QuantumPickaxe(QuantumMateiral).setCreativeTab(MainClass.modTab).setUnlocalizedName("QuantumPickaxe").setRegistryName("QuantumPickaxe");
		QuantumAxe = new QuantumAxe(QuantumMateiral, 16, -3.2f).setCreativeTab(MainClass.modTab).setUnlocalizedName("QuantumAxe").setRegistryName("QuantumAxe");
		QuantumShovel = new QuantumShovel(QuantumMateiral).setCreativeTab(MainClass.modTab).setUnlocalizedName("QuantumShovel").setRegistryName("QuantumShovel");
		QuantumSword = new QuantumSword(QuantumMateiral).setCreativeTab(MainClass.modTab).setUnlocalizedName("QuantumSword").setRegistryName("QuantumSword");
		
		AdvancedQuantumPickaxe = new AdvancedQuantumPickaxe(AdvQuantumMateiral, 200, 10000000, new int[]{0,1,2}).setCreativeTab(MainClass.modTab).setUnlocalizedName("AdvancedQuantumPickaxe").setRegistryName("AdvancedQuantumPickaxe");
		AdvancedQuantumAxe = new AdvancedQuantumAxe(AdvQuantumMateiral).setCreativeTab(MainClass.modTab).setUnlocalizedName("AdvancedQuantumAxe").setRegistryName("AdvancedQuantumAxe");
		AdvancedQuantumShovel = new AdvancedQuantumShovel(AdvQuantumMateiral).setCreativeTab(MainClass.modTab).setUnlocalizedName("AdvancedQuantumShovel").setRegistryName("AdvancedQuantumShovel");
		AdvancedQuantumSword = new AdvancedQuantumSword(AdvQuantumMateiral).setCreativeTab(MainClass.modTab).setUnlocalizedName("AdvancedQuantumSword").setRegistryName("AdvancedQuantumSword");
	}
	
	public static void register(){
		GameRegistry.register(QuantumPickaxe);
		GameRegistry.register(QuantumAxe);
		GameRegistry.register(QuantumShovel);
		GameRegistry.register(QuantumSword);
		
		GameRegistry.register(AdvancedQuantumPickaxe);
		GameRegistry.register(AdvancedQuantumAxe);
		GameRegistry.register(AdvancedQuantumShovel);
		GameRegistry.register(AdvancedQuantumSword);
	}
	
	public static void registerItem(Item item){
		item.setCreativeTab(MainClass.modTab);
		GameRegistry.register(item);
	}
}
