package com.brett.powermod.block;

import com.brett.powermod.MainClass;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TweekIron extends BlockOre {

	public TweekIron() {
		super();
		// TODO Auto-generated constructor stub
		setBlockName("TweekIron");
		setHardness(3.0f);
		setResistance(5.0f);
		setCreativeTab(CreativeTabs.tabBlock);
		//setBlockTextureName(MainClass.MODID + ":TweekIron");
		setBlockTextureName("iron_ore");
		
	}

}
