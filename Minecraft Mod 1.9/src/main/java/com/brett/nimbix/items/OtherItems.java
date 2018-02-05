package com.brett.nimbix.items;

import com.brett.nimbix.MainClass;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class OtherItems {
	public static void Main(){
		Init();
		Register();
	}
	
	public static Item teleporterMemory;
	
	public static void Init(){
		teleporterMemory = new teleporterMemory().setCreativeTab(MainClass.modTab).setMaxStackSize(1).setUnlocalizedName("TeleporterMemory").setRegistryName("TeleporterMemory");
	}
	public static void Register(){
		GameRegistry.register(teleporterMemory);
		
		
		System.out.println("REGISTERSED");
	}
}
