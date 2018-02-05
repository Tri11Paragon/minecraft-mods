package com.brett;

import com.brett.armor.enderarmor;
import com.brett.armor.enderarmor;
import com.brett.blocks.Fence;
import com.brett.enchantment.EnchantmentSpeedBoost;
import com.brett.items.EnderIngot;
import com.brett.items.FussionReactor;
import com.brett.items.Pipe;
import com.brett.items.Pump;
import com.brett.items.SuperConductor;
import com.brett.items.core;
import com.brett.tools.endertool;
import com.brett.tools.endettool1;
import com.brett.worldgen.worldgenclass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
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
		@SidedProxy(clientSide = "com.brett.ClientProxy", serverSide = "com.brett.CommonProxy")
		public static CommonProxy proxy;
		
		public static ToolMaterial enderM = EnumHelper.addToolMaterial("enderM", 4, 8000, 10.0F, 6, 30); 
		public static ToolMaterial enderM2 = EnumHelper.addToolMaterial("enderM2", 4, 8500, 15.0F, 7, 30);
		public static ToolMaterial enderM3 = EnumHelper.addToolMaterial("enderM3", 10, 0, 30.0F, 10, 50);
		public static ArmorMaterial enderMA = EnumHelper.addArmorMaterial("enderMA", 128, new int []{4, 9, 8, 4}, 30);
		
		public static worldgenclass worldgen = new worldgenclass(); 
		
		public static final Enchantment speedBoost = new EnchantmentSpeedBoost(84, 5);
		
		
		public static int helmetID;
		public static int chestplateID;
		public static int leggingsID;
		public static int bootsID;
		
		public static final String MODID = "diremod";
		public static final String NAME = "diremod";
		public static final String VERSION = "0.0.1";
		
		public static Item EnderIngot = new EnderIngot();
		public static Item Pipe = new Pipe();
		public static Item Pump = new Pump();
		public static Item SuperConductor = new SuperConductor();
		public static Item FussionReactor = new FussionReactor();
		public static Item core = new core();
		public static Item endertool = new endertool(enderM);
		public static Item endertool1 = new endettool1(enderM2);
		public static Item staffofpower = new com.brett.tools.staffofpower(enderM3);
		
		public static Block Fence = new Fence(Material.rock);
		
		public static Item enderhelmet = new enderarmor(enderMA, helmetID, 0).setUnlocalizedName("enderhelmet");
		public static Item enderchestplate = new enderarmor(enderMA, chestplateID, 1).setUnlocalizedName("enderchestplate");
		public static Item enderleggings = new enderarmor(enderMA, leggingsID, 2).setUnlocalizedName("enderleggings");
		public static Item enderboots = new enderarmor(enderMA, bootsID, 3).setUnlocalizedName("enderboots");
		
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		GameRegistry.registerItem(EnderIngot, "enderingot");
		GameRegistry.registerItem(Pipe, "pipe");
		GameRegistry.registerItem(Pump, "pump");
		GameRegistry.registerItem(SuperConductor, "conductor");
		GameRegistry.registerItem(FussionReactor, "fussionreactor");
		GameRegistry.registerItem(endertool, "endertool");
		GameRegistry.registerItem(endertool1, "endertool1");
		GameRegistry.registerItem(staffofpower, "staff");
		GameRegistry.registerItem(core, "core");
		
 		GameRegistry.registerItem(enderhelmet, "enderhelmet");
 		GameRegistry.registerItem(enderchestplate, "enderchestplate");
 		GameRegistry.registerItem(enderleggings, "enderleggings");
 		GameRegistry.registerItem(enderboots, "enderboots");
 		
 		GameRegistry.registerBlock(Fence, "Fence");
		
		GameRegistry.registerWorldGenerator(worldgen, 1);
		CraftingManager.Craft();
    }
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event){

    }
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	
    }
}
