package com.brett.diremod.items;


import java.util.List;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class darkmatter extends Item {
	
	
	public darkmatter(){
		super();
		setTextureName(MainClass.MODID + ":dark");
		setCreativeTab(CreativeTabs.tabBlock);
		setMaxStackSize(32);
		setUnlocalizedName("darkmatter");
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Darkest of Matter");
	}

}
