package com.brett.nimbix.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

import com.brett.nimbix.CoordEntry;

public class TileEntityTeleporter extends TileEntity {
	
	private int dim;
	private int x;
	private int y;
	private int z;
	
	public void addEntry(String name, ItemStack Memory){
		NBTTagCompound nbt = (NBTTagCompound) Memory.getTagCompound().getTag("Cords");
		dim = nbt.getInteger("dim");
		x = nbt.getInteger("PosX");
		y = nbt.getInteger("PosY");
		z = nbt.getInteger("PosZ");
	}
	
	public BlockPos getBlockPos(){
		return new BlockPos(x, y, z);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		
		x = compound.getInteger("PosX");
		y = compound.getInteger("PosY");
		z = compound.getInteger("PosZ");
		
		//System.out.println("READ: X: " + compound.getInteger("PosX") + " Y: " + compound.getInteger("PosY") + " Z: " + compound.getInteger("PosZ"));
		//System.out.println("SYS R: X: " + x + " Y: " + y + " Z: " + z);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		compound.setInteger("PosX", x);
		compound.setInteger("PosY", y);
		compound.setInteger("PosZ", z);
		
		//System.out.println("WRITE: X: " + compound.getInteger("PosX") + " Y: " + compound.getInteger("PosY") + " Z: " + compound.getInteger("PosZ"));
		//System.out.println("SYS W: X: " + x + " Y: " + y + " Z: " + z);
		
		return compound;
	}
	
}
