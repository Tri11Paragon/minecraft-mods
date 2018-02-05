package com.brett.direop.tools;

import com.brett.diremod.MainClass;
import com.brett.direop.Mains;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class drill extends ItemPickaxe {

	public drill(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setUnlocalizedName("drill");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(Mains.MODID + ":drill");
	}
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entity, World world, int i, int j, int k, int l, float a, float b, float c){
		float var4 = 1.0F;

		if(world.getBlock(i, j, k) == Blocks.stone){
			world.setBlockToAir(i,j,k);
			world.setBlockToAir(i,j + 1,k);
			world.setBlockToAir(i,j - 1,k);
			world.setBlockToAir(i,j - 1,k - 1);
			world.setBlockToAir(i,j + 1,k + 1);
			world.setBlockToAir(i,j - 1,k + 1);
			world.setBlockToAir(i,j + 1,k - 1);
			world.setBlockToAir(i,j,k + 1);
			world.setBlockToAir(i,j,k - 1);
			EntityItem var14 = new EntityItem(world,(double)(i),(double)(j),(double)(k),new ItemStack(Blocks.stone, 1, 0));
			world.spawnEntityInWorld(var14);
		}
		if(world.getBlock(i, j, k) == MainClass.limestone){
			world.setBlockToAir(i,j,k);
			world.setBlockToAir(i,j + 1,k);
			world.setBlockToAir(i,j - 1,k);
			world.setBlockToAir(i,j - 1,k - 1);
			world.setBlockToAir(i,j + 1,k + 1);
			world.setBlockToAir(i,j - 1,k + 1);
			world.setBlockToAir(i,j + 1,k - 1);
			world.setBlockToAir(i,j,k + 1);
			world.setBlockToAir(i,j,k - 1);
			EntityItem var14 = new EntityItem(world,(double)(i),(double)(j),(double)(k),new ItemStack(MainClass.limestone, 1, 0));
			world.spawnEntityInWorld(var14);
		}
		if(world.getBlock(i, j, k) == MainClass.granite){
			world.setBlockToAir(i,j,k);
			world.setBlockToAir(i,j + 1,k);
			world.setBlockToAir(i,j - 1,k);
			world.setBlockToAir(i,j - 1,k - 1);
			world.setBlockToAir(i,j + 1,k + 1);
			world.setBlockToAir(i,j - 1,k + 1);
			world.setBlockToAir(i,j + 1,k - 1);
			world.setBlockToAir(i,j,k + 1);
			world.setBlockToAir(i,j,k - 1);
			EntityItem var14 = new EntityItem(world,(double)(i),(double)(j),(double)(k),new ItemStack(MainClass.granite, 1, 0));
			world.spawnEntityInWorld(var14);
		}
		if(world.getBlock(i, j, k) == MainClass.quartz){
			world.setBlockToAir(i,j,k);
			world.setBlockToAir(i,j + 1,k);
			world.setBlockToAir(i,j - 1,k);
			world.setBlockToAir(i,j - 1,k - 1);
			world.setBlockToAir(i,j + 1,k + 1);
			world.setBlockToAir(i,j - 1,k + 1);
			world.setBlockToAir(i,j + 1,k - 1);
			world.setBlockToAir(i,j,k + 1);
			world.setBlockToAir(i,j,k - 1);
			EntityItem var14 = new EntityItem(world,(double)(i),(double)(j),(double)(k),new ItemStack(MainClass.quartz, 1, 0));
			world.spawnEntityInWorld(var14);
		}
		if(world.getBlock(i, j, k) == MainClass.marble){
			world.setBlockToAir(i,j,k);
			world.setBlockToAir(i,j + 1,k);
			world.setBlockToAir(i,j - 1,k);
			world.setBlockToAir(i,j - 1,k - 1);
			world.setBlockToAir(i,j + 1,k + 1);
			world.setBlockToAir(i,j - 1,k + 1);
			world.setBlockToAir(i,j + 1,k - 1);
			world.setBlockToAir(i,j,k + 1);
			world.setBlockToAir(i,j,k - 1);
			EntityItem var14 = new EntityItem(world,(double)(i),(double)(j),(double)(k),new ItemStack(MainClass.marble, 1, 0));
			world.spawnEntityInWorld(var14);
		}
		if(world.getBlock(i, j, k) == Blocks.quartz_block){
			world.setBlockToAir(i,j,k);
			world.setBlockToAir(i,j + 1,k);
			world.setBlockToAir(i,j - 1,k);
			world.setBlockToAir(i,j - 1,k - 1);
			world.setBlockToAir(i,j + 1,k + 1);
			world.setBlockToAir(i,j - 1,k + 1);
			world.setBlockToAir(i,j + 1,k - 1);
			world.setBlockToAir(i,j,k + 1);
			world.setBlockToAir(i,j,k - 1);
			EntityItem var14 = new EntityItem(world,(double)(i),(double)(j),(double)(k),new ItemStack(Blocks.quartz_block, 1, 0));
			world.spawnEntityInWorld(var14);
		}
		if(world.getBlock(i, j, k) == Blocks.redstone_ore){
			world.setBlockToAir(i,j,k);
			world.setBlockToAir(i,j + 1,k);
			world.setBlockToAir(i,j - 1,k);
			world.setBlockToAir(i,j - 1,k - 1);
			world.setBlockToAir(i,j + 1,k + 1);
			world.setBlockToAir(i,j - 1,k + 1);
			world.setBlockToAir(i,j + 1,k - 1);
			world.setBlockToAir(i,j,k + 1);
			world.setBlockToAir(i,j,k - 1);
			EntityItem var14 = new EntityItem(world,(double)(i),(double)(j),(double)(k),new ItemStack(Blocks.redstone_ore, 1, 0));
			world.spawnEntityInWorld(var14);
		}
		if(world.getBlock(i, j, k) == Blocks.diamond_ore){
			world.setBlockToAir(i,j,k);
			world.setBlockToAir(i,j + 1,k);
			world.setBlockToAir(i,j - 1,k);
			world.setBlockToAir(i,j - 1,k - 1);
			world.setBlockToAir(i,j + 1,k + 1);
			world.setBlockToAir(i,j - 1,k + 1);
			world.setBlockToAir(i,j + 1,k - 1);
			world.setBlockToAir(i,j,k + 1);
			world.setBlockToAir(i,j,k - 1);
			EntityItem var14 = new EntityItem(world,(double)(i),(double)(j),(double)(k),new ItemStack(Blocks.diamond_ore, 1, 0));
			world.spawnEntityInWorld(var14);
		}
		if(world.getBlock(i, j, k) == Blocks.gold_ore){
			world.setBlockToAir(i,j,k);
			world.setBlockToAir(i,j + 1,k);
			world.setBlockToAir(i,j - 1,k);
			world.setBlockToAir(i,j - 1,k - 1);
			world.setBlockToAir(i,j + 1,k + 1);
			world.setBlockToAir(i,j - 1,k + 1);
			world.setBlockToAir(i,j + 1,k - 1);
			world.setBlockToAir(i,j,k + 1);
			world.setBlockToAir(i,j,k - 1);
			EntityItem var14 = new EntityItem(world,(double)(i),(double)(j),(double)(k),new ItemStack(Blocks.gold_ore, 1, 0));
			world.spawnEntityInWorld(var14);
		}
		if(world.getBlock(i, j, k) == Blocks.iron_ore){
			world.setBlockToAir(i,j,k);
			world.setBlockToAir(i,j + 1,k);
			world.setBlockToAir(i,j - 1,k);
			world.setBlockToAir(i,j - 1,k - 1);
			world.setBlockToAir(i,j + 1,k + 1);
			world.setBlockToAir(i,j - 1,k + 1);
			world.setBlockToAir(i,j + 1,k - 1);
			world.setBlockToAir(i,j,k + 1);
			world.setBlockToAir(i,j,k - 1);
			EntityItem var14 = new EntityItem(world,(double)(i),(double)(j),(double)(k),new ItemStack(Blocks.iron_ore, 1, 0));
			world.spawnEntityInWorld(var14);
		}

		return true;
		}

}
