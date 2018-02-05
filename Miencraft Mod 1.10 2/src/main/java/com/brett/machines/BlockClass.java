package com.brett.machines;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.blocks.CopperOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class BlockClass {
	
	public static Block blockInfuser;
	public static Block blockBreaker;
	public static Block blockQuantumChest;
	
	public static void init(){
		blockInfuser = new blockInfuser(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("blockInfuser").setRegistryName("blockInfuser");
		blockBreaker = new blockBreaker(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("blockBreaker").setRegistryName("blockBreaker");
		blockQuantumChest = new blockQuantumChest(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("blockQuantumChest").setRegistryName("blockQuantumChest");
	}
	
	public static void register(){
		GameRegistry.register(blockInfuser);
		GameRegistry.register(new ItemBlock(blockInfuser), blockInfuser.getRegistryName());
		OreDictionary.registerOre("blockInfuser", blockInfuser);
		
		GameRegistry.register(blockBreaker);
		GameRegistry.register(new ItemBlock(blockBreaker), blockBreaker.getRegistryName());
		OreDictionary.registerOre("blockBreaker", blockBreaker);
		
		GameRegistry.register(blockQuantumChest);
		GameRegistry.register(new ItemBlock(blockQuantumChest), blockQuantumChest.getRegistryName());
		OreDictionary.registerOre("blockQuantumChest", blockQuantumChest);
	}
	
}
