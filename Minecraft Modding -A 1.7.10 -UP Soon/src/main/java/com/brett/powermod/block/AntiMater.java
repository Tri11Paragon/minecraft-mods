package com.brett.powermod.block;

import com.brett.powermod.MainClass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AntiMater extends Block {

	public AntiMater(Material p_i45394_1_) {
		super(p_i45394_1_);
		setBlockName("AntiMater");
		setHardness(3.0f);
		setResistance(5.0f);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(MainClass.MODID + ":AntiMater");
	}

}

