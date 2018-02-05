package com.brett.renders;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.blocks.BlockManager;
import com.brett.nimbix.items.ItemManager;
import com.brett.randomthings.machines.BlockClass;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ModelLoader {
	
	public static void register(){
		register(BlockManager.mine);
		register(BlockManager.bigMine);
		register(ItemManager.ironProcessorCore);
		register(ItemManager.ironGear);
		register(ItemManager.ironCPU);
		register(ItemManager.machineFrame);
		register(ItemManager.staffofpower);
		register(BlockClass.blockInfuser);
	}
	public static void register(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MainClass.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
		System.out.println("Item Model Loaded!");
	}
	public static void register(Block block){
		
		Item item = Item.getItemFromBlock(block);
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MainClass.MODID + ":" + block.getUnlocalizedName().substring(5),"inventory"));
		System.out.println("Block Model Loaded!");
	}
}
