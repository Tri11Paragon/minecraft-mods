package com.brett.item.armor;

import com.brett.nimbix.MainClass;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SolarFluxArmor extends ItemArmor {
	
	public EntityEquipmentSlot entityEquipmentSlot;
	
	public SolarFluxArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String unlocalizedName) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MainClass.MODID, unlocalizedName));
		this.entityEquipmentSlot = equipmentSlotIn;
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		if (entityEquipmentSlot == EntityEquipmentSlot.LEGS){
			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 50, 1, true, false));
		}

	}

}

