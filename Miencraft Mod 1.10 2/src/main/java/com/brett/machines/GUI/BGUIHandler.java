package com.brett.machines.GUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.brett.machines.Container.ContainerInfuser;
import com.brett.machines.Container.ContainerQuantumChest;
import com.brett.machines.tileEntity.tileBlockInfuser;
import com.brett.machines.tileEntity.tileBlockQuantumChest;
import com.brett.nimbix.blocks.PowerGenerator;
import com.brett.nimbix.container.ContainerGenerator;
import com.brett.nimbix.container.ContainerInfuserOLD;
import com.brett.nimbix.container.ContainerTestTile;
import com.brett.nimbix.gui.GUIPowerGenerator;
import com.brett.nimbix.gui.GUItestTile;
import com.brett.nimbix.gui.GuiInfuserOLD;
import com.brett.nimbix.tileentitys.TileEntityInfuser;
import com.brett.nimbix.tileentitys.TileTest;
import com.brett.nimbix.tileentitys.TileTritaniumChest;

public class BGUIHandler implements IGuiHandler {

	public static final int BLOCK_INFUSER = 3;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		if(ID == 0){
			PowerGenerator tileEntityFurnace = (PowerGenerator) world.getTileEntity(new BlockPos(x, y, z));
			return new ContainerGenerator(player.inventory, tileEntityFurnace);
		}
		if(ID == 1){
			TileEntityInfuser tileEntityFurnace = (TileEntityInfuser) world.getTileEntity(new BlockPos(x, y, z));
			return new ContainerInfuserOLD(player.inventory, tileEntityFurnace);
		}
		if(ID == 2){
			TileTest tileEntityFurnace = (TileTest) world.getTileEntity(new BlockPos(x, y, z));
			return new ContainerTestTile(player.inventory, tileEntityFurnace);
		}
		if(ID == 3){
			tileBlockInfuser tileEntityFurnace = (tileBlockInfuser) world.getTileEntity(new BlockPos(x, y, z));
			return new ContainerInfuser(player.inventory, tileEntityFurnace);
		}
		if(ID == 4){
			tileBlockQuantumChest tileEntityFurnace = (tileBlockQuantumChest) world.getTileEntity(new BlockPos(x, y, z));
			return new ContainerQuantumChest(player.inventory, tileEntityFurnace);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		if(ID == 0){
			PowerGenerator tileEntityTestContainer = (PowerGenerator) world.getTileEntity(new BlockPos(x, y, z));
			return new GUIPowerGenerator(player.inventory, tileEntityTestContainer);
		}
		if(ID == 1){
			TileEntityInfuser tileEntityTestContainer = (TileEntityInfuser) world.getTileEntity(new BlockPos(x, y, z));
			return new GuiInfuserOLD(player.inventory, tileEntityTestContainer);
		}
		if(ID == 2){
			TileTest tileEntityTestContainer = (TileTest) world.getTileEntity(new BlockPos(x, y, z));
			return new GUItestTile(player.inventory, tileEntityTestContainer);
		}
		if(ID == 3){
			tileBlockInfuser tileEntityTestContainer = (tileBlockInfuser) world.getTileEntity(new BlockPos(x, y, z));
			return new GUIInfuser(player.inventory, tileEntityTestContainer);
		}
		if(ID == 4){
			tileBlockQuantumChest tileEntityTestContainer = (tileBlockQuantumChest) world.getTileEntity(new BlockPos(x, y, z));
			return new GUIQuantumChest(player.inventory, tileEntityTestContainer);
		}
		return null;
	}

}
