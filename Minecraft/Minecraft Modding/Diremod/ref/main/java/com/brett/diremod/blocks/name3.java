package com.brett.diremod.blocks;

import com.brett.diremod.MainClass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class name3 extends Block {

	public name3(Material p_i45394_1_) {
		super(p_i45394_1_);
		setBlockTextureName(MainClass.MODID + ":name3");
		setResistance(10.0F);
		setHardness(20.5F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(CreativeTabs.tabBlock);
	}

}
