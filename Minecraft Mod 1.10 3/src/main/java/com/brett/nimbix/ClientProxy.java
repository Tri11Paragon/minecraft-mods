package com.brett.nimbix;

import com.brett.nimbix.blocks.BlockManager;
import com.brett.nimbix.blocks.GUI.BGUIHandler;
import com.brett.renders.ModelLoader;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
	
	public static void renderStuff() {
		
	}
	
	public void PreInit(){
		
	}
	
	public void Init(){
		RenderItemsAndBlocks();
		NetworkRegistry.INSTANCE.registerGuiHandler(MainClass.modInstance, new BGUIHandler());
	}
	
	public void PostInit(){
		
	}
	
	public void RenderItemsAndBlocks(){
		ModelLoader.register();
		BlockManager.RegisterRenderer();
		registerModelBakeryVarients();
	}
	
	@Override
	public void registerModelBakeryVarients() {
		ModelBakery.registerItemVariants(Item.getItemFromBlock(BlockManager.Ore), new ResourceLocation(MainClass.MODID, "thallium"), new ResourceLocation(MainClass.MODID, "iridium"));
	}
	
}
