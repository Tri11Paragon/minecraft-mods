package com.brett.diremod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.util.EnumHelper;

import com.brett.diremod.armor.armor;
import com.brett.diremod.armor.darkmatterarmor;
import com.brett.diremod.armor.redmatterarmor;
import com.brett.diremod.blocks.blacktile;
import com.brett.diremod.blocks.compressor;
import com.brett.diremod.blocks.copperore;
import com.brett.diremod.blocks.granite;
import com.brett.diremod.blocks.limestone;
import com.brett.diremod.blocks.machinechassis;
import com.brett.diremod.blocks.marble;
import com.brett.diremod.blocks.name1;
import com.brett.diremod.blocks.name2;
import com.brett.diremod.blocks.name3;
import com.brett.diremod.blocks.name4;
import com.brett.diremod.blocks.name5;
import com.brett.diremod.blocks.nitrogencompressor;
import com.brett.diremod.blocks.quartz;
import com.brett.diremod.blocks.tinore;
import com.brett.diremod.items.Firon;
import com.brett.diremod.items.IC;
import com.brett.diremod.items.copper;
import com.brett.diremod.items.darkmatter;
import com.brett.diremod.items.ironplate;
import com.brett.diremod.items.nitrogen;
import com.brett.diremod.items.redmatter;
import com.brett.diremod.items.tin;
import com.brett.diremod.tools.copperaxe;
import com.brett.diremod.tools.copperpickaxe;
import com.brett.diremod.tools.coppershovel;
import com.brett.diremod.tools.coppersword;
import com.brett.diremod.tools.darkmatteraxe;
import com.brett.diremod.tools.darkmatterpickaxe;
import com.brett.diremod.tools.darkmattershovel;
import com.brett.diremod.tools.darkmattersword;
import com.brett.diremod.tools.redmatteraxe;
import com.brett.diremod.tools.redmatterpickaxe;
import com.brett.diremod.tools.redmattershovel;
import com.brett.diremod.tools.redmattersword;
import com.brett.diremod.worldgen.worldgenclass;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = MainClass.MODID, name = MainClass.NAME, version = MainClass.VERSION)
public class MainClass
{
	@SidedProxy(clientSide = "com.brett.diremod.ClientProxy", serverSide = "com.brett.diremod.CommonProxy")
	public static CommonProxy proxy;
	
	public static worldgenclass worldgen = new worldgenclass(); 
	
	
	public static int helmetID;
	public static int chestplateID;
	public static int leggingsID;
	public static int bootsID;
	
	public static final String MODID = "diremod";
	public static final String NAME = "diremod";
	public static final String VERSION = "0.0.5";
	
	public static ToolMaterial darkmatterM = EnumHelper.addToolMaterial("darkmatterM", 4, 8000, 20.0F, 15, 30); 
	public static ToolMaterial redmatterM = EnumHelper.addToolMaterial("redmatterM", 8, 0, 40.0F, 25, 60);
	public static ToolMaterial copperM = EnumHelper.addToolMaterial("copperM", 2, 280, 10.0F, 2, 60); 
	public static ArmorMaterial darkM = EnumHelper.addArmorMaterial("darkM", 128, new int []{4, 8, 7, 3}, 30);
	public static ArmorMaterial redM = EnumHelper.addArmorMaterial("redM", 512, new int []{4, 9, 8, 4}, 300);
	
	
	
	// other blocks
	public static Block machinechassis = new machinechassis(Material.rock).setBlockName("machinechassis");
	public static Block nitrogencompressor = new nitrogencompressor(Material.rock).setBlockName("Nitrogencompressor");
	public static Item nitrogen = new nitrogen().setUnlocalizedName("Nitrogen");
	public static Item Firon = new Firon().setUnlocalizedName("firon");
	public static Item IC = new IC().setUnlocalizedName("IC");
	public static Block compressor = new compressor(Material.rock).setBlockName("compressor");
	public static Item ironplate = new ironplate().setUnlocalizedName("ironplate");
	public static Item darkmatter = new darkmatter();
	public static Item redmatter = new redmatter();
	public static Block copperore = new copperore(Material.rock).setBlockName("copperore");
	public static Block tinore = new tinore(Material.rock).setBlockName("tinore");
	public static Item tin = new tin();
	public static Item copper = new copper();
	//tools
	public static Item darkmatterpickaxe = new darkmatterpickaxe(darkmatterM).setUnlocalizedName("darkpick");
	public static Item darkmatteraxe = new darkmatteraxe(darkmatterM).setUnlocalizedName("darkaxe");
	public static Item darkmattersword = new darkmattersword(darkmatterM).setUnlocalizedName("darksword");
	public static Item darkmattershovel = new darkmattershovel(darkmatterM).setUnlocalizedName("darkshovel");
	public static Item redmatterpickaxe = new redmatterpickaxe(redmatterM).setUnlocalizedName("redpick");
	public static Item redmatteraxe = new redmatteraxe(redmatterM).setUnlocalizedName("redaxe");
	public static Item redmattersword = new redmattersword(redmatterM).setUnlocalizedName("redsword");
	public static Item redmattershovel = new redmattershovel(redmatterM).setUnlocalizedName("redshovel");
	public static Item copperpickaxe = new copperpickaxe(copperM).setUnlocalizedName("copperpick");
	public static Item copperaxe = new copperaxe(copperM).setUnlocalizedName("copperaxe");
	public static Item coppersword = new coppersword(copperM).setUnlocalizedName("coppersword");
	public static Item coppershovel = new coppershovel(copperM).setUnlocalizedName("coppershovel");
	// armor
	public static Item darkmatterhelmet = new darkmatterarmor(darkM, helmetID, 0).setUnlocalizedName("darkhelmet");
	public static Item darkmatterchestplate = new darkmatterarmor(darkM, chestplateID, 1).setUnlocalizedName("darkchestplate");
	public static Item darkmatterleggings = new darkmatterarmor(darkM, leggingsID, 2).setUnlocalizedName("darkleggings");
	public static Item darkmatterboots = new darkmatterarmor(darkM, bootsID, 3).setUnlocalizedName("darkboots");
	public static Item redmatterhelmet = new redmatterarmor(darkM, helmetID, 0).setUnlocalizedName("redhelmet");
	public static Item redmatterchestplate = new redmatterarmor(darkM, chestplateID, 1).setUnlocalizedName("redchestplate");
	public static Item redmatterleggings = new redmatterarmor(darkM, leggingsID, 2).setUnlocalizedName("redleggings");
	public static Item redmatterboots = new redmatterarmor(darkM, bootsID, 3).setUnlocalizedName("redboots");
	public static Item helmet = new armor(redM, helmetID, 0).setUnlocalizedName("helmet");
	public static Item chestplate = new armor(redM, chestplateID, 1).setUnlocalizedName("chestplate");
	public static Item leggings = new armor(redM, leggingsID, 2).setUnlocalizedName("leggings");
	public static Item boots = new armor(redM, bootsID, 3).setUnlocalizedName("boots");
    // dec. blocks
	public static Block blacktile = new blacktile(Material.rock).setBlockName("blacktile");
	public static Block name1 = new name1(Material.anvil).setBlockName("name1");
	public static Block name2 = new name2(Material.ground).setBlockName("name2");
	public static Block name3 = new name3(Material.ground).setBlockName("name3");
	public static Block name4 = new name4(Material.ground).setBlockName("name4");
	public static Block name5 = new name5(Material.ground).setBlockName("name5");
	public static Block limestone = new limestone(Material.rock).setBlockName("limestone");
	public static Block marble = new marble(Material.rock).setBlockName("marble");
	public static Block granite = new granite(Material.rock).setBlockName("granite");
	public static Block quartz = new quartz(Material.rock).setBlockName("quartz");
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	GameRegistry.registerBlock(nitrogencompressor, "Nitrogencompressor");
 		GameRegistry.registerItem(nitrogen, "Nitrogen");
 		GameRegistry.registerItem(Firon, "firon");
 		GameRegistry.registerItem(IC, "IC");
 		GameRegistry.registerBlock(compressor, "compressor");
 		GameRegistry.registerItem(ironplate, "ironplate");
 		GameRegistry.registerBlock(machinechassis, "machinechassis");
 		GameRegistry.registerItem(darkmatter, "darkmatter");
 		GameRegistry.registerItem(copper, "copper");
 		GameRegistry.registerItem(tin, "tin");
 		//tools
 		GameRegistry.registerItem(darkmatteraxe, "darkaxe");
 		GameRegistry.registerItem(darkmatterpickaxe, "darkpick");
 		GameRegistry.registerItem(darkmattershovel, "darkshovel");
 		GameRegistry.registerItem(darkmattersword, "darksword");
 		GameRegistry.registerItem(redmatteraxe, "redaxe");
 		GameRegistry.registerItem(redmatterpickaxe, "redpick");
 		GameRegistry.registerItem(redmattershovel, "redshovel");
 		GameRegistry.registerItem(redmattersword, "redsword");
 		GameRegistry.registerItem(copperaxe, "copperaxe");
 		GameRegistry.registerItem(copperpickaxe, "copperpick");
 		GameRegistry.registerItem(coppershovel, "coppershovel");
 		GameRegistry.registerItem(coppersword, "coppersword");
 		GameRegistry.registerItem(redmatter, "redmatter");
 		//armor
 		GameRegistry.registerItem(darkmatterhelmet, "darkhelmet");
 		GameRegistry.registerItem(darkmatterchestplate, "darkchestplate");
 		GameRegistry.registerItem(darkmatterleggings, "darkleggings");
 		GameRegistry.registerItem(darkmatterboots, "darkboots");
 		GameRegistry.registerItem(redmatterhelmet, "redhelmet");
 		GameRegistry.registerItem(redmatterchestplate, "redchestplate");
 		GameRegistry.registerItem(redmatterleggings, "redleggings");
 		GameRegistry.registerItem(redmatterboots, "redboots");
 		GameRegistry.registerItem(helmet, "helmet");
 		GameRegistry.registerItem(chestplate, "chestplate");
 		GameRegistry.registerItem(leggings, "leggings");
 		GameRegistry.registerItem(boots, "boots");
 		// dec. blocks
 		GameRegistry.registerBlock(blacktile, "blacktile");
 		GameRegistry.registerBlock(name1, "name1");
 		GameRegistry.registerBlock(name2, "name2");
 		GameRegistry.registerBlock(name3, "name3");
 		GameRegistry.registerBlock(name4, "name4");
 		GameRegistry.registerBlock(name5, "name5");
 		GameRegistry.registerBlock(limestone, "limestone");
 		GameRegistry.registerBlock(marble, "marble");
 		GameRegistry.registerBlock(granite, "granite");
 		GameRegistry.registerBlock(quartz, "quartz");
 		GameRegistry.registerBlock(copperore, "copperore");
 		GameRegistry.registerBlock(tinore, "tinore");
 		
 		GameRegistry.registerWorldGenerator(worldgen, 1);
 		
		GameRegistry.addRecipe(new ItemStack(nitrogencompressor), new Object[]{"xxx", "srs", "xxx", 's', Items.diamond, 'x', Items.iron_ingot, 'r', IC});
		GameRegistry.addRecipe(new ItemStack(Firon), new Object[]{"rrr", "rxr", "rrr", 's', Items.diamond, 'x', Items.iron_ingot, 'r', nitrogen});
		GameRegistry.addRecipe(new ItemStack(IC), new Object[]{"rrr", "sxs", "rrr", 's', Items.redstone, 'x', Items.iron_ingot, 'r', Blocks.wool});
		GameRegistry.addRecipe(new ItemStack(compressor), new Object[]{"rrr", "sxs", "rrr", 's', Items.redstone, 'x', IC, 'r', Firon});
		GameRegistry.addRecipe(new ItemStack(machinechassis, 32), new Object[]{"rrr", "r r", "rrr", 'r',ironplate});
		GameRegistry.addRecipe(new ItemStack(blacktile, 32), new Object[]{"rrr", "rsr", "rrr", 's', machinechassis, 'r', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(name1, 32), new Object[]{"rrr", "rsr", "rrr", 's', machinechassis, 'r', Items.clay_ball});
		GameRegistry.addRecipe(new ItemStack(name2, 32), new Object[]{"rrr", "rsr", "rrr", 's', machinechassis, 'r', Items.glowstone_dust});
		GameRegistry.addRecipe(new ItemStack(darkmatter, 1), new Object[]{"iri", "rsr", "iri", 's', machinechassis, 'r', Items.diamond, 'i', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(redmatter, 1), new Object[]{"rrr", "rsr", "rrr", 's', darkmatter, 'r', Blocks.diamond_block});
		GameRegistry.addRecipe(new ItemStack(name3, 32), new Object[]{"rrr", "rsr", "rrr", 's', machinechassis, 'r', Items.arrow});
		GameRegistry.addRecipe(new ItemStack(name4, 32), new Object[]{"rrr", "rsr", "rrr", 's', machinechassis, 'r', Items.bone});
		GameRegistry.addRecipe(new ItemStack(name5, 32), new Object[]{"rrr", "rsr", "rrr", 's', machinechassis, 'r', Items.carrot});
		//tools
		GameRegistry.addRecipe(new ItemStack(darkmatteraxe, 1), new Object[]{"rr ", "rs ", " s ", 's', Items.diamond, 'r', darkmatter});
		GameRegistry.addRecipe(new ItemStack(darkmatterpickaxe, 1), new Object[]{"rrr", " s ", " s ", 's', Items.diamond, 'r', darkmatter});
		GameRegistry.addRecipe(new ItemStack(darkmattershovel, 1), new Object[]{" r ", " s ", " s ", 's', Items.diamond, 'r', darkmatter});
		GameRegistry.addRecipe(new ItemStack(darkmattersword, 1), new Object[]{" r ", " r ", " s ", 's', Items.diamond, 'r', darkmatter});
		GameRegistry.addRecipe(new ItemStack(redmatteraxe, 1), new Object[]{"rr ", "rs ", " s ", 's', Items.diamond, 'r', redmatter});
		GameRegistry.addRecipe(new ItemStack(redmatterpickaxe, 1), new Object[]{"rrr", " s ", " s ", 's', Items.diamond, 'r', redmatter});
		GameRegistry.addRecipe(new ItemStack(redmattershovel, 1), new Object[]{" r ", " s ", " s ", 's', Items.diamond, 'r', redmatter});
		GameRegistry.addRecipe(new ItemStack(redmattersword, 1), new Object[]{" r ", " r ", " s ", 's', Items.diamond, 'r', redmatter});
		GameRegistry.addRecipe(new ItemStack(copperaxe, 1), new Object[]{"rr ", "rs ", " s ", 's', Items.stick, 'r', copper});
		GameRegistry.addRecipe(new ItemStack(copperpickaxe, 1), new Object[]{"rrr", " s ", " s ", 's', Items.stick, 'r', copper});
		GameRegistry.addRecipe(new ItemStack(coppershovel, 1), new Object[]{" r ", " s ", " s ", 's', Items.stick, 'r', copper});
		GameRegistry.addRecipe(new ItemStack(coppersword, 1), new Object[]{" r ", " r ", " s ", 's', Items.stick, 'r', copper});
		// armor
		GameRegistry.addRecipe(new ItemStack(darkmatterhelmet, 1), new Object[]{"xxx", "x x", "   ", 'r', darkmatter});
		GameRegistry.addRecipe(new ItemStack(darkmatterchestplate, 1), new Object[]{"x x", "xxx", "xxx", 'r', darkmatter});
		GameRegistry.addRecipe(new ItemStack(darkmatterleggings, 1), new Object[]{"xxx", "x x", "x x", 'r', darkmatter});
		GameRegistry.addRecipe(new ItemStack(darkmatterboots, 1), new Object[]{"   ", "x x", "x x", 'r', darkmatter});
		GameRegistry.addRecipe(new ItemStack(redmatterhelmet, 1), new Object[]{"xxx", "x x", "   ", 'r', redmatter});
		GameRegistry.addRecipe(new ItemStack(redmatterchestplate, 1), new Object[]{"x x", "xxx", "xxx", 'r', redmatter});
		GameRegistry.addRecipe(new ItemStack(redmatterleggings, 1), new Object[]{"xxx", "x x", "x x", 'r', redmatter});
		GameRegistry.addRecipe(new ItemStack(redmatterboots, 1), new Object[]{"   ", "x x", "x x", 'r', redmatter});
		// furnace
		GameRegistry.addSmelting(tinore, new ItemStack(tin, 2), 30.0F);
		GameRegistry.addSmelting(copperore, new ItemStack(copper, 2), 30.0F);
		GameRegistry.addSmelting(Blocks.iron_ore, new ItemStack(Items.iron_ingot, 2), 30.0F);
		GameRegistry.addSmelting(Blocks.gold_ore, new ItemStack(Items.gold_ingot, 2), 30.0F);
    }
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event){

    }
    public void preInit(FMLPreInitializationEvent event){
    }
}
