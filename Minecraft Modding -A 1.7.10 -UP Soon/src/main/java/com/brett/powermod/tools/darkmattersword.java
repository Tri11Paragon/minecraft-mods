package com.brett.powermod.tools;

import java.util.List;

import com.brett.powermod.MainClass;
import com.brett.powermod.helpers.NBTHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class darkmattersword extends ItemSword {

	public darkmattersword(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setTextureName(MainClass.MODID + ":darksword");
		setCreativeTab(CreativeTabs.tabBlock);
	}
    
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entity, World world, int i, int j, int k, int l, float a, float b, float c){
    	float var4 = 1.0F;

    	world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
    	
    	return true;
    	}
	
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.GREEN + "Im a tool-tip");
    }

}