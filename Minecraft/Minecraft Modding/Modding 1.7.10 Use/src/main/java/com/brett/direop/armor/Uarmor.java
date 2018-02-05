package com.brett.direop.armor;

import com.brett.diremod.MainClass;
import com.brett.direop.KeyBindings;
import com.brett.direop.Mains;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Uarmor extends ItemArmor {
	
	public static int number;
	public static int max = 8;
	public static int effect;

	public Uarmor(ArmorMaterial material, int id, int placement) {
		super(material, id, placement);
		setCreativeTab(CreativeTabs.tabBlock);
		if (placement == 0) {
			this.setTextureName(Mains.MODID + ":uhelmet"); // helmet
		}
		else if (placement == 1) {
			this.setTextureName(Mains.MODID + ":uchestplate"); // chestpalte
		}
		else if (placement == 2) {
			this.setTextureName(Mains.MODID + ":uleggings"); // leggings
		}
		else if (placement == 3) {
			this.setTextureName(Mains.MODID + ":uboots"); // boots
		}
	}
	
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == Mains.unstablehelmet || stack.getItem() == Mains.unstablechestplate || stack.getItem() == Mains.unstableboots) {
			return Mains.MODID + ":textures/models/armor/d_layer_1.png";
		}
		if (stack.getItem() == Mains.unstableleggings) {
			return Mains.MODID + ":textures/models/armor/d_layer_2.png";
		} else {
			return null;
		}
		
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemstack){
		if(number < 0){
			number=0;
		}
		if(number > max){
			number=max;
		}
		if(number > 0 && number < 9){
			effect=number;
		}
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) {
			ItemStack helmet = player.getCurrentArmor(3);
			ItemStack chestplate = player.getCurrentArmor(2);
			ItemStack leggings = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			
			if (helmet.getItem() == Mains.unstablehelmet && chestplate.getItem() == Mains.unstablechestplate && leggings.getItem() == Mains.unstableleggings && boots.getItem() == Mains.unstableboots){
				if(number > 0){
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 300, effect));
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 300, effect));
				player.addPotionEffect(new PotionEffect(Potion.heal.getId(), 5, 1));
				}
			}
		}
	}

}

