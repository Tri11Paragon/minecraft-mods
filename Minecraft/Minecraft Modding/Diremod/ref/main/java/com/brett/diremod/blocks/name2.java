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

public class name2 extends Block {

	public name2(Material p_i45394_1_) {
		super(p_i45394_1_);
		setBlockTextureName(MainClass.MODID + ":name2");
		setResistance(10.0F);
		setHardness(50.5F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightOpacity(15);
		setLightLevel(1.0F);
	}

}
