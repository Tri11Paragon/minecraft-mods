package com.brett.diremod.tools;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class darkmatterpickaxe extends ItemPickaxe {

	public darkmatterpickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setTextureName(MainClass.MODID + ":darkpick");
		setCreativeTab(CreativeTabs.tabBlock);
	}

}
