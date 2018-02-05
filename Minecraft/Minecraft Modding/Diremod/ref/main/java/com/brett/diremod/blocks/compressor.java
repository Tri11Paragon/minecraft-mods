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

public class compressor extends Block {

	public compressor(Material p_i45394_1_) {
		super(p_i45394_1_);
		setBlockTextureName(MainClass.MODID + ":compressor");
		setResistance(5.0F);
		setHardness(10.5F);
		setHarvestLevel("pickaxe", 3);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entity, int l, float m, float n, float o){

		if(entity.inventory.hasItem(new ItemStack(Items.iron_ingot).getItem())){
		if(entity instanceof EntityPlayer)((EntityPlayer)entity).inventory.addItemStackToInventory(new ItemStack(MainClass.ironplate, 1));
		}

		if(true){
		if(entity instanceof EntityPlayer)((EntityPlayer)entity).inventory.consumeInventoryItem(Items.iron_ingot);
		}

		return true;}
}
