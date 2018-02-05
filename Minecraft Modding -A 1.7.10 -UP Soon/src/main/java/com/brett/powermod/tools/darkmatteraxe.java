package com.brett.powermod.tools;

import java.util.List;

import com.brett.powermod.MainClass;
import com.brett.powermod.helpers.NBTHelper;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class darkmatteraxe extends ItemAxe {

	public darkmatteraxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setTextureName(MainClass.MODID + ":darkaxe");
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
	    itemStack.stackTagCompound = new NBTTagCompound();
	    itemStack.stackTagCompound.setInteger("code", (int)(Math.random()*Integer.MAX_VALUE));
	    itemStack.stackTagCompound.setBoolean("E", false);
	}
	
    /*public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	//System.out.println(NBTHelper.getBoolean(p_77648_1_, "P"));
    	NBTHelper.setBoolean(p_77648_1_, "E", !NBTHelper.getBoolean(p_77648_1_, "E"));
    	
        return false;
    }*/
    
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
    	float var4 = 1.0F;
    	
    	NBTHelper.setBoolean(itemstack, "E", !NBTHelper.getBoolean(itemstack, "E"));
    	return itemstack;
    }
	
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
    	if (itemStack.stackTagCompound != null) {
            Boolean code = NBTHelper.getBoolean(itemStack, "E");
            if(code){
            	list.add(EnumChatFormatting.GREEN + "Active: " + code);
            } else {
            	list.add(EnumChatFormatting.RED + "Active: " + code);
            }
    	}
    }
	
	public boolean onBlockDestroyed(ItemStack item, World world, Block theblock, int j, int k, int l, EntityLivingBase player)
    {
    	if(NBTHelper.getBoolean(item, "E") && theblock == Blocks.log || theblock == Blocks.log2){
    		int var24 = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
    		//System.out.println(var24);
    		for (int i = 0; i < 8; i++) {
        		if(world.getBlock(j, k + i, l) == Blocks.log || world.getBlock(j, k + i, l) == Blocks.log2){
        			world.getBlock(j, k + i, l).dropBlockAsItem(world, j, k + i, l, world.getBlockMetadata(j, k + i, l), 1);
        			world.setBlockToAir(j, k + i, l);
        		}
        		if(world.getBlock(j, k - 1, l) == Blocks.log || world.getBlock(j, k - 1, l) == Blocks.log2){
        			world.getBlock(j, k - 1, l).dropBlockAsItem(world, j, k - 1, l, world.getBlockMetadata(j, k - 1, l), 1);
        			world.setBlockToAir(j, k - 1, l);
        		}
			}
    	}
        return true;
    }

}
