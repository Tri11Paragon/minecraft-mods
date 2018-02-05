package com.brett.diremod.items;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class nitrogen extends Item {
	
	
	public nitrogen(){
		super();
		setTextureName(MainClass.MODID + ":Nitrogen");
		setCreativeTab(CreativeTabs.tabBlock);
	}

}
