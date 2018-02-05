package com.brett.nimbix;

import com.brett.machines.GUI.BGUIHandler;
import com.brett.renders.ModelLoader;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
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
	}
	
}
