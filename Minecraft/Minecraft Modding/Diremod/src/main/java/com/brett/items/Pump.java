package com.brett.items;

import com.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Pump extends Item {
	
	public Pump(){
		super();
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":pump");
		setUnlocalizedName("pump");
	}
}
