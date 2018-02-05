package com.brett.nimbix;

import com.brett.nimbix.helpers.PowerGenerator;
import com.brett.nimbix.tileentity.TileEntitySolarPannel;
import com.brett.nimbix.tileentity.TileEntityTeleporter;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TeleportTileEntitys {
	
	public static void register(){
		GameRegistry.registerTileEntity(TileEntityTeleporter.class, "modTeleporter");
		GameRegistry.registerTileEntity(TileEntitySolarPannel.class, "modSolarPannel");
		GameRegistry.registerTileEntity(PowerGenerator.class, "modGenerator");
	}
	
}
