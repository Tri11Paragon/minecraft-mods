package com.brett.nimbix.blocks.GUI;

import com.brett.nimbix.blocks.container.ContainerMine;
import com.brett.nimbix.blocks.te.tileMine;
import com.brett.randomthings.machines.Container.ContainerInfuser;
import com.brett.randomthings.machines.GUI.GUIInfuser;
import com.brett.randomthings.machines.tileEntity.tileBlockInfuser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class BGUIHandler implements IGuiHandler {

	public static final int BLOCK_INFUSER = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		if(ID == 0){
			tileMine tileEntityFurnace = (tileMine) world.getTileEntity(new BlockPos(x, y, z));
			return new ContainerMine(player.inventory, tileEntityFurnace);
		}
		if(ID == BLOCK_INFUSER){
			tileBlockInfuser tileEntityFurnace = (tileBlockInfuser) world.getTileEntity(new BlockPos(x, y, z));
			return new ContainerInfuser(player.inventory, tileEntityFurnace);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		if(ID == 0){
			tileMine tileEntityTestContainer = (tileMine) world.getTileEntity(new BlockPos(x, y, z));
			return new GUIMine(player.inventory, tileEntityTestContainer);
		}
		if(ID == BLOCK_INFUSER){
			tileBlockInfuser tileEntityTestContainer = (tileBlockInfuser) world.getTileEntity(new BlockPos(x, y, z));
			return new GUIInfuser(player.inventory, tileEntityTestContainer);
		}
		return null;
	}

}
