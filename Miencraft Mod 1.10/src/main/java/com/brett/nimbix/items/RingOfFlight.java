package com.brett.nimbix.items;

import java.util.List;
import java.util.Set;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import cofh.api.energy.IEnergyContainerItem;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.helpers.NBTHelper;
import com.mojang.realmsclient.gui.ChatFormatting;

public class RingOfFlight extends Item implements IEnergyContainerItem {

	public RingOfFlight() {
		this.maxStackSize = 1;
		this.setMaxDamage(3284);
		setNoRepair();
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player,
			List<String> list, boolean b) {
		super.addInformation(stack, player, list, b);
		list.add(ChatFormatting.GREEN + "Energy: " + getEnergyStored(stack) + " / " + getMaxEnergyStored(stack));
	}

	protected boolean checkUsage(ItemStack stack, EntityPlayer player,
			float difficultyScale) {
		if (player.capabilities.isCreativeMode) {
			return true;
		}
		if (getEnergyStored(stack) < (int) (difficultyScale)) {
			error(player, "YOU NEED MORE POWER!!!!!");
			return false;
		}
		return true;
	}

	protected void registerUsage(ItemStack stack, EntityPlayer player,
			float difficultyScale) {
		if (player.capabilities.isCreativeMode) {
			return;
		}
		if (checkUsage(stack, player, difficultyScale)) {
			extractEnergy(stack, (int) (difficultyScale), false);
			updateBar(stack);
		}
	}

	public void updateBar(ItemStack stack) {
		float d = getEnergyStored(stack);
		float md = getMaxEnergyStored(stack);
		float per = d / md * 100;
		stack.setItemDamage(stack.getItemDamage() / (int) per);
		System.out.println("HP: " + stack.getItemDamage() / (int) per);
	}

	@Override
	public int extractEnergy(ItemStack container, int maxExtract,
			boolean simulate) {
		if (this.getMaxEnergyStored(container) <= 0) {
			return 0;
		}

		if (container.getTagCompound() == null
				|| !container.getTagCompound().hasKey("Energy")) {
			return 0;
		}
		int energy = container.getTagCompound().getInteger("Energy");
		int energyExtracted = Math.min(energy,
				Math.min(this.getMaxEnergyStored(container), maxExtract));

		if (!simulate) {
			energy -= energyExtracted;
			container.getTagCompound().setInteger("Energy", energy);
		}
		updateBar(container);
		return energyExtracted;
	}

	@Override
	public int receiveEnergy(ItemStack container, int maxReceive,
			boolean simulate) {
		if (this.getMaxEnergyStored(container) <= 0) {
			return 0;
		}

		if (container.getTagCompound() == null) {
			container.setTagCompound(new NBTTagCompound());
		}
		int energy = container.getTagCompound().getInteger("Energy");
		int energyReceived = Math.min(this.getMaxEnergyStored(container)
				- energy,
				Math.min(this.getMaxEnergyStored(container), maxReceive));

		if (!simulate) {
			energy += energyReceived;
			container.getTagCompound().setInteger("Energy", energy);
		}
		updateBar(container);
		return energyReceived;
	}

	public static void error(EntityPlayer player, String msg) {
		player.addChatComponentMessage(new TextComponentString(
				ChatFormatting.RED + msg));
	}
	@Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
		NBTHelper.setBoolean(stack, "isFlying", false);
		stack.setItemDamage(1);
    }
	@Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entity, int itemSlot, boolean isSelected)
    {
		EntityPlayer p =(EntityPlayer) entity;
		
    	if(NBTHelper.getBoolean(stack, "isFlying")){
    		p.capabilities.isFlying = true;
    	} else {
    		p.capabilities.isFlying = false;
    	}
    	if (p.capabilities.isFlying){
    		registerUsage(stack, p, 5);
    	}
    	
    }
	@Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
    	
		NBTHelper.setBoolean(stack, "isFlying", !NBTHelper.getBoolean(stack, "isFlying"));
    	
		MainClass.print("" + NBTHelper.getBoolean(stack, "isFlying"));
		
        return new ActionResult(EnumActionResult.PASS, stack);
    }

	@Override
	public int getEnergyStored(ItemStack container) {
		// TODO Auto-generated method stub
		if (container.getTagCompound() == null
				|| !container.getTagCompound().hasKey("Energy")) {
			return 0;
		}
		return container.getTagCompound().getInteger("Energy");
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {
		// TODO Auto-generated method stub
		return 1000000;
	}
	
}
