package com.brett.diremod.tools;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;

public class redmatteraxe extends ItemAxe {

	public redmatteraxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setTextureName(MainClass.MODID + ":redaxe");
		setCreativeTab(CreativeTabs.tabBlock);
	}

}
