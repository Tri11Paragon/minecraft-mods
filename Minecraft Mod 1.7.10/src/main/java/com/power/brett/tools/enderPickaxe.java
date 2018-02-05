package com.power.brett.tools;

import com.power.brett.MainClass;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class enderPickaxe extends ItemPickaxe {

	public enderPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setTextureName(MainClass.MODID + ":enderPickaxe");
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("enderPickaxe");
	}
	
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase player)
    {	
    	if(world.getBlock(x, y, z) == Blocks.diamond_ore){
    		world.getPlayerEntityByName("MAD_COW4321");
    		
    	}
    	return true;
    }
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	world.setBlock(x, y, z, Blocks.torch);
        return false;
    }

}
