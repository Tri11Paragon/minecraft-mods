package com.brett.powermod.armor;

import com.brett.powermod.MainClass;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class enderarmor extends ItemArmor {

	public enderarmor(ArmorMaterial material, int id, int placement) {
		super(material, id, placement);
		setCreativeTab(CreativeTabs.tabBlock);
		if (placement == 0) {
			this.setTextureName(MainClass.MODID + ":enderhead"); // helmet
		}
		else if (placement == 1) {
			this.setTextureName(MainClass.MODID + ":enderbody"); // chestpalte
		}
		else if (placement == 2) {
			this.setTextureName(MainClass.MODID + ":enderleggins"); // leggings
		}
		else if (placement == 3) {
			this.setTextureName(MainClass.MODID + ":enderboots"); // boots
		}
	}
	
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == MainClass.enderhelmet || stack.getItem() == MainClass.enderchestplate || stack.getItem() == MainClass.enderboots) {
			return MainClass.MODID + ":textures/models/armor/DarkArmor_V1.png";
		}
		if (stack.getItem() == MainClass.enderleggings) {
			return MainClass.MODID + ":textures/models/armor/DarkArmor_V1.png";
		} else {
			return null;
		}
		
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemstack){
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) {
			ItemStack helmet = player.getCurrentArmor(3);
			ItemStack chestplate = player.getCurrentArmor(2);
			ItemStack leggings = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			
			
			if (helmet.getItem() == MainClass.enderhelmet && chestplate.getItem() == MainClass.enderchestplate && leggings.getItem() == MainClass.enderleggings && boots.getItem() == MainClass.enderboots){
				//player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 300, 2));
				//player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 300, 2));
				//player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 300, 2));
				/*if(player.isUsingItem()){
					if (player.capabilities.isCreativeMode)
			        {
			            return;
			        }
			        else
			        {
			            --itemstack.stackSize;
			            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			            if (!world.isRemote)
			            {
			                world.spawnEntityInWorld(new EntityEnderPearl(world, player));
			                return;
			            }

			            return;
			        }
				}*/
			}
		}
	}
	/*@Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
		System.out.println("Hello?");
		
		if (p_77659_3_.capabilities.isCreativeMode)
        {
            return p_77659_1_;
        }
        else
        {
            --p_77659_1_.stackSize;
            p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!p_77659_2_.isRemote)
            {
                p_77659_2_.spawnEntityInWorld(new EntityEnderPearl(p_77659_2_, p_77659_3_));
            }

            return p_77659_1_;
        }
    }*/
	

}