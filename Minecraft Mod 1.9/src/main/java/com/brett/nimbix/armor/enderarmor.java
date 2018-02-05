package com.brett.nimbix.armor;

import com.brett.nimbix.MainClass;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class enderarmor extends ItemArmor {
	
	public static Item helmet;
	public static Item body;
	public static Item legs;
	public static Item boots;
	public static Object instance;
	
	public enderarmor(ArmorMaterial material, int id, EntityEquipmentSlot placement) {
		super(material, id, placement);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		/*if (placement.HEAD != null) {
			this.setTextureName(MainClass.MODID + ":enderhead"); // helmet
		}
		else if (placement.CHEST != null) {
			this.setTextureName(MainClass.MODID + ":enderbody"); // chestpalte
		}
		else if (placement.LEGS != null) {
			this.setTextureName(MainClass.MODID + ":enderleggins"); // leggings
		}
		else if (placement.FEET != null) {
			this.setTextureName(MainClass.MODID + ":enderboots"); // boots
		}*/
	}
	
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		if (event.getSide() == Side.CLIENT) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(helmet, 0, new ModelResourceLocation(MainClass.MODID + ":enderhead", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(body, 0, new ModelResourceLocation(MainClass.MODID + ":enderbody", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(legs, 0, new ModelResourceLocation(MainClass.MODID + ":enderleggins", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(boots, 0, new ModelResourceLocation(MainClass.MODID + ":enderboots", "inventory"));
		}
		
		helmet.setCreativeTab(CreativeTabs.COMBAT);
		body.setCreativeTab(CreativeTabs.COMBAT);
		legs.setCreativeTab(CreativeTabs.COMBAT);
		boots.setCreativeTab(CreativeTabs.COMBAT);
    }
	static {
		ArmorMaterial enuma = EnumHelper.addArmorMaterial("enderMA", "", 66, new int []{4, 7, 6, 2}, 30, null,1.0f);

		int armorPreffix = 0;
		helmet = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.HEAD) {
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
				int i = (int) entity.posX;
				int j = (int) entity.posY;
				int k = (int) entity.posZ;
			}
		}).setUnlocalizedName("WADWA_head");
		helmet.setMaxStackSize(1);
		body = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.CHEST) {
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
				int i = (int) entity.posX;
				int j = (int) entity.posY;
				int k = (int) entity.posZ;
			}
		}).setUnlocalizedName("WADWA_body");
		body.setMaxStackSize(1);
		legs = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.LEGS) {
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
				int i = (int) entity.posX;
				int j = (int) entity.posY;
				int k = (int) entity.posZ;
			}
		}).setUnlocalizedName("WADWA_leggins");
		legs.setMaxStackSize(1);
		boots = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.FEET) {
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
				int i = (int) entity.posX;
				int j = (int) entity.posY;
				int k = (int) entity.posZ;
			}
		}).setUnlocalizedName("WADWA_boots");
		boots.setMaxStackSize(1);
 		
		GameRegistry.register(helmet);
		GameRegistry.register(body);
		GameRegistry.register(legs);
		GameRegistry.register(boots);
	}
	
	
	/*public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == MainClass.enderhelmet || stack.getItem() == MainClass.enderchestplate || stack.getItem() == MainClass.enderboots) {
			return MainClass.MODID + ":textures/models/armor/DarkArmor_V1.png";
		}
		if (stack.getItem() == MainClass.enderleggings) {
			return MainClass.MODID + ":textures/models/armor/DarkArmor_V1.png";
		} else {
			return null;
		}
		
	}*/
	
	/*@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemstack){
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) {
			ItemStack helmet = player.getCurrentArmor(3);
			ItemStack chestplate = player.getCurrentArmor(2);
			ItemStack leggings = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			
			
			if (helmet.getItem() == MainClass.enderhelmet && chestplate.getItem() == MainClass.enderchestplate && leggings.getItem() == MainClass.enderleggings && boots.getItem() == MainClass.enderboots){
				//player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 300, 2));
				//player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 300, 2));
				//player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 300, 2));
				if(player.isUsingItem()){
					if (player.capabilities.isCreativeMode)
			        {
			            return;
			        }
			        else
			        {
			            --itemstack.stackSize;
			            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			            if (!world.isRemote)
			            {
			                world.spawnEntityInWorld(new EntityEnderPearl(world, player));
			                return;
			            }

			            return;
			        }
				}
			}
		}
	}*/
	

}