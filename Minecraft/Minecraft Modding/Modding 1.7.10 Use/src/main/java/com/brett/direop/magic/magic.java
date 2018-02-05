package com.brett.direop.magic;

import java.util.Random;

import com.brett.direop.Mains;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class magic extends Block {

	public magic(Material p_i45394_1_) {
		super(p_i45394_1_);
		setBlockName("magic");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(5.0F);
		setResistance(5.4F);
		setBlockTextureName(Mains.MODID + ":magic");
	}
	public void randomDisplayTick(World world, int i, int j, int k, Random random){
		EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
				World par1World = world;
						int par2 = i;
						int par3 = j;
						int par4 = k;
				Random par5Random = random;
		if(true)
		        for (int l = 0; l < 1; ++l)
		        {
		            double d0 = (double)((float)par2 + par5Random.nextFloat());
		            double d1 = (double)((float)par3 + par5Random.nextFloat());
		            double d2 = (double)((float)par4 + par5Random.nextFloat());
		            double d3 = 0.0D;
		            double d4 = 0.0D;
		            double d5 = 0.0D;
		            int i1 = par5Random.nextInt(2) * 2 - 1;
		            d3 = ((double)par5Random.nextFloat() - 0.5D) * 1.500000001490116D;
		            d4 = ((double)par5Random.nextFloat() - 0.5D) * 1.500000001490116D;
		            d5 = ((double)par5Random.nextFloat() - 0.5D) * 1.500000001490116D;
		            par1World.spawnParticle("smoke", d0, d1, d2, d3, d4, d5);
		        }

		}

}
