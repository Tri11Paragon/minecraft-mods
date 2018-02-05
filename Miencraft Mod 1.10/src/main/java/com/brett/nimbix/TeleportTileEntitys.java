package com.brett.nimbix;

import com.brett.nimbix.blocks.PowerGenerator;
import com.brett.nimbix.tileentitys.TestBlockTileEntity;
import com.brett.nimbix.tileentitys.TileEntityInfuser;
import com.brett.nimbix.tileentitys.TileLamp;
import com.brett.nimbix.tileentitys.TileTest;
import com.brett.nimbix.tileentitys.TileTritaniumChest;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TeleportTileEntitys {
	
	public static void register(){
		GameRegistry.registerTileEntity(PowerGenerator.class, "modGenerator");
		GameRegistry.registerTileEntity(TestBlockTileEntity.class, "modTestBlock");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "modInfuser");
		GameRegistry.registerTileEntity(TileLamp.class, "modlamp");
		GameRegistry.registerTileEntity(TileTest.class, "modtest");
		GameRegistry.registerTileEntity(TileTritaniumChest.class, "modTritaniumChest");
	}
	
}
