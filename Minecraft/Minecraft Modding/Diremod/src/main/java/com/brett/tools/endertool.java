package com.brett.tools;

import com.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class endertool extends ToolManager {

	public endertool(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":endertool");
		setUnlocalizedName("endertool");
	}
	
}
