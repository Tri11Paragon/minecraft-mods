package com.brett.item.tools;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class QuantumShovel extends ItemSpade {

	public QuantumShovel(ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
	}
	
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{
		list.add(ChatFormatting.DARK_GREEN + "It takes damage and has no special abilities.");
	}

}
