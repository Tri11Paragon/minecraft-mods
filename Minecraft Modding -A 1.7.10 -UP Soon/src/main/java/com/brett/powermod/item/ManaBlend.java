package com.brett.powermod.item;

import com.brett.powermod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ManaBlend extends Item {
	
	public ManaBlend(){
		super();
		setUnlocalizedName("ManaBlend");
		setCreativeTab(CreativeTabs.tabMaterials);
		setTextureName(MainClass.MODID + ":ManaBlend");
	}
	
}