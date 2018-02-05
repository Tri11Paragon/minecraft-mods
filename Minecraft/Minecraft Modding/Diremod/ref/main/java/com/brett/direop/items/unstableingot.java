package com.brett.direop.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.brett.direop.Mains;

public class unstableingot extends Item{
	public unstableingot(){
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(Mains.MODID + ":unstable");
	}
}
