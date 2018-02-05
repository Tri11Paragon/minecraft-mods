package com.power.brett.items;

import java.util.List;

import com.power.brett.EntityDEgg;
import com.power.brett.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DragonHeart extends Item {
	
	public DragonHeart(){
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureName(MainClass.MODID + ":DragonHeart");
		setUnlocalizedName("DragonHeart");
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Your playing with fire");
	}
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        if (!p_77659_3_.capabilities.isCreativeMode)
        {
            --p_77659_1_.stackSize;
        }

        p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!p_77659_2_.isRemote)
        {
            p_77659_2_.spawnEntityInWorld(new EntityDEgg(p_77659_2_, p_77659_3_));
        }

        return p_77659_1_;
    }
	
}
