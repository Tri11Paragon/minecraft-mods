package com.brett.nimbix;

import com.brett.nimbix.client.render.BlockRenderHandler;
import com.brett.nimbix.client.render.ItemRenderHandler;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	public static void renderStuff() {
		
	}
	
	public void PreInit(){
		
	}
	
	public void Init(){
		RenderItemsAndBlocks();
	}
	
	public void PostInit(){
		
	}
	
	public void RenderItemsAndBlocks(){
		ItemRenderHandler.registerItemRender();
		BlockRenderHandler.registerBlockRender();
	}
	
}
