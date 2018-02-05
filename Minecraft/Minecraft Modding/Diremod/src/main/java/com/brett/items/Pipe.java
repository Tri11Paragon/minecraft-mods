package com.brett.items;

import com.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Pipe extends Item {
	
	public Pipe(){
		super();
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":pipe");
		setUnlocalizedName("pipe");
	}
}
