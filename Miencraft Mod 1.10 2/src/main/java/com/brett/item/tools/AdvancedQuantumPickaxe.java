package com.brett.item.tools;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.brandon3055.brandonscore.inventory.BlockToStackHelper;
import com.brandon3055.brandonscore.inventory.InventoryDynamic;
import com.brett.nimbix.KeyBindings;
import com.brett.nimbix.KeyInputHandler;
import com.brett.nimbix.MainClass;
import com.brett.nimbix.helpers.NBTHelper;
import com.brett.nimbix.helpers.PairKV;
import com.google.common.collect.Lists;
import com.mojang.realmsclient.gui.ChatFormatting;

import codechicken.lib.inventory.InventoryUtils;
import codechicken.lib.raytracer.RayTracer;
import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class AdvancedQuantumPickaxe extends EnergyPickaxeBase implements IEnergyContainerItem {
	
	public int usage;
	
	public AdvancedQuantumPickaxe(ToolMaterial material, int usage, int maxStorage, int[] allowedInts) {
		super(material, usage, maxStorage, allowedInts, "pickaxe");
		this.usage=usage;
	}
	
}
