package com.brett.renders;

import com.brett.item.armor.ArmorClass;
import com.brett.item.tools.ToolClass;
import com.brett.machines.BlockClass;
import com.brett.nimbix.MainClass;
import com.brett.nimbix.blocks.Ore;
import com.brett.nimbix.items.OtherItems;
import com.brett.nimbix.items.ingots.Ingots;
import com.brett.nimbix.items.machine.MachineItems;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ModelLoader {
	
	public static void register(){
		register(Ore.Copper);
		register(Ore.Lead);
		register(Ore.Tin);
		register(Ore.SolarFluxOre);
		register(Ore.SolarCollector);
		register(Ore.TestBlock);
		register(Ore.Infuser);
		register(Ore.lamp);
		register(Ore.testTile);
		register(Ore.fusionCrafter);
		register(Ore.crackedBedrock);
		register(Ore.kaboom);
		register(Ore.bigKaboom);
		
		//register(Dust.FluxDust);
		register(Ingots.copperIngot);
		register(Ingots.bronzeIngot);
		register(Ingots.leadIngot);
		register(Ingots.solarIngot);
		register(Ingots.steelIngot);
		register(Ingots.tinIngot);
		register(OtherItems.CreativeBow);
		register(Ingots.tritaniumAlloy);
		register(OtherItems.RingOfFlight);
		register(OtherItems.ItemArrowE);
		register(Ingots.tritaniumIngot);
		register(Ingots.bedrockIngot);
		// Machine
		register(MachineItems.copperWire);
		register(MachineItems.gear);
		register(MachineItems.inductionCoil);
		register(MachineItems.itemCore);
		register(MachineItems.machineFrame);
		register(MachineItems.redstoneCoil);
		register(MachineItems.redstoneCore);
		register(MachineItems.restoneCircuit);
		register(MachineItems.advancedQuantumCore);
		register(MachineItems.quantumCore);
		register(MachineItems.netherEnergyCore);
		register(MachineItems.dragonEnergyCore);
		
		register(ToolClass.QuantumPickaxe);
		register(ToolClass.QuantumAxe);
		register(ToolClass.QuantumShovel);
		register(ToolClass.QuantumSword);
		
		register(ToolClass.AdvancedQuantumAxe);
		register(ToolClass.AdvancedQuantumPickaxe);
		register(ToolClass.AdvancedQuantumShovel);
		register(ToolClass.AdvancedQuantumSword);
		
		register(BlockClass.blockQuantumChest);
		register(Ore.mine);
		
		
		ArmorClass.registerRenders();
	}
	public static void register(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MainClass.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
		System.out.println("Item Model Loaded!");
	}
	public static void register(Block block){
		
		Item item = Item.getItemFromBlock(block);
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MainClass.MODID + ":" + block.getUnlocalizedName().substring(5),"inventory"));
		System.out.println("Block Model Loaded!");
	}
}
