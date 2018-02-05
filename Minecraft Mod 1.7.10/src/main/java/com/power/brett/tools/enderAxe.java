 package com.power.brett.tools;

import com.power.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class enderAxe extends ItemAxe {

	public enderAxe(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);
		setTextureName(MainClass.MODID + ":enderAxe");
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("enderAxe");
	}

}
