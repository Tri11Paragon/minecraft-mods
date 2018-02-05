package com.brett.nimbix.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.brett.nimbix.MainClass;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class SolarCollector extends Block implements ITileEntityProvider {

	public SolarCollector(Material materialIn) {
		super(materialIn);
		setHarvestLevel("pickaxe", 1);
		setHardness(10.0f);
		setResistance(5.0f);
		setTickRandomly(true);
		// TODO Auto-generated constructor stub
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
		return new PowerGenerator();
	}
	
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		
		playerIn.openGui(MainClass.modInstance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
		
		//ItemStack stack = null;
		//if(playerIn.getHeldItemMainhand() != null){
			 //stack = playerIn.getHeldItemMainhand();
			 //System.out.println(stack.getItem().getUnlocalizedName().substring(5));
		//}
		
		//TileEntitySolarPannel tect = (TileEntitySolarPannel) worldIn.getTileEntity(pos);
		
		//playerIn.addChatComponentMessage(new TextComponentString("Power: " + tect.getPower()));
    	
        return true;
    }
	
		

}
