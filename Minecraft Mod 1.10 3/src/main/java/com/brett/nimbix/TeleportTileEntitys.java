package com.brett.nimbix;

import com.brett.nimbix.blocks.te.tileMine;
import com.brett.randomthings.machines.tileEntity.tileBlockInfuser;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TeleportTileEntitys {
	
	public static void register(){
		GameRegistry.registerTileEntity(tileMine.class, "tileMine");
		GameRegistry.registerTileEntity(tileBlockInfuser.class, "tileInfuser");
	}
	
}
