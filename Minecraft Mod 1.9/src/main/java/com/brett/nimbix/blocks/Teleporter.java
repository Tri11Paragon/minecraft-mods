package com.brett.nimbix.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import com.brett.nimbix.items.teleporterMemory;
import com.brett.nimbix.tileentity.TileEntityTeleporter;

public class Teleporter extends Block implements ITileEntityProvider {

	
	
	public Teleporter(Material materialIn) {
		super(materialIn);
		setHarvestLevel("pickaxe", 3);
		setHardness(5.0f);
		setResistance(5.0f);
	}
	
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    } 
	
	@Override
	public boolean isFullCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		// TODO Auto-generated method stub
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityTeleporter();
	}
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {	
		ItemStack stack = null;
		if(playerIn.getHeldItemMainhand() != null){
			 stack = playerIn.getHeldItemMainhand();
			 System.out.println(stack.getItem().getUnlocalizedName().substring(5));
		}
		if(stack != null)
		{
			if(stack.getItem() instanceof teleporterMemory)
			{
				if(stack.getTagCompound() != null && stack.getTagCompound().getTag("Cords") != null)
				{
					
					TileEntityTeleporter tect = (TileEntityTeleporter) worldIn.getTileEntity(pos);
					
					//System.out.println("NBT GOT" + tect.getBlockPos());
					
					tect.addEntry("THING", stack);
					
					//stack.stackSize--;
					playerIn.addChatComponentMessage(new TextComponentString("Added cordinate cache to tile entity " + tect.getBlockPos()));
				} else {
					playerIn.addChatComponentMessage(new TextComponentString("Please Right-Click Block With an Active TeleporterMemory!"));
				}
			} 
		} else {
			TileEntityTeleporter tect = (TileEntityTeleporter) worldIn.getTileEntity(pos);
			if(tect.getBlockPos() != null && tect.getBlockPos().getX() != 0 && tect.getBlockPos().getZ() != 0 && tect.getBlockPos().getZ() != 0)
			{
				
				
				
				//System.out.println("NBT GOT" + tect.getBlockPos());
				playerIn.attemptTeleport(tect.getBlockPos().getX(), tect.getBlockPos().getY() + 1, tect.getBlockPos().getZ());
				
				//playerIn.addChatComponentMessage(new TextComponentString("TECT" + tect.getBlockPos()));
				//stack.stackSize--;
				playerIn.addChatComponentMessage(new TextComponentString("Teleporting!"));
			} else {
				playerIn.addChatComponentMessage(new TextComponentString("Please Right-Click Block With an Active TeleporterMemory!"));
			}
		}
		//TileEntityTeleporter tect = (TileEntityTeleporter) worldIn.getTileEntity(pos);
		//playerIn.addChatComponentMessage(new TextComponentString("Added cordinate cache to tile entity " + tect.getBlockPos()));
		return true;
    }

}
