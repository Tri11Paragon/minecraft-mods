package com.brett.powermod.item;

import com.brett.powermod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EnderIngot extends Item {
	
	public EnderIngot(){
		super();
		setUnlocalizedName("EnderIngot");
		setCreativeTab(CreativeTabs.tabMaterials);
		setTextureName(MainClass.MODID + ":EnderIngot");
	}
	
}