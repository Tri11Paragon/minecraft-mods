package com.power.brett.items;

import java.util.List;

import com.power.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnderDust extends Item {
	
	public EnderDust(){
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":EnderDust");
		setUnlocalizedName("EnderDust");
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Tastes Like Enderman");
	}
	
}
