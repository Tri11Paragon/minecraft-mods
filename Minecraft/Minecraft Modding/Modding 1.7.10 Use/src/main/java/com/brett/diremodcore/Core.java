package com.brett.diremodcore;

import com.brett.diremod.MainClass;
import com.brett.diremodcore.blocks.blockbreaker;
import com.brett.diremodcore.blocks.obsidianglass;
import com.brett.diremodcore.blocks.orangeore;
import com.brett.diremodcore.items.bacon;
import com.brett.diremodcore.items.unnamed;
import com.brett.direop.Mains;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Core.MODID, name = Core.NAME, version = Core.VERSION)
public class Core
{
	@SidedProxy(clientSide = "com.brett.diremodcore.ClientProxy", serverSide = "com.brett.diremodcore.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(Core.MODID)
	public static Core modinstance;
	
	public static int helmetID;
	public static int chestplateID;
	public static int leggingsID;
	public static int bootsID;
	
	public static final String MODID = "direcore";
	public static final String NAME = "direcore";
	public static final String VERSION = Mains.VERSION;
	
	public static Block orangeore = new orangeore(Material.rock).setBlockName("oranceore");
	public static Block obsidianglass = new obsidianglass(Material.glass, true).setBlockName("obsidianglass");
	public static Block blockbreaker = new blockbreaker(Material.rock).setBlockName("blockbreaker");
	public static Item bacon = new bacon(3, 5, true).setUnlocalizedName("bacon");
	public static Block unnamed = new unnamed();
	
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	GameRegistry.registerBlock(obsidianglass, "obsidianglass");
    	GameRegistry.registerBlock(blockbreaker, "blockbreaker");
    	GameRegistry.registerItem(bacon, "bacon");
    	GameRegistry.registerBlock(orangeore, "orangeore");
    	GameRegistry.registerBlock(unnamed, "unnamed");
    	addNames();
    	oreRegistration();
    	addOreRecipes();
    }
    private void addOreRecipes() {
		
	}
	private void oreRegistration() {
		OreDictionary.registerOre("tin", MainClass.tin);
	}
	private void addNames() {
		
	}
	@EventHandler
    public void serverLoad(FMLServerStartingEvent event){
    }
    public void preInit(FMLPreInitializationEvent event){
 
    }
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
