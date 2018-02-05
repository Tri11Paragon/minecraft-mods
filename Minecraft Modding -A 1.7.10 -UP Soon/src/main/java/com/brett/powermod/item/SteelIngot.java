package com.brett.powermod.item;

import com.brett.powermod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SteelIngot extends Item {
	
	public SteelIngot(){
		super();
		setUnlocalizedName("SteelIngot");
		setCreativeTab(CreativeTabs.tabMaterials);
		setTextureName(MainClass.MODID + ":SteelIngot");
	}
	
}