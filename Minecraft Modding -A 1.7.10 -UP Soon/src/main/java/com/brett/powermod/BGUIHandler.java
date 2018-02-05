package com.brett.powermod;

import com.brett.powermod.entitys.ContainerInfuser;
import com.brett.powermod.entitys.ContainerTutFurnace;
import com.brett.powermod.entitys.GuiInfuser;
import com.brett.powermod.entitys.GuiTutFurnace;
import com.brett.powermod.entitys.TileEntityInfuser;
import com.brett.powermod.entitys.TileEntityTutFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class BGUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		if(ID == 0){
			TileEntityInfuser tileEntityFurnace = (TileEntityInfuser) world.getTileEntity(x, y, z);
			return new ContainerInfuser(player.inventory, tileEntityFurnace);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		if(ID == 0){
			TileEntityInfuser tileEntityTestContainer = (TileEntityInfuser) world.getTileEntity(x, y, z);
			return new GuiInfuser(player.inventory, tileEntityTestContainer);
		}
		return null;
	}

}
