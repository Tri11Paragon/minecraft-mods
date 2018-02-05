package com.brett.nimbix.items;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.blocks.bigMine;
import com.brett.nimbix.blocks.mine;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemManager {
	
	public static ToolMaterial staffofmining = EnumHelper.addToolMaterial("staffofmining", 22, 1000000000, 22, 10, 20);
	
	public static void Main(){
		Init();
		Register();
	}
	
	public static Item ironProcessorCore;
	public static Item ironGear;
	public static Item ironCPU;
	public static Item machineFrame;
	public static Item staffofpower;
	
	public static void Init(){
		ironProcessorCore = new Item().setCreativeTab(CreativeTabs.MATERIALS).setUnlocalizedName("ironProcessorCore").setRegistryName("ironProcessorCore");
		ironGear = new Item().setCreativeTab(CreativeTabs.MATERIALS).setUnlocalizedName("ironGear").setRegistryName("ironGear");
		ironCPU = new Item().setCreativeTab(CreativeTabs.MATERIALS).setUnlocalizedName("ironCPU").setRegistryName("ironCPU");
		machineFrame = new Item().setCreativeTab(CreativeTabs.MATERIALS).setUnlocalizedName("machineFrame").setRegistryName("machineFrame");
		staffofpower = new StaffOfPower(staffofmining, 200, 1000000).setCreativeTab(CreativeTabs.MATERIALS).setUnlocalizedName("staffofpower").setRegistryName("staffofpower");
	}
	public static void register(Item block){
		GameRegistry.register(block);
	}
	public static void Register(){
		GameRegistry.register(ironProcessorCore);
		GameRegistry.register(ironGear);
		GameRegistry.register(ironCPU);
		GameRegistry.register(machineFrame);
		GameRegistry.register(staffofpower);
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(MainClass.MODID, item.getUnlocalizedName()), "inventory"));
	}
	
	public static void registerRender(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item,meta, new ModelResourceLocation(new ResourceLocation(MainClass.MODID, fileName), "inventory"));
	}
	
}
