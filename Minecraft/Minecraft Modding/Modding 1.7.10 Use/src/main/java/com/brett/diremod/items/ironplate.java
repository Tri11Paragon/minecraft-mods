package com.brett.diremod.items;

import java.util.List;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ironplate extends Item {
	
	
	public ironplate(){
		super();
		setTextureName(MainClass.MODID + ":ironplate");
		setCreativeTab(CreativeTabs.tabBlock);
		setMaxStackSize(16);
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Iron Plate.");
	}

}
