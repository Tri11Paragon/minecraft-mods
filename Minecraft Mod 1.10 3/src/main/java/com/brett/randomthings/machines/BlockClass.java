package com.brett.randomthings.machines;

import com.brett.nimbix.MainClass;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class BlockClass {
	
	public static void Main(){
		init();
		register();
	}
	
	public static Block blockInfuser;
	
	public static void init(){
		blockInfuser = new blockInfuser(Material.ROCK).setCreativeTab(MainClass.modTab).setUnlocalizedName("Infuser").setRegistryName("Infuser");
	}
	
	public static void register(){
		GameRegistry.register(blockInfuser);
		GameRegistry.register(new ItemBlock(blockInfuser), blockInfuser.getRegistryName());
		OreDictionary.registerOre("Infuser", blockInfuser);
	}
	
}
