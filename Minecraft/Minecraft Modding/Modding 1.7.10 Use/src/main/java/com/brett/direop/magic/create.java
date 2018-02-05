package com.brett.direop.magic;

import java.util.List;

import com.brett.direop.Mains;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class create extends Item {
	
	public create(){
		super();
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("create");
		setTextureName(Mains.MODID + ":create");
		setContainerItem(this);
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Life Power(Blood): " + Mains.LifePower);
	}
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
		float var4 = 1.0F;
		int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
		int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
		int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

		if(true){
			if(world.getBlock(i, j, k) == Blocks.air){
				if(Mains.LifePower >= 50){
					world.setBlock(i, j, k, Blocks.stone);
					Mains.LifePower = Mains.LifePower -50;
					}
			}
		}

		return itemstack;
		}
}
