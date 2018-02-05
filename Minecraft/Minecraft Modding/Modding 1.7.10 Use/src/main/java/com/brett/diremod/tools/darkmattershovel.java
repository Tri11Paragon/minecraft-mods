package com.brett.diremod.tools;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;

public class darkmattershovel extends ItemSpade {

	public darkmattershovel(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setTextureName(MainClass.MODID + ":darkshovel");
		setCreativeTab(CreativeTabs.tabBlock);
	}

}
