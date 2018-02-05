package com.power.brett.items;

import java.util.List;

import com.power.brett.MainClass;
import com.power.brett.utility.NBTHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BedrockIngot extends Item {
	
	public EntityPlayer names;
	
	public BedrockIngot(){
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":BedrockIngot");
		setUnlocalizedName("BedrockIngot");
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Heavy!");
	}
	public void onUpdate(ItemStack item, World world, Entity entity, int someint, boolean something) 
	{
		if(names != null){
			names.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 300, 4));
		}
	}
	public void onCreated(ItemStack item, World world, EntityPlayer player) 
	{
		names=player;
		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 3000, 4));
	}
	
}