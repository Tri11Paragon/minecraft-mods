package com.brett.nimbix.items.machine;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.items.ingots.bronzeIngot;
import com.brett.nimbix.items.ingots.copperIngot;
import com.brett.nimbix.items.ingots.leadIngot;
import com.brett.nimbix.items.ingots.solarIngot;
import com.brett.nimbix.items.ingots.steelIngot;
import com.brett.nimbix.items.ingots.tinIngot;
import com.brett.nimbix.items.ingots.tritaniumAlloy;

public class MachineItems {
	public static void Main(){
		Init();
		Register();
	}
	
	public static Item redstoneCore;
	public static Item redstoneCoil;
	public static Item itemCore;
	public static Item inductionCoil;
	public static Item copperWire;
	public static Item gear;
	public static Item machineFrame;
	public static Item restoneCircuit;
	public static Item quantumCore;
	public static Item advancedQuantumCore;
	public static Item netherEnergyCore;
	public static Item dragonEnergyCore;
	
	public static void Init(){
		redstoneCore = new BlankItem().setCreativeTab(MainClass.modTab).setUnlocalizedName("redstoneCore").setRegistryName("redstoneCore");
		redstoneCoil = new BlankItem().setCreativeTab(MainClass.modTab).setUnlocalizedName("redstoneCoil").setRegistryName("redstoneCoil");
		itemCore = new BlankItem().setCreativeTab(MainClass.modTab).setUnlocalizedName("itemCore").setRegistryName("itemCore");
		inductionCoil = new BlankItem().setCreativeTab(MainClass.modTab).setUnlocalizedName("inductionCoil").setRegistryName("inductionCoil");
		copperWire = new copperWire().setCreativeTab(MainClass.modTab).setUnlocalizedName("copperWire").setRegistryName("copperWire");
		gear = new BlankItem().setCreativeTab(MainClass.modTab).setUnlocalizedName("gear").setRegistryName("gear");
		machineFrame = new BlankItem().setCreativeTab(MainClass.modTab).setUnlocalizedName("machineFrame").setRegistryName("machineFrame");
		restoneCircuit = new BlankItem().setCreativeTab(MainClass.modTab).setUnlocalizedName("restonecircuit").setRegistryName("restonecircuit");
		quantumCore = new BlankItem().setCreativeTab(MainClass.modTab).setUnlocalizedName("quantumCore").setRegistryName("quantumCore");
		advancedQuantumCore = new FlashingItem().setCreativeTab(MainClass.modTab).setUnlocalizedName("advancedQuantumCore").setRegistryName("advancedQuantumCore");
		netherEnergyCore = new BlankItem().setCreativeTab(MainClass.modTab).setUnlocalizedName("netherEnergyCore").setRegistryName("netherEnergyCore");
		dragonEnergyCore = new FlashingItem().setCreativeTab(MainClass.modTab).setUnlocalizedName("dragonEnergyCore").setRegistryName("dragonEnergyCore");
	}
	public static void Register(){
		GameRegistry.register(redstoneCore);
		OreDictionary.registerOre("redstoneCore", redstoneCore);
		
		GameRegistry.register(redstoneCoil);
		OreDictionary.registerOre("redstoneCoil", redstoneCoil);
		
		GameRegistry.register(itemCore);
		OreDictionary.registerOre("itemCore", itemCore);
		
		GameRegistry.register(inductionCoil);
		OreDictionary.registerOre("inductionCoil", inductionCoil);
		
		GameRegistry.register(copperWire);
		OreDictionary.registerOre("copperWire", copperWire);
		
		GameRegistry.register(gear);
		OreDictionary.registerOre("gear", gear);
		
		GameRegistry.register(machineFrame);
		OreDictionary.registerOre("machineFrame", machineFrame);
		
		GameRegistry.register(restoneCircuit);
		OreDictionary.registerOre("restoneCircuit", restoneCircuit);
		
		GameRegistry.register(quantumCore);
		OreDictionary.registerOre("quantumCore", quantumCore);
		
		GameRegistry.register(advancedQuantumCore);
		OreDictionary.registerOre("advancedQuantumCore", advancedQuantumCore);
		
		GameRegistry.register(netherEnergyCore);
		OreDictionary.registerOre("netherEnergyCore", netherEnergyCore);
		
		GameRegistry.register(dragonEnergyCore);
		OreDictionary.registerOre("dragonEnergyCore", dragonEnergyCore);
		
		System.out.println("REGISTERSED");
	}
}