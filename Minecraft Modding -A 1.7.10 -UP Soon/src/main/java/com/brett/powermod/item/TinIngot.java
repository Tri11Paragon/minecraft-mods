package com.brett.powermod.item;

import com.brett.powermod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TinIngot extends Item {
	
	public TinIngot(){
		super();
		setUnlocalizedName("TinIngot");
		setCreativeTab(CreativeTabs.tabMaterials);
		setTextureName(MainClass.MODID + ":TinIngot");
	}
	
}