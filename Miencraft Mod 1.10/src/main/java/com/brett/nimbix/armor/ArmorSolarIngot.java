package com.brett.nimbix.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

	
public class ArmorSolarIngot extends ItemArmor {

	public ArmorSolarIngot(String unlocalizedName, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType) {
	    super(material, renderIndex, armorType);

	    this.setUnlocalizedName(unlocalizedName);
	}
}
	
