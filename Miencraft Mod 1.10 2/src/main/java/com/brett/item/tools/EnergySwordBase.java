package com.brett.item.tools;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.helpers.NBTHelper;
import com.mojang.realmsclient.gui.ChatFormatting;

import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EnergySwordBase extends ItemSword implements IEnergyContainerItem {
	
protected Set<Object> effectiveBlocks = new HashSet<Object>();
	
	private int usage;
	private int maxStorage;
	
	private static int currentSizeOfAOE = 0;
	private static int[] allowedInts;
	
    protected final Item.ToolMaterial material;
    
    public ItemStack stack;
	
    protected EnergySwordBase(Item.ToolMaterial material, int usage, int maxStorage, int[] allowedInts, Set effectiveBlocks)
    {
        super(material);
        this.usage=usage;
        this.material=material;
        this.maxStorage=maxStorage;
        this.allowedInts=allowedInts;
        this.effectiveBlocks.addAll(effectiveBlocks);
    }
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
	    itemStack.setTagCompound(new NBTTagCompound());
	    itemStack.getTagCompound().setInteger("code", (int)(Math.random()*Integer.MAX_VALUE));
	}
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	{	
		list.add(ChatFormatting.DARK_GREEN + "Just your normal super sword");
    	if (itemstack.getTagCompound() != null) {
            int code = NBTHelper.getInteger(itemstack, "AOE");
            int c = 1;
            if (code == 0){c = 1;}if (code == 1){c = 3;}if (code == 2){c = 5;}if (code == 3){c = 7;}if (code == 4){c = 9;}if (code == 5){c = 11;}if (code == 6){c = 13;}
            list.add(ChatFormatting.GOLD + "Energy: " + MainClass.foramteNumber(getEnergyStored(itemstack) + "") + " / " + MainClass.foramteNumber(getMaxEnergyStored(itemstack) + ""));
    	} 
	}
	
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        extractEnergy(stack, usage, false);
        return true;
    }

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
		//updateBar(container);
		return energyExtracted;
	}
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
		//updateBar(container);
		return energyReceived;
	}
	public int getEnergyStored(ItemStack container) {
		// TODO Auto-generated method stub
		if (container.getTagCompound() == null
				|| !container.getTagCompound().hasKey("Energy")) {
			return 0;
		}
		return container.getTagCompound().getInteger("Energy");
	}
	public int getMaxEnergyStored(ItemStack container) {
		// TODO Auto-generated method stub
		return maxStorage;
	}
	
}
