package com.brett.nimbix;

import com.brett.nimbix.blocks.GUI.BGUIHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {

	public void registerRenderThings() {

	}

	public void registerNetworkStuff() {
		EventHandler handler = new EventHandler();
		MinecraftForge.EVENT_BUS.register(handler);
		FMLCommonHandler.instance().bus().register(handler);
		NetworkRegistry.INSTANCE.registerGuiHandler(MainClass.modInstance, new BGUIHandler());
	}

	public void PreInit() {

	}

	public void Init() {

	}

	public void PostInit() {

	}

	public void registerModelBakeryVarients() {

	}

}
