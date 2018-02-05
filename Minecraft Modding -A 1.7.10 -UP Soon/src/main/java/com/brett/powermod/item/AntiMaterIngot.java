package com.brett.powermod.item;

import com.brett.powermod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AntiMaterIngot extends Item {
	
	public AntiMaterIngot(){
		super();
		setUnlocalizedName("AntiMaterIngot");
		setCreativeTab(CreativeTabs.tabMaterials);
		setTextureName(MainClass.MODID + ":AntiMaterIngot");
	}
	
}