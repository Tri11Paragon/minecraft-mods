package com.brett.item.tools;

import java.util.List;
import java.util.Set;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.helpers.NBTHelper;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class AdvancedQuantumSword extends ItemSword {
	
	public AdvancedQuantumSword(ToolMaterial material) {
		super(material);
	}
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{	
		list.add(ChatFormatting.DARK_GREEN + "Just your normal super sword");
	}

}
