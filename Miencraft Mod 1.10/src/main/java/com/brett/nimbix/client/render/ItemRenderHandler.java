package com.brett.nimbix.client.render;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.items.CreativeBow;
import com.brett.nimbix.items.OtherItems;
import com.brett.nimbix.items.RingOfFlight;
import com.brett.nimbix.items.ingots.Ingots;
import com.brett.nimbix.items.machine.MachineItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderHandler {

	public static void registerItemRender(){
		//register(Dust.FluxDust);
		register(Ingots.copperIngot);
		register(Ingots.bronzeIngot);
		register(Ingots.leadIngot);
		register(Ingots.solarIngot);
		register(Ingots.steelIngot);
		register(Ingots.tinIngot);
		register(OtherItems.CreativeBow);
		register(Ingots.tritaniumIngot);
		register(OtherItems.solarHelmet);
		register(OtherItems.solarBoots);
		register(OtherItems.solarChestplate);
		register(OtherItems.solarLeggings);
		register(OtherItems.RingOfFlight);
		register(OtherItems.ItemArrowE);
		// Machine
		register(MachineItems.copperWire);
		register(MachineItems.gear);
		register(MachineItems.inductionCoil);
		register(MachineItems.itemCore);
		register(MachineItems.machineFrame);
		register(MachineItems.redstoneCoil);
		register(MachineItems.restoneCircuit);
	}
	
	public static void register(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MainClass.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
		System.out.println("Item Model Loaded!");
	}
	
}
