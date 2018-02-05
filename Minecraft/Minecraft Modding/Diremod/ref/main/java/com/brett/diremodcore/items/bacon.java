package com.brett.diremodcore.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

import com.brett.diremod.MainClass;

public class bacon extends ItemFood{

	public bacon(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":bacon");
	}

}
