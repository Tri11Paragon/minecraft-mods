package com.brett.powermod.item;

import com.brett.powermod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CopperIngot extends Item {
	
	public CopperIngot(){
		super();
		setUnlocalizedName("CopperIngot");
		setCreativeTab(CreativeTabs.tabMaterials);
		setTextureName(MainClass.MODID + ":CopperIngot");
	}
	
}
