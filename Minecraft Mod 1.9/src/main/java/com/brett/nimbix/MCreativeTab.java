package com.brett.nimbix;

import com.brett.nimbix.items.Dust;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MCreativeTab extends CreativeTabs {

	public MCreativeTab(String label) {
		super(label);
		//setBackgroundImageName("tab.png");
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Dust.FluxDust;
	}

}
