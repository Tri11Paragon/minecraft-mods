package com.power.brett.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.power.brett.MainClass;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EnderMiner extends Block {

	int a1 = 0,a2 = 0,a3 = 0,a4 = 0,a5 = 0,a6 = 0;

	IIcon gor = null, dol = null, st1 = null, st2 = null, st3 = null, st4 = null;
	
	public EnderMiner(Material p_i45394_1_) {
		super(p_i45394_1_);
		setHardness(5.0f);
		setResistance(500.0f);
		setBlockName("EnderMiner");
		setCreativeTab(CreativeTabs.tabBlock);
		setLightLevel(1.0f);
	}
	public void onBlockAdded(World world, int i, int j, int k){
		EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
		if(entity!=null&&world!=null){
		int le = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		world.setBlockMetadataWithNotify(i, j, k, le, 2);
		}

		world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));

		}
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entity, int l, float m, float n, float o){
		System.out.println("Hello, Killed World");
			for(int y=0; y < j; y++){
				if(world.getBlock(i, j - 1 - y, k) == Blocks.bedrock)
				{
					dropBlockAsItem(world, i, j, k, new ItemStack(MainClass.Bedrock));
					world.setBlock(i, j - 1 - y, k, MainClass.Bedrock);
				} 
				else if(!(world.getBlock(i, j - 1 - y, k) == Blocks.bedrock) && !(world.getBlock(i, j - 1 - y, k) == MainClass.Bedrock))
				{
					world.getBlock(i, j - 1 - y, k).dropBlockAsItem(world, i, j + 1, k, 1, 1);
					world.setBlockToAir(i, j- 1 - y, k);
				}
			}
		
		return true;
		}
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int i, int par2){

	if (i == 0)
	return gor;

	else if (i == 1)
	return dol;

	else if (i == 2)
	return st1;

	else if (i == 3)
	return st2;

	else if (i == 4)
	return st4;

	else if (i == 5)
	return st3;

	else
	return gor;

	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister reg){
	this.gor = reg.registerIcon(MainClass.MODID + ":Ender_Top");
	this.dol = reg.registerIcon(MainClass.MODID + ":Ender_Bottom");
	this.st1 = reg.registerIcon(MainClass.MODID + ":Ender_Side");
	this.st2 = reg.registerIcon(MainClass.MODID + ":Ender_Side");
	this.st3 = reg.registerIcon(MainClass.MODID + ":Ender_Side");
	this.st4 = reg.registerIcon(MainClass.MODID + ":Ender_Side");
	}
	public int tickRate(World world)
	{
	    return 10;
	}

	public int quantityDropped(Random par1Random){
	return 1;
	}

}
