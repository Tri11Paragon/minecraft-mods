package com.brett.powermod.tools;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.brett.powermod.MainClass;
import com.brett.powermod.helpers.NBTHelper;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class antimatterpickaxe extends ItemPickaxe {

	public antimatterpickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setTextureName(MainClass.MODID + ":antipick");
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	/*public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
		float var4 = 1.0F;
		int i = (int)(entity.posX);
		int j = (int)(entity.posY - 2);
		int k = (int) entity.posZ;
		if(true){
			world.setBlockToAir(i,j,k);
		}
		return itemstack;
	}*/
	
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
	    itemStack.stackTagCompound = new NBTTagCompound();
	    itemStack.stackTagCompound.setInteger("code", (int)(Math.random()*Integer.MAX_VALUE));
	    itemStack.stackTagCompound.setBoolean("P", false);
	}
	
    /*public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	//System.out.println(NBTHelper.getBoolean(p_77648_1_, "P"));
    	NBTHelper.setBoolean(p_77648_1_, "P", !NBTHelper.getBoolean(p_77648_1_, "P"));
    	
        return false;
    }*/
    
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
    	float var4 = 1.0F;
    	
    	NBTHelper.setBoolean(itemstack, "P", !NBTHelper.getBoolean(itemstack, "P"));
    	return itemstack;
    }
    
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
    	list.add(EnumChatFormatting.AQUA + "Annihilates All Mater");
    	if (itemStack.stackTagCompound != null) {
            Boolean code = NBTHelper.getBoolean(itemStack, "P");
            if(code){
            	list.add(EnumChatFormatting.GREEN + "Active: " + code);
            } else {
            	list.add(EnumChatFormatting.RED + "Active: " + code);
            }
    	}
    }
	
    public boolean onBlockDestroyed(ItemStack item, World world, Block theblock, int j, int k, int l, EntityLivingBase player)
    {
    	if(NBTHelper.getBoolean(item, "P")){
    		int var24 = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
    		//System.out.println(var24);
    		if(var24 == 0 || var24 == 2){
    			
    			world.getBlock(j, k + 1, l).dropBlockAsItem(world, j, k + 1, l, 1, 1);
    			world.setBlockToAir(j, k + 1, l);
    			world.getBlock(j, k - 1, l).dropBlockAsItem(world, j, k - 1, l, 1, 1);
    			world.setBlockToAir(j, k - 1, l);
    			world.getBlock(j + 1, k + 1, l).dropBlockAsItem(world, j + 1, k + 1, l, 1, 1);
    			world.setBlockToAir(j + 1, k + 1, l);
    			world.getBlock(j - 1, k + 1, l).dropBlockAsItem(world, j - 1, k + 1, l, 1, 1);
    			world.setBlockToAir(j - 1, k + 1, l);
    			world.getBlock(j + 1, k - 1, l).dropBlockAsItem(world, j + 1, k - 1, l, 1, 1);
    			world.setBlockToAir(j + 1, k - 1, l);
    			world.getBlock(j - 1, k - 1, l).dropBlockAsItem(world, j - 1, k - 1, l, 1, 1);
    			world.setBlockToAir(j - 1, k - 1, l);
    			world.getBlock(j + 1, k, l).dropBlockAsItem(world, j + 1, k, l, 1, 1);
    			world.setBlockToAir(j + 1, k, l);
    			world.getBlock(j - 1, k, l).dropBlockAsItem(world, j - 1, k, l, 1, 1);
    			world.setBlockToAir(j - 1, k, l);
    		}
    		if(var24 == 1 || var24 == 3){
    			
    			world.getBlock(j, k + 1, l).dropBlockAsItem(world, j, k + 1, l, 1, 1);
    			world.setBlockToAir(j, k + 1, l);
    			world.getBlock(j, k - 1, l).dropBlockAsItem(world, j, k - 1, l, 1, 1);
    			world.setBlockToAir(j, k - 1, l);
    			world.getBlock(j, k + 1, l + 1).dropBlockAsItem(world, j, k + 1, l + 1, 1, 1);
    			world.setBlockToAir(j, k + 1, l + 1);
    			world.getBlock(j, k + 1, l - 1).dropBlockAsItem(world, j, k + 1, l - 1, 1, 1);
    			world.setBlockToAir(j, k + 1, l - 1);
    			world.getBlock(j, k - 1, l + 1).dropBlockAsItem(world, j, k - 1, l + 1, 1, 1);
    			world.setBlockToAir(j, k - 1, l + 1);
    			world.getBlock(j, k - 1, l - 1).dropBlockAsItem(world, j, k - 1, l - 1, 1, 1);
    			world.setBlockToAir(j, k - 1, l - 1);
    			world.getBlock(j, k, l + 1).dropBlockAsItem(world, j, k, l + 1, 1, 1);
    			world.setBlockToAir(j, k, l + 1);
    			world.getBlock(j, k, l - 1).dropBlockAsItem(world, j, k, l - 1, 1, 1);
    			world.setBlockToAir(j, k, l - 1);
    			
    		}
    	}
        return true;
    }

}
