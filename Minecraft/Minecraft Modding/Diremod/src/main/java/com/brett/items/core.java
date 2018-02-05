package com.brett.items;

import com.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class core extends Item {

	public core(){
		super();
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":core");
		setUnlocalizedName("core");
	}
}
