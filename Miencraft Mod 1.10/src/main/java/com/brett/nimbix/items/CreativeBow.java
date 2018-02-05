package com.brett.nimbix.items;


import java.util.List;

import javax.annotation.Nullable;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayer.EnumChatVisibility;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class CreativeBow extends Item implements cofh.api.energy.IEnergyContainerItem {
	
	 public CreativeBow() {
	        this.maxStackSize = 1;
	        this.setMaxDamage(3284);
            setNoRepair();
	        this.setCreativeTab(CreativeTabs.COMBAT);
	    }
	    /**
	     * Gets the velocity of the arrow entity from the bow's charge
	     */
	    public static float getArrowVelocity(int charge)
	    {
	        float f = (float)charge / 20.0F;
	        f = (f * f + f * 2.0F) / 3.0F;

	        if (f > 1.0F)
	        {
	            f = 1.0F;
	        }

	        return f;
	    }
	    @Override
	    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean b) {
	        super.addInformation(stack, player, list, b);
	        list.add(ChatFormatting.GREEN+"Energy: " + getEnergyStored(stack) + " / " + getMaxEnergyStored(stack));
	    }
	    
	    protected boolean checkUsage(ItemStack stack, EntityPlayer player, float difficultyScale) {
	        if (player.capabilities.isCreativeMode) {
	            return true;
	        }
	        if (getEnergyStored(stack) < (int)(difficultyScale)) {
	        	error(player, "YOU NEED MORE POWER!!!!!");
	            return false;
	        }
	        return true;
	    }
	    protected void registerUsage(ItemStack stack, EntityPlayer player, float difficultyScale) {
	        if (player.capabilities.isCreativeMode) {
	            return;
	        }
	        if (checkUsage(stack, player, difficultyScale)){
	        	extractEnergy(stack, (int) (difficultyScale), false);
	        	updateBar(stack);
	        }
	    }
	    
	    public void updateBar(ItemStack stack){
	    	float d = getEnergyStored(stack);
	    	float md = getMaxEnergyStored(stack);
	    	float per = d / md * 100;
	    	stack.setItemDamage((int) per);
	    	System.out.println("HP: " + per);
	    }
	    
	    @Override
	    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
	        if (this.getMaxEnergyStored(container) <= 0) {
	            return 0;
	        }

	        if (container.getTagCompound() == null || !container.getTagCompound().hasKey("Energy")) {
	            return 0;
	        }
	        int energy = container.getTagCompound().getInteger("Energy");
	        int energyExtracted = Math.min(energy, Math.min(this.getMaxEnergyStored(container), maxExtract));

	        if (!simulate) {
	            energy -= energyExtracted;
	            container.getTagCompound().setInteger("Energy", energy);
	        }
	        updateBar(container);
	        return energyExtracted;
	    }

	    @Override
	    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
	        if (this.getMaxEnergyStored(container) <= 0) {
	            return 0;
	        }

	        if (container.getTagCompound() == null) {
	            container.setTagCompound(new NBTTagCompound());
	        }
	        int energy = container.getTagCompound().getInteger("Energy");
	        int energyReceived = Math.min(this.getMaxEnergyStored(container) - energy, Math.min(this.getMaxEnergyStored(container), maxReceive));

	        if (!simulate) {
	            energy += energyReceived;
	            container.getTagCompound().setInteger("Energy", energy);
	        }
	        updateBar(container);
	        return energyReceived;
	    }

	    
	    public static void error(EntityPlayer player, String msg) {
	    	 player.addChatComponentMessage(new TextComponentString(ChatFormatting.RED + msg));
	    }

	    /**
	     * How long it takes to use or consume an item
	     */

	    /**
	     * returns the action that specifies what animation to play when the items is being used
	     */
	    public EnumAction getItemUseAction(ItemStack stack)
	    {
	        return null;
	    }
	    
	    public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World worldIn, EntityPlayer entityplayer, EnumHand hand)
	    {
	    	float f = getArrowVelocity(500);
            if (!worldIn.isRemote && checkUsage(itemstack, entityplayer, 200))
            {
                ItemArrowE itemarrow = (ItemArrowE)((ItemArrowE)(itemstack.getItem() instanceof ItemArrowE ? itemstack.getItem() : OtherItems.ItemArrowE));
                EntityArrowE EntityArrowE = itemarrow.createArrow(worldIn, itemstack, entityplayer);
                EntityArrowE.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 4.5F, 1.0F);
                
            	//ItemArrowE itemarrow = (ItemArrowE)((ItemArrowE)(itemstack.getItem() instanceof ItemArrowE ? itemstack.getItem() : Items.ARROW));
                //EntityArrowE entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);
                //entityarrow.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 1.0F);
                
                EntityArrowE.setDamage(2);
                
                EntityArrowE.setIsCritical(false);

                int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, itemstack);

                if (j > 0)
                {
                    EntityArrowE.setDamage(EntityArrowE.getDamage() + (double)j * 0.5D + 0.5D);
                }

                int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, itemstack);

                if (k > 0)
                {
                    EntityArrowE.setKnockbackStrength(k);
                }

                if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, itemstack) > 0)
                {
                    EntityArrowE.setFire(100);
                }
                registerUsage(itemstack, entityplayer, 200);
                updateBar(itemstack);

                if (true)
                {
                    EntityArrowE.pickupStatus = EntityArrowE.pickupStatus.CREATIVE_ONLY;
                }

                worldIn.spawnEntityInWorld(EntityArrowE);
            }

            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

	        return new ActionResult(EnumActionResult.PASS, itemstack);
	    }

	    /**
	     * Return the enchantability factor of the item, most of the time is based on material.
	     */
	    public int getItemEnchantability()
	    {
	        return 1;
	    }
		@Override
		public int getEnergyStored(ItemStack container) {
			// TODO Auto-generated method stub
	        if (container.getTagCompound() == null || !container.getTagCompound().hasKey("Energy")) {
	            return 0;
	        }
			return container.getTagCompound().getInteger("Energy");
		}
		@Override
		public int getMaxEnergyStored(ItemStack container) {
			// TODO Auto-generated method stub
			return 100000;
		}
	
}
