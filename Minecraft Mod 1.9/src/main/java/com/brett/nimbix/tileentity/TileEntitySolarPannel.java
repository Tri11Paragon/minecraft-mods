package com.brett.nimbix.tileentity;

import com.brett.nimbix.helpers.IPowerGenerator;
import com.brett.nimbix.helpers.PowerGenerator;
import com.brett.nimbix.helpers.PowerStorage;

import net.minecraft.block.BlockFurnace;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.MathHelper;

public class TileEntitySolarPannel extends PowerGenerator {
	
	public int getPower(){
		return powerStorage;
		
	}
	
}
