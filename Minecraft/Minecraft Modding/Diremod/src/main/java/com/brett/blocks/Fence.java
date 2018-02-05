package com.brett.blocks;

import com.brett.MainClass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Fence extends Block {

	public Fence(Material p_i45394_1_) {
		super(p_i45394_1_);
		setBlockName("Fence");
		setHardness(50.0f);
		setResistance(5f);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(MainClass.MODID + ":Fence");
	}
	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity){

		if(true){
		entity.attackEntityFrom(DamageSource.magic, 20);
		}
		if(true){
			world.setBlock(i, j + 5, k, Blocks.anvil, 0, 2);
		}

	}
}
