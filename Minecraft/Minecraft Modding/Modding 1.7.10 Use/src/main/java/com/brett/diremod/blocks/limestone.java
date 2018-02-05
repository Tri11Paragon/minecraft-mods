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
import net.minecraft.world.gen.feature.WorldGenMinable;

public class limestone extends Block {

	public limestone(Material p_i45394_1_) {
		super(p_i45394_1_);
		setBlockTextureName(MainClass.MODID + ":lime");
		setResistance(4.0F);
		setHardness(4.5F);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(CreativeTabs.tabBlock);
	}


}
