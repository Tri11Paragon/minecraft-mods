package com.brett.nimbix.helpers;

import com.brett.nimbix.InfuserRecipes;
import com.brett.nimbix.blocks.Ore;
import com.brett.nimbix.items.ingots.Ingots;
import com.brett.nimbix.items.machine.MachineItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipieHandler {
	
	public static void registerCrafting(){
		InfuserRecipes.smelting();
		GameRegistry.addRecipe(new ItemStack(Ingots.tritaniumIngot, 1), new Object[]{"wyw", "xxx", "ywy", 'x', Items.IRON_INGOT, 'y', Ingots.solarIngot, 'w', Items.GOLD_INGOT});
		GameRegistry.addRecipe(new ItemStack(MachineItems.copperWire, 12), new Object[]{"yyy", "xxx", "yyy", 'x', Ingots.copperIngot, 'y', Blocks.WOOL});
		GameRegistry.addRecipe(new ItemStack(MachineItems.gear, 1), new Object[]{"yxy", "xyx", "yxy", 'x', Items.IRON_INGOT});
		GameRegistry.addRecipe(new ItemStack(MachineItems.inductionCoil, 1), new Object[]{"wxw", "wyw", "wxw", 'x', Items.IRON_INGOT, 'y', MachineItems.redstoneCoil, 'w', MachineItems.copperWire});
		GameRegistry.addRecipe(new ItemStack(MachineItems.itemCore, 1), new Object[]{"xyx", "ywy", "xyx", 'x', MachineItems.inductionCoil, 'y', Ingots.tritaniumIngot, 'w', MachineItems.redstoneCore});
		GameRegistry.addRecipe(new ItemStack(MachineItems.machineFrame, 1), new Object[]{"xyx", "yxy", "xyx", 'x', Items.IRON_INGOT, 'y', MachineItems.gear});
		GameRegistry.addRecipe(new ItemStack(MachineItems.redstoneCoil, 1), new Object[]{"wxw", "wxw", "wxw", 'x', Items.IRON_INGOT, 'w', Items.REDSTONE});
		GameRegistry.addRecipe(new ItemStack(MachineItems.redstoneCore, 1), new Object[]{"yyy", "ywy", "yyy", 'y', Blocks.REDSTONE_BLOCK, 'w', Items.GOLD_INGOT});
		GameRegistry.addRecipe(new ItemStack(MachineItems.restoneCircuit, 1), new Object[]{"xxx", "wyw", "xxx", 'x', MachineItems.copperWire, 'y', Items.GOLD_INGOT, 'w', Items.REDSTONE});
	}
	
	public static void registerSmelting(){
		GameRegistry.addSmelting(Ore.Copper, new ItemStack(Ingots.copperIngot), 5.0f);
		GameRegistry.addSmelting(Ore.Lead, new ItemStack(Ingots.leadIngot), 5.0f);
		GameRegistry.addSmelting(Ore.SolarFluxOre, new ItemStack(Ingots.solarIngot), 5.0f);
		GameRegistry.addSmelting(Ore.Tin, new ItemStack(Ingots.tinIngot), 5.0f);
		GameRegistry.addSmelting(Items.IRON_INGOT, new ItemStack(Ingots.steelIngot), 5.0f);
	}

	public void registerArmor(ItemStack itemMaterial, ItemStack healment, ItemStack chestplate, ItemStack legs, ItemStack boots){
		GameRegistry.addRecipe(healment, new Object[]{"xxx", "xox", "ooo", 'x', itemMaterial});
		GameRegistry.addRecipe(chestplate, new Object[]{"xox", "xxx", "xxx", 'x', itemMaterial});
		GameRegistry.addRecipe(legs, new Object[]{"xxx", "xox", "xox", 'x', itemMaterial});
		GameRegistry.addRecipe(boots, new Object[]{"ooo", "xox", "xox", 'x', itemMaterial});
	}
	
	public void registerTool(ItemStack material, ItemStack stickMaterial, ItemStack pick, ItemStack shovel, ItemStack sword, ItemStack axe){
		GameRegistry.addRecipe(pick, new Object[]{"xxx", "oyo", "oyo", 'x', material, 'y', stickMaterial});
		GameRegistry.addRecipe(shovel, new Object[]{"oxo", "oyo", "oyo", 'x', material, 'y', stickMaterial});
		GameRegistry.addRecipe(sword, new Object[]{"oxo", "oxo", "oyo", 'x', material, 'y', stickMaterial});
		GameRegistry.addRecipe(axe, new Object[]{"xxo", "xyo", "oyo", 'x', material, 'y', stickMaterial});
	}
}
