package com.brett.diremodcore.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class blockbreaker extends Block{

	public blockbreaker(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}
	

	boolean red = false;
	
	public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5){
		return red?1:0;
		}
		public void onNeighborBlockChange(World world, int i, int j, int k, Block l){
		EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
		if (Block.getIdFromBlock(l) > 0 && l.canProvidePower() && world.isBlockIndirectlyGettingPowered(i, j, k)){

		if(true){
		world.setBlockToAir(i,j + 1,k);
		}

		}
		}
		

}
