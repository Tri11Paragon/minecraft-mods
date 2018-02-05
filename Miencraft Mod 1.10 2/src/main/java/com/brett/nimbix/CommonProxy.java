package com.brett.nimbix;

import com.brett.machines.GUI.BGUIHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;


public class CommonProxy {
	

	public void registerRenderThings() {
		
	}
	
	public void registerNetworkStuff(){
		MinecraftForge.EVENT_BUS.register(com.brett.nimbix.helpers.EventHandler.class);
		NetworkRegistry.INSTANCE.registerGuiHandler(MainClass.modInstance, new BGUIHandler());
	}
	
	public void PreInit(){
		
	}
	
	public void Init(){
		
	}
	
	public void PostInit(){
		
	}

}
