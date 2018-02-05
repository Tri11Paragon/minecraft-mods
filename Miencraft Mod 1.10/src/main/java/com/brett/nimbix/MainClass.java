package com.brett.nimbix;

import ibxm.Player;

import com.brett.nimbix.blocks.BBlocks;
import com.brett.nimbix.blocks.Ore;
import com.brett.nimbix.helpers.RecipieHandler;
import com.brett.nimbix.items.OtherItems;
import com.brett.nimbix.items.ingots.Ingots;
import com.brett.nimbix.items.machine.MachineItems;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;

	@Mod(modid = MainClass.MODID, name = MainClass.NAME, version = MainClass.VERSION)
	public class MainClass
	{
		@SidedProxy(clientSide = "com.brett.nimbix.ClientProxy", serverSide = "com.brett.nimbix.CommonProxy")
		public static CommonProxy proxy;
		
		//public static worldgenclass worldgen = new worldgenclass(); 
		
		//public static ToolMaterial darkM = EnumHelper.addToolMaterial("enderM", 4, 2500, 12.0F, 4, 30); 
		public static ArmorMaterial enderMA = EnumHelper.addArmorMaterial("enderMA", "", 66, new int []{4, 7, 6, 2}, 30, null,1.0f);
		
		public static final String MODID = "mod";
		public static final String NAME = "brettsmod";
		public static final String VERSION = "0.0.1";
		
		public static final MCreativeTab modTab = new MCreativeTab(NAME);
		
		@Instance(MODID)
		public static MainClass modInstance;
		
	
	public static void print(String c){
		System.out.println(c);
	}
	public static void printChat(String c, EntityPlayer p, ChatFormatting ch){
		p.addChatComponentMessage(new TextComponentString(ch + c));
	}
    public static void error(EntityPlayer player, String msg) {
   	 player.addChatComponentMessage(new TextComponentString(ChatFormatting.RED + msg));
   }
		
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		proxy.Init();
		proxy.registerNetworkStuff();
		MinecraftForge.EVENT_BUS.register(com.brett.nimbix.helpers.EventHandler.class);
		
		//GameRegistry.addRecipe(new ItemStack(Dust.FluxDust, 1), new Object[]{"xxx", "yyy", "xxx", 'x', Blocks.REDSTONE_WIRE, 'y', Items.IRON_INGOT});
		
		RecipieHandler.registerCrafting();
		RecipieHandler.registerSmelting();
		
		/*if (event.getSide() == Side.CLIENT) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(enderhelmet, 0, new ModelResourceLocation(MainClass.MODID + ":enderhead", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(enderchestplate, 0, new ModelResourceLocation(MainClass.MODID + ":enderbody", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(enderleggings, 0, new ModelResourceLocation(MainClass.MODID + ":enderleggins", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(enderboots, 0, new ModelResourceLocation(MainClass.MODID + ":enderboots", "inventory"));
		}*/
		
		proxy.registerNetworkStuff();
 		
		//GameRegistry.registerWorldGenerator(worldgen, 1);
    }
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event){
    	MinecraftForge.EVENT_BUS.register(com.brett.nimbix.helpers.EventHandler.class);
    }
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register(com.brett.nimbix.helpers.EventHandler.class);
    	//Dust.Main();
    	Ore.Main();
    	Ingots.Main();
    	BBlocks.Main();
    	OtherItems.Main();
    	MachineItems.Main();
    	InfuserRecipes.smelting().addRecipie(Items.IRON_INGOT, Items.GOLD_INGOT, new ItemStack(Items.GOLDEN_APPLE));
    	
    	//OtherBlocks.Main();
    	//OtherItems.Main();
    	TeleportTileEntitys.register();
    	proxy.PreInit();
    	/*try {
    		Block myIron = new TweekIron();
            GameRegistry.addSubstitutionAlias("minecraft:iron_ore", GameRegistry.Type.BLOCK, myIron);
            GameRegistry.addSubstitutionAlias("minecraft:iron_ore", GameRegistry.Type.ITEM, new ItemMultiTexture(myIron, myIron, new String[] { "default", "red", "my" }).setUnlocalizedName("oreIron"));
        } catch (ExistingSubstitutionException e) {
            e.printStackTrace();
        }*/
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	proxy.PostInit();
    }
}