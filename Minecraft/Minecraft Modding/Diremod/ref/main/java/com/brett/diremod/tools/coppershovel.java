package com.brett.diremod.tools;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;

public class coppershovel extends ItemSpade {

	public coppershovel(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setTextureName(MainClass.MODID + ":coppershovel");
		setCreativeTab(CreativeTabs.tabBlock);
	}

}
