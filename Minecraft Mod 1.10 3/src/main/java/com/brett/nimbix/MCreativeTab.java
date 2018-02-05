package com.brett.nimbix;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class MCreativeTab extends CreativeTabs {

	public MCreativeTab(String label) {
		super(label);
		//setBackgroundImageName("tab.png");
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Items.BED;
	}

}
