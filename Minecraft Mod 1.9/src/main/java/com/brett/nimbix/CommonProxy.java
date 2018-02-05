package com.brett.nimbix;

import net.minecraftforge.fml.common.network.NetworkRegistry;


public class CommonProxy {
	

	public void registerRenderThings() {
		
	}
	
	public void registerNetworkStuff(){
		NetworkRegistry.INSTANCE.registerGuiHandler(MainClass.modInstance, new BGUIHandler());
	}
	
	public void PreInit(){
		
	}
	
	public void Init(){
		
	}
	
	public void PostInit(){
		
	}

}
