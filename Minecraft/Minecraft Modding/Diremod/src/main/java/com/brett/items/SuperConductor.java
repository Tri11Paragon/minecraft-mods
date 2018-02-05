package com.brett.items;

import com.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SuperConductor extends Item {
	
	public SuperConductor(){
		super();
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":conductor");
		setUnlocalizedName("conductor");
	}
}
