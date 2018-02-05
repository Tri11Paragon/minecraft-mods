package com.power.brett.blocks;

import com.power.brett.MainClass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EnderOre extends Block {

	public EnderOre(Material p_i45394_1_) {
		super(p_i45394_1_);
		setHardness(25.0f);
		setResistance(500.0f);
		setBlockName("EnderOre");
		setCreativeTab(CreativeTabs.tabBlock);
		setLightLevel(1.0f);
		setBlockTextureName(MainClass.MODID + ":EnderOre");
	}
	public void onBlockAdded(World world, int i, int j, int k){
		EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
		if(entity!=null&&world!=null){
		int le = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		world.setBlockMetadataWithNotify(i, j, k, le, 2);
		}

		world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));

		}

}
