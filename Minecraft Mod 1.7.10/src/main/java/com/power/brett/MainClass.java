package com.power.brett;

import com.power.brett.blocks.Bedrock;
import com.power.brett.blocks.EnderMiner;
import com.power.brett.blocks.EnderOre;
import com.power.brett.blocks.enderChest;
import com.power.brett.items.BedrockIngot;
import com.power.brett.items.DragonEye;
import com.power.brett.items.DragonHeart;
import com.power.brett.items.EnderDust;
import com.power.brett.items.EnderIngot;
import com.power.brett.tools.enderAxe;
import com.power.brett.tools.enderPickaxe;
import com.power.brett.tools.enderShovel;
import com.power.brett.tools.enderSword;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;

	@Mod(modid = MainClass.MODID, name = MainClass.NAME, version = MainClass.VERSION)
	public class MainClass
	{
		@SidedProxy(clientSide = "com.power.brett.ClientProxy", serverSide = "com.power.brett.CommonProxy")
		public static CommonProxy proxy;
		
		public static worldgenclass worldgen = new worldgenclass(); 
		
		public static ToolMaterial enderM = EnumHelper.addToolMaterial("enderM", 4, 2500, 12.0F, 4, 30); 
		public static ArmorMaterial enderMA = EnumHelper.addArmorMaterial("enderMA", 128, new int []{4, 9, 8, 4}, 30);
		
		public static int helmetID;
		public static int chestplateID;
		public static int leggingsID;
		public static int bootsID;
		
		public static final String MODID = "mod";
		public static final String NAME = "diremod";
		public static final String VERSION = "0.0.1";
		
		// Tier 1
		public static Item EnderIngot = new EnderIngot();
		public static Item EnderDust = new EnderDust();
		public static Item DragonEye = new DragonEye();
		public static Item DragonHeart = new DragonHeart();
		
		public static Item enderPickaxe = new enderPickaxe(enderM);
		public static Item enderAxe = new enderAxe(enderM);
		public static Item enderSword = new enderSword(enderM);
		public static Item enderShovel = new enderShovel(enderM);
		
		public static Block EnderOre = new EnderOre(Material.rock);
		public static Block EnderMiner = new EnderMiner(Material.rock);
		public static Block Bedrock = new Bedrock(Material.anvil);
		public static Block enderChest = new enderChest(Material.rock);
		
		// Tier 2		
		public static Item BedrockIngot = new BedrockIngot();
		
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		// Tier 1
 		GameRegistry.registerBlock(EnderOre, "EnderOre");
 		GameRegistry.registerBlock(EnderMiner, "EnderMiner");
 		GameRegistry.registerBlock(Bedrock, "Bedrock");
 		GameRegistry.registerBlock(enderChest, "enderChest");
 		
 		GameRegistry.registerItem(EnderIngot, "EnderIngot");
 		GameRegistry.registerItem(EnderDust, "EnderDust");
 		GameRegistry.registerItem(DragonEye, "DragonEye");
 		GameRegistry.registerItem(DragonHeart, "DragonHeart");
 		
 		GameRegistry.registerItem(enderPickaxe, "enderPickaxe");
 		GameRegistry.registerItem(enderAxe, "enderAxe");
 		GameRegistry.registerItem(enderSword, "enderSword");
 		GameRegistry.registerItem(enderShovel, "enderShovel");
 		
 		GameRegistry.addRecipe(new ItemStack(EnderDust, 4), new Object[] {"nyn","yxy","nyn", 'x', EnderIngot, 'y', Items.redstone, 'n', Items.diamond});
 		GameRegistry.addRecipe(new ItemStack(DragonEye, 2), new Object[] {"nnn","yxy","nnn", 'x', Items.ender_eye, 'y', EnderDust, 'n', Items.diamond});
 		GameRegistry.addRecipe(new ItemStack(DragonHeart, 1), new Object[] {"yyy","nxn","yyy", 'x', Blocks.dragon_egg, 'y', EnderDust, 'n', Items.diamond});
 		GameRegistry.addRecipe(new ItemStack(Blocks.dragon_egg, 2), new Object[] {"yyy","yxy","yyy", 'x', Blocks.dragon_egg, 'y', EnderDust, 'n', Items.diamond});
 		GameRegistry.addRecipe(new ItemStack(EnderMiner, 1), new Object[] {"yyy","xnx","yyy", 'x', EnderIngot, 'y', EnderDust, 'n', enderPickaxe});
 		
 		GameRegistry.addRecipe(new ItemStack(enderPickaxe, 1), new Object[] {"yyy"," x "," x ", 'x', Items.stick, 'y', EnderDust});
 		GameRegistry.addRecipe(new ItemStack(enderAxe, 1), new Object[] {"yy ","yx "," x ", 'x', Items.stick, 'y', EnderDust});
 		GameRegistry.addRecipe(new ItemStack(enderShovel, 1), new Object[] {" y "," x "," x ", 'x', Items.stick, 'y', EnderDust});
 		GameRegistry.addRecipe(new ItemStack(enderSword, 1), new Object[] {" y "," y "," x ", 'x', Items.stick, 'y', EnderDust});

 		GameRegistry.addSmelting(EnderOre, new ItemStack(EnderIngot), 25.0f);
		
 		// Tier 2
 		
 		GameRegistry.registerItem(BedrockIngot, "BedrockIngot");
 		
 		
 		
 		GameRegistry.addRecipe(new ItemStack(BedrockIngot), new Object[] {"yyy","nnn","yyy", 'x', EnderIngot, 'y', EnderDust, 'n', Bedrock});
 		
		GameRegistry.registerWorldGenerator(worldgen, 1);
    }
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event){

    }
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	
    }
}
