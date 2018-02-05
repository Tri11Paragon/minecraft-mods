package com.brett.items;

import com.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;

public class FussionReactor extends Item {
	
	public FussionReactor(){
		super();
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":reactor");
		setUnlocalizedName("fusionreactor");
	}
}
