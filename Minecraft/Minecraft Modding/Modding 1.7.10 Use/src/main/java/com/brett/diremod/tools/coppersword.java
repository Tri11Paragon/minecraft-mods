package com.brett.diremod.tools;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;

public class coppersword extends ItemSword {

	public coppersword(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setTextureName(MainClass.MODID + ":coppersword");
		setCreativeTab(CreativeTabs.tabBlock);
	}

}
