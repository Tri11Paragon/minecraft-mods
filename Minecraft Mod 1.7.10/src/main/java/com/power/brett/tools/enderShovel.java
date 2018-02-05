package com.power.brett.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

import com.power.brett.MainClass;

public class enderShovel extends ItemSpade {

	public enderShovel(ToolMaterial p_i45353_1_) {
		super(p_i45353_1_);
		setTextureName(MainClass.MODID + ":enderShovel");
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("enderShovel");
	}

}
