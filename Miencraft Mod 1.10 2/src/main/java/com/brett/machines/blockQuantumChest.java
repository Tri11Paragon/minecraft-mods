package com.brett.machines;

import com.brett.machines.GUI.BGUIHandler;
import com.brett.machines.tileEntity.tileBlockInfuser;
import com.brett.machines.tileEntity.tileBlockQuantumChest;
import com.brett.nimbix.MainClass;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class blockQuantumChest extends Block implements ITileEntityProvider {

	public blockQuantumChest(Material materialIn) {
		super(materialIn);
		
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		tileBlockQuantumChest te = (tileBlockQuantumChest) worldIn.getTileEntity(pos);
		IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		for (int slot=0;slot<handler.getSlots()-1;slot++){
			ItemStack stack = handler.getStackInSlot(slot);
			InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
		}
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new tileBlockQuantumChest();
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new tileBlockQuantumChest();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote){
			playerIn.openGui(MainClass.modInstance, 4, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
	}

}