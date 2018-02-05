package com.brett.nimbix.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.brett.nimbix.MainClass;

public class OtherBlocks {
	public static void Main(){
		Init();
		Register();
	}
	
	public static Block Teleporter;
	public static Block SolarPannel;
	
	public static void Init(){
		Teleporter = new Teleporter(Material.CIRCUITS).setCreativeTab(MainClass.modTab).setUnlocalizedName("Teleporter").setRegistryName("Teleporter");
		SolarPannel = new SolarPannel(Material.CIRCUITS).setCreativeTab(MainClass.modTab).setUnlocalizedName("SolarPannel").setRegistryName("SolarPannel");
	}
	public static void Register(){
		
		GameRegistry.register(Teleporter);
		GameRegistry.register(new ItemBlock(Teleporter), Teleporter.getRegistryName());
		
		GameRegistry.register(SolarPannel);
		GameRegistry.register(new ItemBlock(SolarPannel), SolarPannel.getRegistryName());
		
		System.out.println("REGISTERSED");
	}
}
