package com.brett.item.tools;

import java.util.List;
import java.util.Set;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.helpers.NBTHelper;
import com.mojang.realmsclient.gui.ChatFormatting;

import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class AdvancedQuantumAxe extends ItemAxe {

	public int usage;
	
	public AdvancedQuantumAxe(ToolMaterial material) {
		super(material, material.getDamageVsEntity(), -3.2f);
	}

	
}
