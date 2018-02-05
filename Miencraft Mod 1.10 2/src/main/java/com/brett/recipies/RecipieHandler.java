package com.brett.recipies;

import javax.crypto.Mac;

import com.brett.item.armor.ArmorClass;
import com.brett.item.tools.ToolClass;
import com.brett.nimbix.blocks.Ore;
import com.brett.nimbix.items.ingots.Ingots;
import com.brett.nimbix.items.machine.MachineItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class RecipieHandler {
	
	public static void registerCrafting(){
		InfuserRecipes.smelting();
		GameRegistry.addRecipe(new ItemStack(Ingots.tritaniumAlloy, 1), new Object[]{"wyw", "xxx", "ywy", 'x', Ingots.steelIngot, 'y', Ingots.solarIngot, 'w', Items.GOLD_INGOT});
		//GameRegistry.addRecipe(new ItemStack(Ore.mine, 1), new Object[]{"xxx", "xxx", "xxx", 'x', Blocks.DIRT, 'y'});
		GameRegistry.addRecipe(new ItemStack(MachineItems.copperWire, 12), new Object[]{"yyy", "xxx", "yyy", 'x', Ingots.copperIngot, 'y', Blocks.WOOL});
		GameRegistry.addRecipe(new ItemStack(MachineItems.gear, 1), new Object[]{"yxy", "xyx", "yxy", 'x', Items.IRON_INGOT});
		GameRegistry.addRecipe(new ItemStack(MachineItems.inductionCoil, 1), new Object[]{"wxw", "wyw", "wxw", 'x', Items.IRON_INGOT, 'y', MachineItems.redstoneCoil, 'w', MachineItems.copperWire});
		GameRegistry.addRecipe(new ItemStack(MachineItems.itemCore, 1), new Object[]{"xyx", "ywy", "xyx", 'x', MachineItems.inductionCoil, 'y', Ingots.tritaniumIngot, 'w', MachineItems.redstoneCore});
		GameRegistry.addRecipe(new ItemStack(MachineItems.machineFrame, 1), new Object[]{"xyx", "ywy", "xyx", 'x', Items.IRON_INGOT, 'y', MachineItems.gear, 'w', Blocks.GLASS});
		GameRegistry.addRecipe(new ItemStack(MachineItems.redstoneCoil, 1), new Object[]{"wxw", "wxw", "wxw", 'x', Items.IRON_INGOT, 'w', Items.REDSTONE});
		GameRegistry.addRecipe(new ItemStack(MachineItems.redstoneCore, 1), new Object[]{"yxy", "xwx", "yxy", 'y', Blocks.REDSTONE_BLOCK, 'w', Items.GOLD_INGOT, 'x', MachineItems.copperWire});
		GameRegistry.addRecipe(new ItemStack(MachineItems.restoneCircuit, 1), new Object[]{"xxx", "wyw", "xxx", 'x', MachineItems.copperWire, 'y', Items.GOLD_INGOT, 'w', Items.REDSTONE});
		GameRegistry.addRecipe(new ItemStack(MachineItems.netherEnergyCore, 1), new Object[]{"xyx", "ywy", "xyx", 'x', MachineItems.redstoneCore, 'y', MachineItems.itemCore, 'w', Items.NETHER_STAR});
		GameRegistry.addRecipe(new ItemStack(MachineItems.quantumCore, 1), new Object[]{"xwx", "wyw", "xwx", 'x', Blocks.DIAMOND_BLOCK, 'y', MachineItems.itemCore, 'w', Items.NETHER_STAR});
		GameRegistry.addRecipe(new ItemStack(Ingots.bedrockIngot, 1), new Object[]{"yyy", "wxw", "yyy", 'x', Blocks.DIAMOND_BLOCK, 'y', Ore.crackedBedrock, 'w', Items.NETHER_STAR});
		GameRegistry.addRecipe(new ItemStack(Ore.kaboom, 1), new Object[]{"xwx", "wyw", "xwx", 'x', Blocks.TNT, 'y', MachineItems.quantumCore, 'w', Items.NETHER_STAR});
		GameRegistry.addRecipe(new ItemStack(Ore.bigKaboom, 1), new Object[]{"xwx", "wyw", "xwx", 'x', Ore.kaboom, 'y', MachineItems.advancedQuantumCore, 'w', Items.NETHER_STAR});
		
		GameRegistry.addRecipe(new ItemStack(MachineItems.advancedQuantumCore, 1), new Object[]{"xxx", "wyw", "xxx", 'x', Ingots.bedrockIngot, 'y', MachineItems.quantumCore, 'w', Blocks.DRAGON_EGG});
		GameRegistry.addRecipe(new ItemStack(MachineItems.dragonEnergyCore, 1), new Object[]{"xxx", "wyw", "xxx", 'x', Ingots.bedrockIngot, 'y', MachineItems.netherEnergyCore, 'w', Blocks.DRAGON_EGG});
		
		GameRegistry.addRecipe(new ItemStack(ToolClass.QuantumPickaxe), new Object[]{"xxx", "oyo", "owo", 'x', Ingots.tritaniumIngot, 'y', Items.DIAMOND_PICKAXE, 'o', MachineItems.quantumCore, 'w', Items.DIAMOND});
		GameRegistry.addRecipe(new ItemStack(ToolClass.QuantumAxe), new Object[]{"xxo", "xyo", "owo", 'x', Ingots.tritaniumIngot, 'y', Items.DIAMOND_AXE, 'o', MachineItems.quantumCore, 'w', Items.DIAMOND});
		GameRegistry.addRecipe(new ItemStack(ToolClass.QuantumShovel), new Object[]{"oxo", "oyo", "owo", 'x', Ingots.tritaniumIngot, 'y', Items.DIAMOND_SHOVEL, 'o', MachineItems.quantumCore, 'w', Items.DIAMOND});
		GameRegistry.addRecipe(new ItemStack(ToolClass.QuantumSword), new Object[]{"oxo", "oxo", "oyo", 'x', Ingots.tritaniumIngot, 'y', Items.DIAMOND_SWORD, 'o', MachineItems.quantumCore});
		
		GameRegistry.addRecipe(new ItemStack(ToolClass.AdvancedQuantumPickaxe), new Object[]{"xxx", "oyo", "owo", 'x', Ingots.bedrockIngot, 'y', ToolClass.QuantumPickaxe, 'o', MachineItems.advancedQuantumCore, 'w', MachineItems.dragonEnergyCore});
		GameRegistry.addRecipe(new ItemStack(ToolClass.AdvancedQuantumAxe), new Object[]{"xxo", "xyo", "owo", 'x', Ingots.bedrockIngot, 'y', ToolClass.QuantumAxe, 'o', MachineItems.advancedQuantumCore, 'w', MachineItems.dragonEnergyCore});
		GameRegistry.addRecipe(new ItemStack(ToolClass.AdvancedQuantumShovel), new Object[]{"oxo", "oyo", "owo", 'x', Ingots.bedrockIngot, 'y', ToolClass.QuantumShovel, 'o', MachineItems.advancedQuantumCore, 'w', MachineItems.dragonEnergyCore});
		GameRegistry.addRecipe(new ItemStack(ToolClass.AdvancedQuantumSword), new Object[]{"oxo", "oyo", "owo", 'x', Ingots.bedrockIngot, 'y', ToolClass.QuantumSword, 'o', MachineItems.advancedQuantumCore, 'w', MachineItems.dragonEnergyCore});
		
		registerArmor(new ItemStack(Ingots.solarIngot), new ItemStack(ArmorClass.solarFluxHelmet), new ItemStack(ArmorClass.solarFluxChestplate), new ItemStack(ArmorClass.solarFluxLeggings), new ItemStack(ArmorClass.solarFluxBoots));
		
	}
	
	public static void registerSmelting(){
		GameRegistry.addSmelting(Ore.Copper, new ItemStack(Ingots.copperIngot), 5.0f);
		GameRegistry.addSmelting(Ore.Lead, new ItemStack(Ingots.leadIngot), 5.0f);
		GameRegistry.addSmelting(Ore.SolarFluxOre, new ItemStack(Ingots.solarIngot), 5.0f);
		GameRegistry.addSmelting(Ore.Tin, new ItemStack(Ingots.tinIngot), 5.0f);
		GameRegistry.addSmelting(Items.IRON_INGOT, new ItemStack(Ingots.steelIngot), 5.0f);
		GameRegistry.addSmelting(Ingots.tritaniumAlloy, new ItemStack(Ingots.tritaniumIngot), 5.0f);
	}

	public static void registerArmor(ItemStack itemMaterial, ItemStack healment, ItemStack chestplate, ItemStack legs, ItemStack boots){
		GameRegistry.addRecipe(healment, new Object[]{"xxx", "xox", "ooo", 'x', itemMaterial});
		GameRegistry.addRecipe(chestplate, new Object[]{"xox", "xxx", "xxx", 'x', itemMaterial});
		GameRegistry.addRecipe(legs, new Object[]{"xxx", "xox", "xox", 'x', itemMaterial});
		GameRegistry.addRecipe(boots, new Object[]{"ooo", "xox", "xox", 'x', itemMaterial});
	}
	
	public static void registerTool(ItemStack material, ItemStack stickMaterial, ItemStack pick, ItemStack shovel, ItemStack sword, ItemStack axe){
		GameRegistry.addRecipe(pick, new Object[]{"xxx", "oyo", "oyo", 'x', material, 'y', stickMaterial});
		GameRegistry.addRecipe(shovel, new Object[]{"oxo", "oyo", "oyo", 'x', material, 'y', stickMaterial});
		GameRegistry.addRecipe(sword, new Object[]{"oxo", "oxo", "oyo", 'x', material, 'y', stickMaterial});
		GameRegistry.addRecipe(axe, new Object[]{"xxo", "xyo", "oyo", 'x', material, 'y', stickMaterial});
	}
}
