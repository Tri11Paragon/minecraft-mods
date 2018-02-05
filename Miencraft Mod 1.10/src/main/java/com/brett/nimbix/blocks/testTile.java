package com.brett.nimbix.blocks;

import javax.annotation.Nullable;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.tileentitys.TileLamp;
import com.brett.nimbix.tileentitys.TileTest;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class testTile extends Block implements ITileEntityProvider {

	public testTile(Material materialIn) {
		super(materialIn);
		
	}

    @Override
    public TileEntity createNewTileEntity(final World world, final int i) {
        return new TileTest();
    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		playerIn.openGui(MainClass.modInstance, 2, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
    }
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
		TileTest te = (TileTest) world.getTileEntity(pos);
	    InventoryHelper.dropInventoryItems(world, pos, te);
	    super.breakBlock(world, pos, blockstate);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
	    if (stack.hasDisplayName()) {
	        ((TileTest) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
	    }
	}
	@Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
	
}
