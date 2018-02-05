package com.brett.armor;

import com.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class enderarmor extends ItemArmor {

	public enderarmor(ArmorMaterial material, int id, int placement) {
		super(material, id, placement);
		setCreativeTab(CreativeTabs.tabBlock);
		if (placement == 0) {
			this.setTextureName(MainClass.MODID + ":enderhead"); // helmet
		}
		else if (placement == 1) {
			this.setTextureName(MainClass.MODID + ":enderbody"); // chestpalte
		}
		else if (placement == 2) {
			this.setTextureName(MainClass.MODID + ":enderleggins"); // leggings
		}
		else if (placement == 3) {
			this.setTextureName(MainClass.MODID + ":boots"); // boots
		}
	}
	
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == MainClass.enderhelmet || stack.getItem() == MainClass.enderchestplate || stack.getItem() == MainClass.enderboots) {
			return MainClass.MODID + ":textures/models/armor/EnderArmor_layer_1.png";
		}
		if (stack.getItem() == MainClass.enderleggings) {
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
			
			
			if (helmet.getItem() == MainClass.enderhelmet && chestplate.getItem() == MainClass.enderchestplate && leggings.getItem() == MainClass.enderleggings && boots.getItem() == MainClass.enderboots){
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 300, 2));
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 300, 2));
				player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 300, 2));
			}
		}
	}

}