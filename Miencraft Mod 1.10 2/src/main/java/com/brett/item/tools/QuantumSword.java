package com.brett.item.tools;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class QuantumSword extends ItemSword {

	public QuantumSword(ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
	}
	
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        return true;
    }
    
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{
		list.add(ChatFormatting.DARK_GREEN + "It takes damage and has no special abilities.");
	}

}
