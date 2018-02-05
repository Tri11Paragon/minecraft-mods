package com.brett.diremod.tools;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class redmatterpickaxe extends ItemPickaxe {

	public redmatterpickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setTextureName(MainClass.MODID + ":redpick");
		setCreativeTab(CreativeTabs.tabBlock);
	}

}
