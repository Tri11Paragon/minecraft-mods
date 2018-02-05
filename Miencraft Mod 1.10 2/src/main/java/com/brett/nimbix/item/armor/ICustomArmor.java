package com.brett.nimbix.item.armor;

import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface ICustomArmor extends IEnergyContainerItem {

	float getProtectionPoints(ItemStack stack);

    float getRecoveryRate(ItemStack stack);

	float getSpeedModifier(ItemStack stack, EntityPlayer player);

	float getJumpModifier(ItemStack stack, EntityPlayer player);

	boolean hasHillStep(ItemStack stack, EntityPlayer player);

	float getFireResistance(ItemStack stack);

	boolean[] hasFlight(ItemStack stack);

	float getFlightSpeedModifier(ItemStack stack, EntityPlayer player);
	
	float getFlightVModifier(ItemStack stack, EntityPlayer player);

	int getEnergyPerProtectionPoint();

    void modifyEnergy(ItemStack stack, int amount);
}
