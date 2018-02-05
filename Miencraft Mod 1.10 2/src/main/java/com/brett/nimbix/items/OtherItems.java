package com.brett.nimbix.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.brett.nimbix.MainClass;

public class OtherItems {
	
	public static void Main(){
		Init();
		Register();
	}
	
	public static ArmorMaterial SolarA = EnumHelper.addArmorMaterial("SolarA", "textures:models", 16, new int[] {3, 8, 6, 3}, 30, null, 1);
	
	public static Item CreativeBow;
	public static Item ItemArrowE;
	public static Item RingOfFlight;
	
	
	public static void Init(){
		
		CreativeBow = new CreativeBow().setCreativeTab(MainClass.modTab).setUnlocalizedName("CreativeBow").setRegistryName("CreativeBow").setFull3D();
		ItemArrowE = new ItemArrowE().setCreativeTab(MainClass.modTab).setUnlocalizedName("ItemArrowE").setRegistryName("ItemArrowE").setFull3D();
		RingOfFlight = new RingOfFlight().setCreativeTab(MainClass.modTab).setUnlocalizedName("RingOfFlight").setRegistryName("RingOfFlight");
		
		
	}
	public static void Register(){
		
		GameRegistry.register(CreativeBow);
		GameRegistry.register(RingOfFlight);
		
		System.out.println("REGISTERSED");
	}
	
}
