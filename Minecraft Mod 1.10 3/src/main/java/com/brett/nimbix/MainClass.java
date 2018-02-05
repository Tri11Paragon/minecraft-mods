package com.brett.nimbix;

import ibxm.Player;

import java.text.DecimalFormat;

import com.brett.nimbix.blocks.BlockManager;
import com.brett.nimbix.items.ItemManager;
import com.brett.randomthings.machines.BlockClass;
import com.brett.recipies.RecipieHandler;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.block.Block;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
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
	    public static Block getBlock(World world, BlockPos pos){
	    	return world.getBlockState(pos).getBlock();
	    }
	    public static Block getBlock(World world, int x, int y, int z){
	    	return world.getBlockState(new BlockPos(x,y,z)).getBlock();
	    }
	    public static void setBlockToAir(World world, BlockPos pos){
	    	world.setBlockState(pos, Blocks.AIR.getDefaultState());
	    }
	    public static void setBlockToAir(World world, int x, int y, int z){
	    	world.setBlockState(new BlockPos(x,y,z), Blocks.AIR.getDefaultState());
	    }
	    public static void setBlockToAirWithDrop(World world, IBlockState state, BlockPos pos, Block blockAllowed){
	    	if (MainClass.getBlock(world, pos) == blockAllowed){
	    		MainClass.getBlock(world, pos).dropBlockAsItem(world, pos, state, 3);
	    		world.setBlockState(pos, Blocks.AIR.getDefaultState());
	    	}
	    }
	    public static void dropBlock(World world, IBlockState state, BlockPos pos){
	    	MainClass.getBlock(world, pos).dropBlockAsItem(world, pos, state, 3);
	    }
	    public static void dropBlock(World world, IBlockState state, int i,int j,int k){
	    	MainClass.getBlock(world, new BlockPos(i,j,k)).dropBlockAsItem(world, new BlockPos(i,j,k), state, 3);
	    }
	    public static void setBlockToAirWithDrop(World world, IBlockState state, int x, int y, int z, Block blockAllowed){
	    	if (MainClass.getBlock(world, new BlockPos(x,y,z)) == blockAllowed){
	    		MainClass.getBlock(world, new BlockPos(x,y,z)).dropBlockAsItem(world, new BlockPos(x,y,z), state, 3);
	    		world.setBlockState(new BlockPos(x,y,z), Blocks.AIR.getDefaultState());
	    	}
	    }
	    public static void setBlockToAirWithDrop(World world, IBlockState state, BlockPos pos, BlockPos dropPos){
	    	MainClass.getBlock(world, pos).dropBlockAsItem(world, dropPos, state, 0);
	    	world.setBlockState(pos, Blocks.AIR.getDefaultState());
	    }
	    public static void setBlockToAirWithDrop(World world, IBlockState state, BlockPos pos){
	    	MainClass.getBlock(world, pos).dropBlockAsItem(world, pos, state, 3);
	    	world.setBlockState(pos, Blocks.AIR.getDefaultState());
	    }
	    public static void setBlockToAirWithDrop(World world, IBlockState state, int x, int y, int z){
	    	MainClass.getBlock(world, new BlockPos(x,y,z)).dropBlockAsItem(world, new BlockPos(x,y,z), state, 3);
	    	world.setBlockState(new BlockPos(x,y,z), Blocks.AIR.getDefaultState());
	    }
	    public static String foramteNumber(String amount){
	    	double ad = Double.parseDouble(amount);
	    	DecimalFormat formatter = new DecimalFormat("#,###");
	    	return formatter.format(ad);
	    }
		
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		
		proxy.Init();
		proxy.registerModelBakeryVarients();
		proxy.registerNetworkStuff();
		KeyBindings.init();
		RecipieHandler.registerCrafting();
		
		proxy.registerNetworkStuff();
    }
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	BlockManager.Main();
    	ItemManager.Main();
    	BlockClass.Main();
    	TeleportTileEntitys.register();
    	proxy.PreInit();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	proxy.PostInit();
    }
}