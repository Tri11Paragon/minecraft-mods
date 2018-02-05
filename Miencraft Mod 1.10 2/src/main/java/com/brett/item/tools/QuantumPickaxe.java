package com.brett.item.tools;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class QuantumPickaxe extends ItemPickaxe {

	protected QuantumPickaxe(ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
	}
	
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if ((double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(1, entityLiving);
        }

        return true;
    }
    
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{
		list.add(ChatFormatting.DARK_GREEN + "It takes damage and has no special abilities.");
	}
    
}
