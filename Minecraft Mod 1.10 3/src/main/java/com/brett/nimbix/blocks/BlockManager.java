package com.brett.nimbix.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest.Type;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.blocks.item.ItemOres;
import com.brett.nimbix.blocks.ores.Ores;
import com.brett.nimbix.helpers.EnumHandler;
import com.brett.nimbix.helpers.EnumHandler.OreTypes;
import com.brett.randomthings.machines.BlockClass;

public class BlockManager {
	public static void Main(){
		Init();
		Register();
	}
	public static Block mine;
	public static Block bigMine;
	public static Block Ore;
	
	public static void Init(){
		mine = new mine().setCreativeTab(MainClass.modTab).setUnlocalizedName("mine").setRegistryName("mine").setLightOpacity(0).setLightLevel(1);
		bigMine = new bigMine().setCreativeTab(MainClass.modTab).setUnlocalizedName("bigMine").setRegistryName("bigMine").setLightOpacity(0).setLightLevel(1);
		Ore = new Ores(Material.ROCK, OreTypes.IRIDIUM).setUnlocalizedName("Ores").setRegistryName("Ores").setCreativeTab(MainClass.modTab);
	}
	
	public static void Register(){
		register(Ore, new ItemOres(Ore));
		for (int i=0; i < EnumHandler.OreTypes.values().length; i++) {
			registerRender(Ore, i, EnumHandler.OreTypes.values()[i].getName());
		}
		
		GameRegistry.register(mine);
		GameRegistry.register(new ItemBlock(mine), mine.getRegistryName());
		
		GameRegistry.register(bigMine);
		GameRegistry.register(new ItemBlock(bigMine), bigMine.getRegistryName());
		System.out.println("REGISTERSED");
	}
	
	public static void register(Block block, ItemBlock itemBlock){
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
	}
	public static void register(Block block){
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block), block.getRegistryName());
	}
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(MainClass.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
	}
	
	public static void registerRender(Block item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(item),meta, new ModelResourceLocation(new ResourceLocation(MainClass.MODID, fileName), "inventory"));
	}
	
}
