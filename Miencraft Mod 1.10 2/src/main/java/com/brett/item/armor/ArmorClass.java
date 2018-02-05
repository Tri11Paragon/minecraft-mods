package com.brett.item.armor;

import javax.annotation.Nullable;

import com.brett.nimbix.MainClass;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ArmorClass {

	
	
	public static ArmorMaterial solarFlux = EnumHelper.addArmorMaterial("solarFlux", MainClass.MODID + ":solarFlux", 66, new int[] {4, 7, 9, 4}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	
	public static ItemArmor solarFluxHelmet;
	public static ItemArmor solarFluxChestplate;
	public static ItemArmor solarFluxLeggings;
	public static ItemArmor solarFluxBoots;
	
	public static void Main(){
		init();
		register();
	}
	
	public static void init(){
		solarFluxHelmet = new SolarFluxArmor(solarFlux, 1, EntityEquipmentSlot.HEAD, "solarFluxHelmet");
		solarFluxChestplate = new SolarFluxArmor(solarFlux, 1, EntityEquipmentSlot.CHEST, "solarFluxChestplate");
		solarFluxLeggings = new SolarFluxArmor(solarFlux, 2, EntityEquipmentSlot.LEGS, "solarFluxLeggings");
		solarFluxBoots = new SolarFluxArmor(solarFlux, 1, EntityEquipmentSlot.FEET, "solarFluxBoots");
	}
	
	public static void register(){
		
		registerItem(solarFluxHelmet);
		registerItem(solarFluxChestplate);
		registerItem(solarFluxLeggings);
		registerItem(solarFluxBoots);
	}
	
	public static void registerRenders(){
		registerRender(solarFluxHelmet);
		registerRender(solarFluxChestplate);
		registerRender(solarFluxLeggings);
		registerRender(solarFluxBoots);
	}
	
	public static void registerItem(Item item){
		item.setCreativeTab(MainClass.modTab);
		GameRegistry.register(item);
	}
	
	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MainClass.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
	}
}
