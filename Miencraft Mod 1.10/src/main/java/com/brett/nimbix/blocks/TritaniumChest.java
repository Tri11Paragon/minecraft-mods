package com.brett.nimbix.blocks;

import java.awt.image.TileObserver;

import javax.annotation.Nullable;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.tileentitys.TileTritaniumChest;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TritaniumChest extends Block implements ITileEntityProvider {

	protected TritaniumChest(Material m) {
		super(m);
	}
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileTritaniumChest();
    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		playerIn.openGui(MainClass.modInstance, 3, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
    }


}
