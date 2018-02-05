package com.brett.nimbix.items.machine;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class copperWire extends Item {
	
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{
		list.add("Recipe will be changed");
		list.add("Will add ruber");
	}

}
