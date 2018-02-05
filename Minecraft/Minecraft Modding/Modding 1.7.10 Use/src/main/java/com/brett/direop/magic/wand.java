package com.brett.direop.magic;

import java.util.List;

import com.brett.direop.Mains;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class wand extends Item {
	
	public wand(){
		super();
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("wand");
		setTextureName(Mains.MODID + ":wand");
		setContainerItem(this);
	}
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
	    return 1.0F;
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Life Power(Blood): " + Mains.LifePower);
	}
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entity, World world, int i, int j, int k, int l, float a, float b, float c){
		float var4 = 1.0F;

		if(world.getBlock(i, j, k) == Blocks.cobblestone){
				world.setBlock(i, j, k, Blocks.stone);
				if(Mains.LifePower > 99){
					Mains.LifePower = Mains.LifePower -50;
					} else {
						world.setBlock(i, j, k, Blocks.cobblestone);
					}
			}
		if(world.getBlock(i, j, k) == Blocks.sand){
			world.setBlock(i, j, k, Blocks.glass);
			if(Mains.LifePower > 99){
				Mains.LifePower = Mains.LifePower -50;
				} else {
					world.setBlock(i, j, k, Blocks.sand);
				}
		}
		if(world.getBlock(i, j, k) == Blocks.clay){
			world.setBlock(i, j, k, Blocks.hardened_clay);
			if(Mains.LifePower > 99){
				Mains.LifePower = Mains.LifePower -50;
				} else {
					world.setBlock(i, j, k, Blocks.clay);
				}
		}
		if(world.getBlock(i, j, k) == Blocks.iron_block){
			if(Mains.LifePower > 99){
				Mains.LifePower = Mains.LifePower -50;
				world.setBlock(i, j, k, Mains.magic);
				} else {
					world.setBlock(i, j, k, Blocks.iron_block);
				}
		}
		return true;
	}
}
