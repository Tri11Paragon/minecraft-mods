package com.brett.powermod.tools;

import java.util.List;

import com.brett.powermod.MainClass;
import com.brett.powermod.helpers.NBTHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class antimattersword extends ItemSword {

	public antimattersword(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		setTextureName(MainClass.MODID + ":antisword");
		setCreativeTab(CreativeTabs.tabBlock);
	}
    
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entity, World world, int i, int j, int k, int l, float a, float b, float c){
    	float var4 = 1.0F;

    	world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
    	
    	return true;
    	}
    
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
    	//System.out.println("HELLO?");
    	int j = 5;
       
        //if (p_77615_3_.inventory.hasItem(Items.arrow)){

            EntityArrow entityarrow = new EntityArrow(world, player, j * 2.0F);

              //entityarrow.setIsCritical(true);
            entityarrow.canBePickedUp = 2;
            entityarrow.setDamage(2.0);
            

            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + j * 0.5F);

            if (!world.isRemote)
            {
                world.spawnEntityInWorld(entityarrow);
            }
        //}
    	
        return item;
    }
	
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.GREEN + "Annihilates All Mater");
    }

}