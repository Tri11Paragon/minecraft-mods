package com.brett.nimbix.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.blocks.Ore;
import com.brett.nimbix.blocks.OtherBlocks;
import com.brett.nimbix.items.Dust;

public class BlockRenderHandler {
	
	public static void registerBlockRender(){
		register(Ore.Copper);
		register(Ore.Lead);
		register(Ore.Tin);
		register(OtherBlocks.Teleporter);
		register(OtherBlocks.SolarPannel);
	}
	
	public static void register(Block block){
		
		Item item = Item.getItemFromBlock(block);
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MainClass.MODID + ":" + block.getUnlocalizedName().substring(5),"inventory"));
		System.out.println("Block Model Loaded!");
	}
}
