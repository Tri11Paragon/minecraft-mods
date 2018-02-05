package com.brett.powermod;

import cpw.mods.fml.common.network.NetworkRegistry;


public class CommonProxy {
	

	public void registerRenderThings() {
		
	}
	
	public void registerNetworkStuff(){
		NetworkRegistry.INSTANCE.registerGuiHandler(MainClass.modInstance, new BGUIHandler());
	}

}
