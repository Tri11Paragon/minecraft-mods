package com.brett.diremod.blocks;

import com.brett.diremod.MainClass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class nitrogencompressor extends Block {

	public nitrogencompressor(Material p_i45394_1_) {
		super(p_i45394_1_);
		setBlockTextureName(MainClass.MODID + ":NitrogenCompressor");
		setResistance(5.0F);
		setHardness(10.5F);
		setHarvestLevel("pickaxe", 3);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entity, int l, float m, float n, float o){

		if(entity.inventory.hasItem(new ItemStack(Items.glass_bottle).getItem())){
		if(entity instanceof EntityPlayer)((EntityPlayer)entity).inventory.addItemStackToInventory(new ItemStack(MainClass.nitrogen, 1));
		}

		if(true){
		if(entity instanceof EntityPlayer)((EntityPlayer)entity).inventory.consumeInventoryItem(Items.glass_bottle);
		}

		return true;}
}
