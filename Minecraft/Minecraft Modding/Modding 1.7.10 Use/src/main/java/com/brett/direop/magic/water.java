package com.brett.direop.magic;

import java.util.List;

import com.brett.direop.Mains;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class water extends Item {
	
	public water(){
		super();
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("water");
		setTextureName(Mains.MODID + ":water");
		setContainerItem(this);
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Life Power(Blood): " + Mains.LifePower);
	}
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entity, World world, int i, int j, int k, int l, float a, float b, float c){
		float var4 = 1.0F;

		if(!(world.getBlock(i, j, k) == Blocks.air)){
				if(Mains.LifePower >= 250){
					world.setBlock(i, j, k, Blocks.water);
					Mains.LifePower = Mains.LifePower -250;
					}
			}
		return true;
	}
}
