package com.brett.diremod.items;

import java.util.List;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Firon extends Item {
	
	
	public Firon(){
		super();
		setTextureName(MainClass.MODID + ":firon");
		setCreativeTab(CreativeTabs.tabBlock);
		setMaxStackSize(16);
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Frozen Iron");
	}

}
