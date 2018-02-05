package com.power.brett.items;

import java.util.List;

import com.power.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnderIngot extends Item {
	
	public EnderIngot(){
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":EnderIngot");
		setUnlocalizedName("EnderIngot");
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Teleporty!");
	}
	
}
