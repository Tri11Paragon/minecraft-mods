package com.brett;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import static com.brett.MainClass.*;

public class CraftingManager {
	
	
	public static void Craft(){
		GameRegistry.addRecipe(new ItemStack(MainClass.EnderIngot, 4), new Object[] {"#x#", "xrx", "#x#", '#', Blocks.emerald_block, 'x', Items.ender_pearl, 'r', Blocks.redstone_block});
		GameRegistry.addRecipe(new ItemStack(MainClass.Pipe, 16), new Object[] {"iii", "   ", "iii", 'i', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(MainClass.Pump, 1), new Object[] {"  i", "iri", "iii", 'i', Items.iron_ingot, 'r', Items.redstone});
		GameRegistry.addRecipe(new ItemStack(MainClass.SuperConductor, 1), new Object[] {"iii", "rrr", "iii", 'i', Items.iron_ingot, 'r', Items.redstone});
		GameRegistry.addRecipe(new ItemStack(MainClass.FussionReactor, 1), new Object[] {"igi", "rsr", "igi", 'i', EnderIngot, 'r', Pipe, 'g', Pump, 's', SuperConductor});
		GameRegistry.addRecipe(new ItemStack(MainClass.endertool, 1), new Object[] {"iii", " s ", " r ", 'i', MainClass.EnderIngot, 'r', Items.stick, 's', MainClass.FussionReactor});
		GameRegistry.addRecipe(new ItemStack(MainClass.endertool1, 1), new Object[] {"iii", "sis", "srs", 'i', MainClass.EnderIngot, 'r', MainClass.endertool, 's', Blocks.diamond_block, 'i', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(MainClass.core, 1), new Object[] {"eee", "sis", "srs", 'e', MainClass.EnderIngot, 'r', MainClass.endertool1, 's', Blocks.diamond_block, 'i', Blocks.iron_block});
		GameRegistry.addRecipe(new ItemStack(MainClass.staffofpower, 1), new Object[] {"rir", "rsr", "ese", 'e', MainClass.EnderIngot, 'r', MainClass.endertool1, 's', Blocks.diamond_block, 'i', MainClass.core});
	
	}
}
