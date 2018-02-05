package com.brett.items;

import com.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EnderIngot extends Item {
	
	public EnderIngot(){
		super();
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":enderingot");
		setUnlocalizedName("enderingot");
	}
}
