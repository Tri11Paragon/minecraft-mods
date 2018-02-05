package com.brett.diremod.items;


import java.util.List;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class tin extends Item {
	
	
	public tin(){
		super();
		setTextureName(MainClass.MODID + ":tiningot");
		setCreativeTab(CreativeTabs.tabBlock);
		setMaxStackSize(64);
		setUnlocalizedName("tin");
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Tin!");
	}

}
