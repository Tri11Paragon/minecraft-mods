package com.brett.tools;


import java.util.List;

import com.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class staffofpower extends ToolManager {

	public staffofpower(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":staff");
		setUnlocalizedName("staff");
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
		list.add("Mega Weapon");
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
		float var4 = 1.0F;
		int i = (int)(entity.posX);
		int j = (int)(entity.posY - 1);
		int k = (int) entity.posZ;
		if(true){
			world.setBlock(i, j, k, Blocks.stone);
		}
			return itemstack;
		}
	
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5) {
		int i = (int)entity.posX;
		int j = (int)entity.posY;
		int k = (int)entity.posZ;
		
		ItemStack boots = ((EntityPlayer) entity).getHeldItem();
		
		int m = EnchantmentHelper.getEnchantmentLevel(MainClass.speedBoost.effectId, boots);
		if(m > 0){
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 50, m + 1));
		}
		
		if(true){
		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 50, 5));
		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 50, 5));
		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 50, 5));
		if(entity instanceof EntityPlayer)((EntityPlayer)entity).capabilities.allowFlying = true;
		if(entity instanceof EntityPlayer)((EntityPlayer)entity).capabilities.setFlySpeed(0.1f);
		}
	
	}
}
