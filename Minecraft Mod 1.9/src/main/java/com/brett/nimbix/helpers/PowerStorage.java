package com.brett.nimbix.helpers;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class PowerStorage extends TileEntity implements IPowerStorage {

	private int currentPowerInStorage;
	private int maxPower;
	
	
	@Override
	public boolean addPower(int amount) {
		if(currentPowerInStorage + amount > maxPower){
			return false;
		}
		currentPowerInStorage += amount;
		return true;
	}

	@Override
	public boolean removePower(int amount) {
		
		if(currentPowerInStorage - amount > 0){
			currentPowerInStorage -= amount;
			return true;
		}
		
		return false;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		
		currentPowerInStorage = compound.getInteger("curStorage");
		maxPower = compound.getInteger("max");
		
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		compound.setInteger("curStorage", currentPowerInStorage);
		compound.setInteger("max", maxPower);
		
		return compound;
	}

}
