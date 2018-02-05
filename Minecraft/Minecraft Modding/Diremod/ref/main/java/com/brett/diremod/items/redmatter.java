package com.brett.diremod.items;


import java.util.List;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class redmatter extends Item {
	
	
	public redmatter(){
		super();
		setTextureName(MainClass.MODID + ":red");
		setCreativeTab(CreativeTabs.tabBlock);
		setMaxStackSize(32);
		setUnlocalizedName("redmatter");
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Darker then Dark Matter");
	}

}
