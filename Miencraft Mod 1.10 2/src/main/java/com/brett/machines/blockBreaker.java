package com.brett.machines;

import com.brett.machines.tileEntity.tileBlockBreaker;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class blockBreaker extends Block implements ITileEntityProvider{

	public blockBreaker(Material materialIn) {
		super(materialIn);
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new tileBlockBreaker();
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new tileBlockBreaker();
	}

}
