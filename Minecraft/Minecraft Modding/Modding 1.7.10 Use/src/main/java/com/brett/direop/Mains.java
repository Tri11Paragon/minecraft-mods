package com.brett.direop;

import com.brett.diremod.MainClass;
import com.brett.diremod.armor.redmatterarmor;
import com.brett.diremodcore.blocks.blockbreaker;
import com.brett.diremodcore.blocks.obsidianglass;
import com.brett.diremodcore.blocks.orangeore;
import com.brett.diremodcore.items.bacon;
import com.brett.diremodcore.items.unnamed;
import com.brett.direop.armor.Uarmor;
import com.brett.direop.blocks.wall;
import com.brett.direop.enchant.EnchantmentSpeedBoost;
import com.brett.direop.guns.gun;
import com.brett.direop.items.obsidianingot;
import com.brett.direop.items.unstableingot;
import com.brett.direop.magic.create;
import com.brett.direop.magic.lava;
import com.brett.direop.magic.lifedagger;
import com.brett.direop.magic.magic;
import com.brett.direop.magic.wand;
import com.brett.direop.magic.water;
import com.brett.direop.other.dimensionRegistry;
import com.brett.direop.tools.drill;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Mains.MODID, name = Mains.NAME, version = Mains.VERSION)
public class Mains
{
	@SidedProxy(clientSide = "com.brett.direop.ClientProxy", serverSide = "com.brett.direop.CommonProxy")
	public static CommonProxy proxy;
	
	public static final String MODID = "direop";
	public static final String NAME = "direop";
	public static final String VERSION = MainClass.VERSION;
	
	public static int helmetID;
	public static int chestplateID;
	public static int leggingsID;
	public static int bootsID;
	
	public static int LifePower = 0;
	
	public static ArmorMaterial superM = EnumHelper.addArmorMaterial("superM", 2000, new int []{5, 10, 10, 5}, 300);
	public static ToolMaterial Drill = EnumHelper.addToolMaterial("Drill", 3, 1800, 20, 3, 5);
	
	public static final Enchantment speedBoost = new EnchantmentSpeedBoost(84, 5);
	
	public static Item obsidianingot = new obsidianingot().setUnlocalizedName("obsidianingot");
	public static Item unstableingot = new unstableingot().setUnlocalizedName("unstableingot");
	public static Item drill = new drill(Drill);
	public static Item unstablehelmet = new Uarmor(superM, helmetID, 0).setUnlocalizedName("unstablehelmet");
	public static Item unstablechestplate = new Uarmor(superM, chestplateID, 1).setUnlocalizedName("unstablechestplate");
	public static Item unstableleggings = new Uarmor(superM, leggingsID, 2).setUnlocalizedName("unstableleggings");
	public static Item unstableboots = new Uarmor(superM, bootsID, 3).setUnlocalizedName("unstableboots");
	public static Block wall = new wall(Material.rock).setBlockName("wall");
	
	// magic
	public static Item lifedagger = new lifedagger();
	public static Item wand = new wand();
	public static Item water = new water();
	public static Item lava = new lava();
	public static Item create = new create();
	public static Block magic = new magic(Material.rock);
	
	public static Item gun = new gun().setUnlocalizedName("gun");
    //Aavak when will your next offworld trading company episode be uploaded?
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	FMLCommonHandler.instance().bus().register(new KeyInputHandler());
    	KeyBindings.init();
    	GameRegistry.registerItem(obsidianingot, "obsidianingot");
    	GameRegistry.registerItem(unstableingot, "unstableingot");
 		GameRegistry.registerItem(unstablehelmet, "unstablehelmet");
 		GameRegistry.registerItem(unstablechestplate, "unstablechestplate");
 		GameRegistry.registerItem(unstableleggings, "unstableleggings");
 		GameRegistry.registerItem(unstableboots, "unstableboots");
 		GameRegistry.registerItem(drill, "drill");
 		GameRegistry.registerBlock(wall, "wall");
 		GameRegistry.registerItem(lifedagger, "lifedagger");
 		GameRegistry.registerItem(wand, "wand");
 		GameRegistry.registerItem(water, "water");
 		GameRegistry.registerItem(lava, "lava");
 		GameRegistry.registerItem(create, "create");
    	GameRegistry.registerBlock(magic, "magic");
    	GameRegistry.registerItem(gun, "gun");
 		//magic
 		GameRegistry.addRecipe(new ItemStack(lifedagger, 1), new Object[]{" r ", " x ", " x ", 'r', Items.iron_ingot, 'x', Items.stick});
 		GameRegistry.addRecipe(new ItemStack(wand, 1), new Object[]{" r ", " x ", " x ", 'r', Items.diamond, 'x', Items.stick});
 		GameRegistry.addRecipe(new ItemStack(water, 1), new Object[]{"drd", "sxs", "drd", 'r', Items.water_bucket, 'x', wand, 's', Items.stick, 'd', Items.diamond});
 		GameRegistry.addRecipe(new ItemStack(lava, 1), new Object[]{"drd", "sxs", "drd", 'r', Items.lava_bucket, 'x', wand, 's', Items.stick, 'd', Items.diamond});
 		GameRegistry.addRecipe(new ItemStack(create, 1), new Object[]{"drd", "sxs", "drd", 'r', Items.blaze_rod, 'x', wand, 's', Items.stick, 'd', Items.gold_ingot});
 		//other
		GameRegistry.addRecipe(new ItemStack(unstablehelmet, 1), new Object[]{"xxx", "x x", "   ", 'x', unstableingot});
		GameRegistry.addRecipe(new ItemStack(unstablechestplate, 1), new Object[]{"x x", "xxx", "xxx", 'x', unstableingot});
		GameRegistry.addRecipe(new ItemStack(unstableleggings, 1), new Object[]{"xxx", "x x", "x x", 'x', unstableingot});
		GameRegistry.addRecipe(new ItemStack(unstableboots, 1), new Object[]{"   ", "x x", "x x", 'x', unstableingot});
 		GameRegistry.addRecipe(new ItemStack(obsidianingot), new Object[]{"rrr", "xrx", "xrx", 'r', Blocks.diamond_block, 'x', Blocks.obsidian});
 		GameRegistry.addRecipe(new ItemStack(unstableingot), new Object[]{"xrx", "xrx", "xrx", 'r', Blocks.diamond_block, 'x', obsidianingot});
    }
	@EventHandler
    public void serverLoad(FMLServerStartingEvent event){
		
    }
    public void preInit(FMLPreInitializationEvent event){
    	FMLCommonHandler.instance().bus().register(new KeyInputHandler());
    	KeyBindings.init();
    	dimensionRegistry.mainRegistry();
    }
    public void postInit(FMLPostInitializationEvent event)
    {
    	FMLCommonHandler.instance().bus().register(new KeyInputHandler());
    	KeyBindings.init();
    }
}
