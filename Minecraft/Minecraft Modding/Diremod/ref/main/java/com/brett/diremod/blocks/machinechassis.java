package com.brett.diremod.blocks;

import com.brett.diremod.MainClass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class machinechassis extends Block {

	public machinechassis(Material p_i45394_1_) {
		super(p_i45394_1_);
		setHardness(20.0F);
		setResistance(50.0F);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(MainClass.MODID + ":basic");
	}

}
