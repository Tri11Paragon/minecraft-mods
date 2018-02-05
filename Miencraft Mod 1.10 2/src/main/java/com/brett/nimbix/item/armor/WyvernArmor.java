package com.brett.nimbix.item.armor;

import java.util.ArrayList;
import java.util.List;

import com.brett.nimbix.helpers.NBTHelper;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by brandon3055 on 6/06/2016.
 */
public class WyvernArmor extends ItemArmor implements IUpgradableItem, ICustomArmor {

    private static ArmorMaterial wyvernMaterial = EnumHelper.addArmorMaterial("wyvernArmor", "draconicevolution:wyvern_armor", -1, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);

    protected float baseProtectionPoints;
    protected float baseRecovery;

    public WyvernArmor(int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(wyvernMaterial, renderIndexIn, equipmentSlotIn);
        this.setMaxDamage(-1);
        this.baseProtectionPoints = 256F;
        this.baseRecovery = 2F;
    }

    public WyvernArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setMaxDamage(-1);
        this.baseProtectionPoints = 256F;
        this.baseRecovery = 2F;
    }

    //region Armor Logic

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        subItems.add(new ItemStack(itemIn));
        ItemStack stack = new ItemStack(itemIn);
        modifyEnergy(stack, getCapacity(stack));
        subItems.add(stack);
    }

    protected float getProtectionShare() {
        switch (armorType) {
            case HEAD:
                return 0.15F;
            case CHEST:
                return 0.40F;
            case LEGS:
                return 0.30F;
            case FEET:
                return 0.15F;
        }
        return 0;
    }

    @Override
    public int getMaxUpgradeLevel(ItemStack stack, String upgrade) {
        return 2;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        InfoHelper.addEnergyInfo(stack, tooltip);
    }

    //endregion

    //region Render

    @Override
    public boolean hasEffect(ItemStack stack) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public ModelBiped model;

    @SideOnly(Side.CLIENT)
    @Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        return super.getArmorModel(entityLiving, itemStack, armorSlot, _default);

        /*if (model == null) {
            if (armorType == EntityEquipmentSlot.HEAD) model = new ModelWyvernArmor(0.5F, true, false, false, false);
            else if (armorType == EntityEquipmentSlot.CHEST) model = new ModelWyvernArmor(1.5F, false, true, false, false);
            else if (armorType == EntityEquipmentSlot.LEGS) model = new ModelWyvernArmor(1.5F, false, false, true, false);
            else model = new ModelWyvernArmor(1F, false, false, false, true);
            this.model.bipedHead.showModel = (armorType == EntityEquipmentSlot.HEAD);
            this.model.bipedHeadwear.showModel = (armorType == EntityEquipmentSlot.HEAD);
            this.model.bipedBody.showModel = ((armorType == EntityEquipmentSlot.CHEST) || (armorType == EntityEquipmentSlot.LEGS));
            this.model.bipedLeftArm.showModel = (armorType == EntityEquipmentSlot.CHEST);
            this.model.bipedRightArm.showModel = (armorType == EntityEquipmentSlot.CHEST);
            this.model.bipedLeftLeg.showModel = (armorType == EntityEquipmentSlot.LEGS || armorType == EntityEquipmentSlot.FEET);
            this.model.bipedRightLeg.showModel = (armorType == EntityEquipmentSlot.LEGS || armorType == EntityEquipmentSlot.FEET);
        }


        if (entityLiving == null) {
            return model;
        }

        this.model.isSneak = entityLiving.isSneaking();
        this.model.isRiding = entityLiving.isRiding();
        this.model.isChild = entityLiving.isChild();
   //     this.model.aimedBow = false;
   //     this.model.heldItemRight = (entityLiving.getHeldItem() != null ? 1 : 0);

//                 this.model.bipedHead.showModel = (armorType == EntityEquipmentSlot.HEAD);
        this.model.bipedHeadwear.showModel = (armorType == EntityEquipmentSlot.HEAD);
        this.model.bipedBody.showModel = ((armorType == EntityEquipmentSlot.CHEST) || (armorType == EntityEquipmentSlot.LEGS));
        this.model.bipedLeftArm.showModel = (armorType == EntityEquipmentSlot.CHEST);
        this.model.bipedRightArm.showModel = (armorType == EntityEquipmentSlot.CHEST);
        this.model.bipedLeftLeg.showModel = (armorType == EntityEquipmentSlot.LEGS || armorType == EntityEquipmentSlot.FEET);
        this.model.bipedRightLeg.showModel = (armorType == EntityEquipmentSlot.LEGS || armorType == EntityEquipmentSlot.FEET);


        return model; */
    }

    //endregion

    //region ICustomArmor

    @Override
    public float getSpeedModifier(ItemStack stack, EntityPlayer player) {
        float modifier = 120 / 100F;

        return modifier;
    }

    @Override
    public float getJumpModifier(ItemStack stack, EntityPlayer player) {
        float modifier = 120 / 100F;

        return modifier;
    }

    @Override
    public boolean hasHillStep(ItemStack stack, EntityPlayer player) {
        return false;
    }

    @Override
    public float getFireResistance(ItemStack stack) {
        switch (armorType) {
            case HEAD:
                return 0.15F;
            case CHEST:
                return 0.40F;
            case LEGS:
                return 0.30F;
            case FEET:
                return 0.15F;
        }
        return 0;
    }

    @Override
    public boolean[] hasFlight(ItemStack stack) {
        return new boolean[]{false, false, false};
    }

    @Override
    public float getFlightSpeedModifier(ItemStack stack, EntityPlayer player) {
        return 0;
    }

    @Override
    public float getFlightVModifier(ItemStack stack, EntityPlayer player) {
        return 0;
    }

    @Override
    public int getEnergyPerProtectionPoint() {
        return 1000;
    }

    //endregion

    //region Energy

    protected int getCapacity(ItemStack stack) {
        int level = 5000000;
        
        return level;
        
    }

    protected int getMaxReceive(ItemStack stack){
        return 512000;
    }

    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        int energy = NBTHelper.getInteger(container, "Energy");
        int energyReceived = Math.min(getCapacity(container) - energy, Math.min(getMaxReceive(container), maxReceive));

        if (!simulate) {
            energy += energyReceived;
            NBTHelper.setInteger(container, "Energy", energy);
        }

        return energyReceived;
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored(ItemStack container) {
        return NBTHelper.getInteger(container, "Energy");
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return getCapacity(container);
    }

    @Override
    public void modifyEnergy(ItemStack container, int modify) {
        int energy = NBTHelper.getInteger(container, "Energy");
        energy += modify;

        if (energy > getCapacity(container)) {
            energy = getCapacity(container);
        }
        else if (energy < 0) {
            energy = 0;
        }

        NBTHelper.setInteger(container, "Energy", energy);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return !(getEnergyStored(stack) == getMaxEnergyStored(stack));
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return 1D - ((double)getEnergyStored(stack) / (double)getMaxEnergyStored(stack));
    }

    //endregion

    /*@Override
    public float getNewFOV(EntityPlayer player, ItemStack stack, float currentFOV, float originalFOV, EntityEquipmentSlot slot) {
        if (slot == EntityEquipmentSlot.LEGS) {
            float speedModifier = getSpeedModifier(stack, player);
            float newFov = currentFOV - ((speedModifier / 2F) * 1F);
            newFov += speedModifier * 0.02F;

            if (newFov < 1F && player.getActivePotionEffect(MobEffects.SLOWNESS) == null) {
                newFov = 1F;
            }
            return newFov;
        }

        return currentFOV;
    }*/

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

	@Override
	public float getProtectionPoints(ItemStack stack) {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public float getRecoveryRate(ItemStack stack) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public List<String> getValidUpgrades(ItemStack stack) {
		// TODO Auto-generated method stub
		return null;
	}

    /*@Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        return new EntityPersistentItem(world, location, itemstack);
    }*/
}
