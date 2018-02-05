package com.brett.nimbix.blocks;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class CrackedBedrock extends Block{

	public CrackedBedrock(Material materialIn) {
		super(materialIn);
		setHarvestLevel("pickaxe", 500);
		setHardness(20.0f);
	}
	
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{
		list.add(ChatFormatting.DARK_GREEN + "You needs lots of energy to crack bedrock...");
	}

}
