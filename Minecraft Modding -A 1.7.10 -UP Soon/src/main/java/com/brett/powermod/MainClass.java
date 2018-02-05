package com.brett.powermod;

import java.util.Random;

import com.brett.powermod.armor.enderarmor;
import com.brett.powermod.block.AntiMater;
import com.brett.powermod.block.CopperOre;
import com.brett.powermod.block.FastFurnace;
import com.brett.powermod.block.Infuser;
import com.brett.powermod.block.TinOre;
import com.brett.powermod.block.TutFurance;
import com.brett.powermod.block.TweekIron;
import com.brett.powermod.entitys.TileEntityFastFurnace;
import com.brett.powermod.item.AntiMaterIngot;
import com.brett.powermod.item.CopperIngot;
import com.brett.powermod.item.DarkMater;
import com.brett.powermod.item.EnderIngot;
import com.brett.powermod.item.ManaBlend;
import com.brett.powermod.item.MetaItem;
import com.brett.powermod.item.SteelIngot;
import com.brett.powermod.item.TinIngot;
import com.brett.powermod.tools.antimatteraxe;
import com.brett.powermod.tools.antimatterpickaxe;
import com.brett.powermod.tools.antimattershovel;
import com.brett.powermod.tools.antimattersword;
import com.brett.powermod.tools.darkmatteraxe;
import com.brett.powermod.tools.darkmatterpickaxe;
import com.brett.powermod.tools.darkmattershovel;
import com.brett.powermod.tools.darkmattersword;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.GameRegistry;

	@Mod(modid = MainClass.MODID, name = MainClass.NAME, version = MainClass.VERSION)
	public class MainClass
	{
		@SidedProxy(clientSide = "com.brett.powermod.ClientProxy", serverSide = "com.brett.powermod.CommonProxy")
		public static CommonProxy proxy;
		
		public static worldgenclass worldgen = new worldgenclass(); 
		
		public static ToolMaterial darkM = EnumHelper.addToolMaterial("enderM", 4, 2500, 12.0F, 4, 30); 
		public static ToolMaterial AntiM = EnumHelper.addToolMaterial("AntiM", 4, 0, 30.0F, 5, 30); 
		public static ArmorMaterial enderMA = EnumHelper.addArmorMaterial("enderMA", 66, new int []{4, 7, 6, 2}, 30);
		
		public static int helmetID;
		public static int chestplateID;
		public static int leggingsID;
		public static int bootsID;
		
		public static final String MODID = "mod";
		public static final String NAME = "brettsmod";
		public static final String VERSION = "0.0.1";
		
		
		// Ores
		public static Block TweekIron = new TweekIron();
		public static Block CopperOre = new CopperOre(Material.rock);
		public static Block TinOre = new TinOre(Material.rock);
		public static Block AntiMater = new AntiMater(Material.rock);
		
		// Entitys
		public static Block FastFurnaceOn = new FastFurnace(true);
		public static Block FastFurnaceOff = new FastFurnace(false).setCreativeTab(CreativeTabs.tabBlock);
		
		public static Block tutFurnace = new TutFurance(false).setBlockName("TutFurnace").setCreativeTab(CreativeTabs.tabBlock);
		public static Block tutFurnaceActive = new TutFurance(true).setBlockName("TutFurnaceActive");
		
		public static Block Infuser = new Infuser(false).setBlockName("Infuser").setCreativeTab(CreativeTabs.tabBlock);
		public static Block InfuserActive = new Infuser(true).setBlockName("InfuserActive");
		
		
		// Ingots
		public static Item CopperIngot = new CopperIngot();
		public static Item TinIngot = new TinIngot();
		public static Item AntiMaterIngot = new AntiMaterIngot();
		public static Item EnderIngot = new EnderIngot();
		public static Item DarkMater = new DarkMater();
		public static Item SteelIngot = new SteelIngot();
		
		// Others
		
		public static Item ManaBlend = new ManaBlend();
		public static Item metaitem;
		
		// Armor
		public static Item enderhelmet = new enderarmor(enderMA, helmetID, 0).setUnlocalizedName("enderhelmet");
		public static Item enderchestplate = new enderarmor(enderMA, chestplateID, 1).setUnlocalizedName("enderchestplate");
		public static Item enderleggings = new enderarmor(enderMA, leggingsID, 2).setUnlocalizedName("enderleggings");
		public static Item enderboots = new enderarmor(enderMA, bootsID, 3).setUnlocalizedName("enderboots");
		
		// Tools
		public static Item darkmatterpickaxe = new darkmatterpickaxe(darkM).setUnlocalizedName("darkpick");
		public static Item darkmatteraxe = new darkmatteraxe(darkM).setUnlocalizedName("darkaxe");
		public static Item darkmattersword = new darkmattersword(darkM).setUnlocalizedName("darksword");
		public static Item darkmattershovel = new darkmattershovel(darkM).setUnlocalizedName("darkshovel");
		
		public static Item antimatterpickaxe = new antimatterpickaxe(AntiM).setUnlocalizedName("antipick");
		public static Item antimatteraxe = new antimatteraxe(AntiM).setUnlocalizedName("antiaxe");
		public static Item antimattersword = new antimattersword(AntiM).setUnlocalizedName("antisword");
		public static Item antimattershovel = new antimattershovel(AntiM).setUnlocalizedName("antishovel");
		
		//itemstacks
		public static ItemStack ManaIngot = new ItemStack(metaitem, 1, 0);
		public static ItemStack PhilosopherStone = new ItemStack(metaitem, 1, 1);
		public static ItemStack ElectromagneticCoil = new ItemStack(metaitem, 1, 2);
		public static ItemStack Battery = new ItemStack(metaitem, 1, 3);
		public static ItemStack ItemReplicator = new ItemStack(metaitem, 1, 4);
		public static ItemStack Mana = new ItemStack(metaitem, 1, 5);
		
		@Instance(MODID)
		public static MainClass modInstance;
		
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		proxy.registerNetworkStuff();
		
		// Ores
 		GameRegistry.registerBlock(TweekIron, "TweekIron");
 		GameRegistry.registerBlock(CopperOre, "CopperOre");
 		GameRegistry.registerBlock(TinOre, "TinOre");
 		GameRegistry.registerBlock(AntiMater, "AntiMater");
 		// Ingots
 		GameRegistry.registerItem(CopperIngot, "CopperIngot");
 		GameRegistry.registerItem(TinIngot, "TinIngot");
 		GameRegistry.registerItem(AntiMaterIngot, "AntiMaterIngot");
 		GameRegistry.registerItem(EnderIngot, "EnderIngot");
 		GameRegistry.registerItem(DarkMater, "DarkMater");
 		GameRegistry.registerItem(SteelIngot, "SteelIngot");
 		
 		// tools
 		GameRegistry.registerItem(darkmatteraxe, "darkaxe");
 		GameRegistry.registerItem(darkmatterpickaxe, "darkpick");
 		GameRegistry.registerItem(darkmattershovel, "darkshovel");
 		GameRegistry.registerItem(darkmattersword, "darksword");
 		
 		GameRegistry.registerItem(antimatteraxe, "antiaxe");
 		GameRegistry.registerItem(antimatterpickaxe, "antipick");
 		GameRegistry.registerItem(antimattershovel, "antishovel");
 		GameRegistry.registerItem(antimattersword, "antisword");
 		
 		// Other Blocks
 		GameRegistry.registerBlock(tutFurnace, tutFurnace.getUnlocalizedName());
 		GameRegistry.registerBlock(tutFurnaceActive, tutFurnaceActive.getUnlocalizedName());
 		
 		GameRegistry.registerBlock(Infuser, Infuser.getUnlocalizedName());
 		GameRegistry.registerBlock(InfuserActive, InfuserActive.getUnlocalizedName());
 		
 		// Other Items
 		
 		GameRegistry.registerItem(ManaBlend, ManaBlend.getUnlocalizedName());
 		GameRegistry.registerItem(metaitem = new MetaItem("metaitem"), "metaitem");
 		
 		// Armor
 		
 		GameRegistry.registerItem(enderhelmet, "enderhelmet");
 		GameRegistry.registerItem(enderchestplate, "enderchestplate");
 		GameRegistry.registerItem(enderleggings, "enderleggings");
 		GameRegistry.registerItem(enderboots, "enderboots");
 		
 		//Other

 		GameRegistry.addSmelting(TweekIron, new ItemStack(Items.iron_ingot), 5.0f);
 		GameRegistry.addSmelting(CopperOre, new ItemStack(CopperIngot), 5.0f);
 		GameRegistry.addSmelting(TinOre, new ItemStack(TinIngot), 5.0f);
 		GameRegistry.addSmelting(AntiMater, new ItemStack(AntiMaterIngot), 5.0f);
 		GameRegistry.addSmelting(new ItemStack(Items.iron_ingot, 2), new ItemStack(SteelIngot), 5.0f);
 		
 		
 		InfuserRecipes.smelting().addRecipie(ManaBlend, Items.blaze_powder, new ItemStack(metaitem, 1, 0));
 		InfuserRecipes.smelting().addRecipie(Blocks.diamond_block, Items.blaze_rod, new ItemStack(DarkMater));
 		InfuserRecipes.smelting().addRecipie(DarkMater, ManaIngot, new ItemStack(AntiMaterIngot));
 		InfuserRecipes.smelting().putLists(new ItemStack(ManaBlend), ManaIngot, Mana);
 		
 		GameRegistry.addRecipe(new ItemStack(EnderIngot), new Object[] {"yyy","xxx","yyy", 'x', Items.ender_pearl, 'y', Items.iron_ingot});
 		GameRegistry.addRecipe(new ItemStack(ManaBlend), new Object[] {"yyy","yxy","yyy", 'x', Items.ender_pearl, 'y', Items.redstone});
 		GameRegistry.addRecipe(new ItemStack(Infuser), new Object[] {"zzz","ycy","zzz", 'x', Items.ender_pearl, 'y', Items.redstone , 'z', SteelIngot, 'c', new ItemStack(metaitem, 1, 2)});
 		GameRegistry.addRecipe(PhilosopherStone, new Object[] {"xyx","yxy","xyx", 'x', Items.ender_pearl, 'y', Items.redstone , 'z', SteelIngot, 'c', new ItemStack(metaitem, 1, 2)});
 		GameRegistry.addRecipe(ElectromagneticCoil, new Object[] {"yyy","zzz","yyy", 'x', Items.ender_pearl, 'y', Items.redstone , 'z', SteelIngot, 'c', new ItemStack(metaitem, 1, 2)});
 		GameRegistry.addRecipe(Battery, new Object[] {" z ","zyz","zyz", 'x', Items.ender_pearl, 'y', Items.redstone , 'z', TinIngot, 'c', new ItemStack(metaitem, 1, 2)});
 		GameRegistry.addRecipe(ItemReplicator, new Object[] {" z ","zyz","yyy", 'x', Items.ender_pearl, 'y', Blocks.redstone_block , 'z', SteelIngot, 'c', new ItemStack(metaitem, 1, 2)});
 		
 		GameRegistry.addRecipe(new ItemStack(darkmatteraxe, 1), new Object[]{"rr ", "rs ", " y ", 's', Items.stick, 'r', DarkMater, 'y', ItemReplicator});
		GameRegistry.addRecipe(new ItemStack(darkmatterpickaxe, 1), new Object[]{"rrr", " s ", " y ", 's', Items.stick, 'r', DarkMater, 'y', ItemReplicator});
		GameRegistry.addRecipe(new ItemStack(darkmattershovel, 1), new Object[]{" r ", " s ", " y ", 's', Items.stick, 'r', DarkMater, 'y', ItemReplicator});
		GameRegistry.addRecipe(new ItemStack(darkmattersword, 1), new Object[]{" r ", " r ", " y ", 's', Items.stick, 'r', DarkMater, 'y', ItemReplicator});
 		
 		GameRegistry.addRecipe(new ItemStack(antimatteraxe, 1), new Object[]{"rr ", "rs ", " y ", 's', Items.diamond, 'r', AntiMaterIngot, 'y', ItemReplicator});
		GameRegistry.addRecipe(new ItemStack(antimatterpickaxe, 1), new Object[]{"rrr", " s ", " y ", 's', Items.diamond, 'r', AntiMaterIngot, 'y', ItemReplicator});
		GameRegistry.addRecipe(new ItemStack(antimattershovel, 1), new Object[]{" r ", " s ", " y ", 's', Items.diamond, 'r', AntiMaterIngot, 'y', ItemReplicator});
		GameRegistry.addRecipe(new ItemStack(antimattersword, 1), new Object[]{" r ", " r ", " y ", 's', Items.diamond, 'r', AntiMaterIngot, 'y', ItemReplicator});
 		
		GameRegistry.registerWorldGenerator(worldgen, 1);
    }
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event){

    }
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	try {
    		Block myIron = new TweekIron();
            GameRegistry.addSubstitutionAlias("minecraft:iron_ore", GameRegistry.Type.BLOCK, myIron);
            GameRegistry.addSubstitutionAlias("minecraft:iron_ore", GameRegistry.Type.ITEM, new ItemMultiTexture(myIron, myIron, new String[] { "default", "red", "my" }).setUnlocalizedName("oreIron"));
        } catch (ExistingSubstitutionException e) {
            e.printStackTrace();
        }
    }
}
