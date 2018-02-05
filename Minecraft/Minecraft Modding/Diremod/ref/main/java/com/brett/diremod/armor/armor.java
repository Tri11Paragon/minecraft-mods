package com.brett.diremod.armor;

import com.brett.diremod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class armor extends ItemArmor {

	public armor(ArmorMaterial material, int id, int placement) {
		super(material, id, placement);
		setCreativeTab(CreativeTabs.tabBlock);
		if (placement == 0) {
			this.setTextureName(MainClass.MODID + ":darkhelmet"); // helmet
		}
		else if (placement == 1) {
			this.setTextureName(MainClass.MODID + ":darkchestplate"); // chestpalte
		}
		else if (placement == 2) {
			this.setTextureName(MainClass.MODID + ":darkleggings"); // leggings
		}
		else if (placement == 3) {
			this.setTextureName(MainClass.MODID + ":darkboots"); // boots
		}
	}
	
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == MainClass.helmet || stack.getItem() == MainClass.chestplate || stack.getItem() == MainClass.boots) {
			return MainClass.MODID + ":textures/models/armor/EnderArmor_layer_1.png";
		}
		if (stack.getItem() == MainClass.leggings) {
			return MainClass.MODID + ":textures/models/armor/EnderArmor_layer_2.png";
		} else {
			return null;
		}
		
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemstack){
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) {
			ItemStack helmet = player.getCurrentArmor(3);
			ItemStack chestplate = player.getCurrentArmor(2);
			ItemStack leggings = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			
			if (helmet.getItem() == MainClass.helmet && chestplate.getItem() == MainClass.chestplate && leggings.getItem() == MainClass.leggings && boots.getItem() == MainClass.boots){
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 300, 50));
			}
		}
	}

}
