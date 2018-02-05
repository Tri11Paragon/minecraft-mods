package com.brett.randomthings.machines;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.blocks.GUI.BGUIHandler;
import com.brett.randomthings.machines.tileEntity.tileBlockInfuser;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class blockInfuser extends Block implements ITileEntityProvider {

	public blockInfuser(Material materialIn) {
		super(materialIn);
		// this.setLightOpacity(1);
		this.setHardness(8);
		this.setHarvestLevel("Pickaxe", 1);
		this.setResistance(10);
		this.setLightLevel(1);
	}

	/*
	 * @Override public void breakBlock(World worldIn, BlockPos pos, IBlockState
	 * state) { super.breakBlock(worldIn, pos, state); tileBlockInfuser te =
	 * (tileBlockInfuser) worldIn.getTileEntity(pos); IItemHandler handler =
	 * te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null); for
	 * (int slot=0;slot<handler.getSlots()-1;slot++){ ItemStack stack =
	 * handler.getStackInSlot(slot); InventoryHelper.spawnItemStack(worldIn,
	 * pos.getX(), pos.getY(), pos.getZ(), stack); } }
	 */

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new tileBlockInfuser();
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new tileBlockInfuser();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			playerIn.openGui(MainClass.modInstance, BGUIHandler.BLOCK_INFUSER, worldIn, pos.getX(), pos.getY(),
					pos.getZ());
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
	}

}
