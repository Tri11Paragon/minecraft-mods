package com.brett.direop.magic;

import java.util.List;

import com.brett.direop.Mains;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.NetHandlerLoginServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class lifedagger extends Item {
	
	public lifedagger(){
		super();
		setCreativeTab(CreativeTabs.tabBlock);
		setDamage(new ItemStack(Mains.lifedagger, 1), 4);
		setUnlocalizedName("lifedagger");
		setTextureName(Mains.MODID + ":lifedagger");
	}
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entity, World world, int i, int j, int k, int l, float a, float b, float c){
		float var4 = 1.0F;
		
		if(true){
			entity.attackEntityFrom(DamageSource.magic, 2);
			Mains.LifePower += 50;
		}

		if(true){
		MinecraftServer.getServer().addChatMessage(new ChatComponentText("Life Power(Blood): " + Mains.LifePower));
		}
		return true;
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	{
	list.add("Life Power(Blood): " + Mains.LifePower);
	}
}
