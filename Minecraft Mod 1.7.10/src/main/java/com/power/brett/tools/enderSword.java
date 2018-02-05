package com.power.brett.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

import com.power.brett.MainClass;

public class enderSword extends ItemSword {

	public enderSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		setTextureName(MainClass.MODID + ":enderSword");
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("enderSword");
	}

}
