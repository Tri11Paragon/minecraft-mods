package com.brett.nimbix.blocks.te;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.blocks.BlockManager;

import cjminecraft.core.energy.EnergyUnits;
import cjminecraft.core.energy.EnergyUtils;
import cjminecraft.core.energy.compat.forge.CustomForgeEnergyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

public class tileBigMine extends TileEntity implements ITickable, IInventory {

	private int increasePerTick = 20;
	
	private int maxRF = 100000;
	private int Energy;
	private int cooldown;
	
	
	private CustomForgeEnergyStorage storage;
	
    
    public tileBigMine(World worldIn)
    {
        super();
        storage = new CustomForgeEnergyStorage(32000, 0);
    }
    int i = 0;
    int f = 0;
    int k = 0;
    int x = 0;
    boolean b = false;
    @Override
    public void update(){
    	i++;
    	i %= 5;
    	x++;
    	x %= 360;
    	if (i == 0){
    		worldObj.spawnParticle(EnumParticleTypes.DRAGON_BREATH, this.getPos().getX() + 0.25, this.getPos().getY() + 0.3, this.getPos().getZ() + 0.5, 0, 0.0050, 0, 0);
    		worldObj.spawnParticle(EnumParticleTypes.DRAGON_BREATH, this.getPos().getX() + 0.5, this.getPos().getY() + 0.3, this.getPos().getZ() + 0.25, 0, 0.0050, 0, 0);
    		worldObj.spawnParticle(EnumParticleTypes.DRAGON_BREATH, this.getPos().getX() + 0.75, this.getPos().getY() + 0.3, this.getPos().getZ() + 0.5, 0, 0.0050, 0, 0);
    		worldObj.spawnParticle(EnumParticleTypes.DRAGON_BREATH, this.getPos().getX() + 0.5, this.getPos().getY() + 0.3, this.getPos().getZ() + 0.75, 0, 0.0050, 0, 0);
    	}
    	worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.getPos().getX() + 0.5, this.getPos().getY() + 1.5, this.getPos().getZ() + 0.5, 0, 1, 0, 100);
    	if (!worldObj.isRemote && this.worldObj != null){
    		this.storage.extractEnergyInternal((int)EnergyUtils.giveEnergyAllFaces(this.worldObj, this.pos, 1000, EnergyUnits.FORGE_ENERGY, false), false);
    		this.storage.receiveEnergyInternal((int)EnergyUtils.takeEnergyAllFaces(this.worldObj, this.pos, 1000, EnergyUnits.FORGE_ENERGY, false), false);
    		//System.out.println(this.storage.getEnergyStored());
    		f++;
    		if (f % 1 == 0){
    			if (b){
	        		if (this.worldObj.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getY())).getBlock() != Blocks.BEDROCK && this.worldObj.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - k, this.getPos().getY())).getBlock() != BlockManager.mine){
	        			MainClass.setBlockToAirWithDrop(worldObj, this.worldObj.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getZ())), new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getZ()), new BlockPos(this.getPos().getX(), this.getPos().getY() + 1.3, this.getPos().getZ()));
	        			MainClass.setBlockToAirWithDrop(worldObj, this.worldObj.getBlockState(new BlockPos(this.getPos().getX()+1, this.getPos().getY() - k - 1, this.getPos().getZ())), new BlockPos(this.getPos().getX()+1, this.getPos().getY() - k - 1, this.getPos().getZ()), new BlockPos(this.getPos().getX(), this.getPos().getY() + 1.3, this.getPos().getZ()));
	        			MainClass.setBlockToAirWithDrop(worldObj, this.worldObj.getBlockState(new BlockPos(this.getPos().getX()-1, this.getPos().getY() - k - 1, this.getPos().getZ())), new BlockPos(this.getPos().getX()-1, this.getPos().getY() - k - 1, this.getPos().getZ()), new BlockPos(this.getPos().getX(), this.getPos().getY() + 1.3, this.getPos().getZ()));
	        			MainClass.setBlockToAirWithDrop(worldObj, this.worldObj.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getZ()+1)), new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getZ()+1), new BlockPos(this.getPos().getX(), this.getPos().getY() + 1.3, this.getPos().getZ()));
	        			MainClass.setBlockToAirWithDrop(worldObj, this.worldObj.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getZ()-1)), new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getZ()-1), new BlockPos(this.getPos().getX(), this.getPos().getY() + 1.3, this.getPos().getZ()));
	        			
	        			MainClass.setBlockToAirWithDrop(worldObj, this.worldObj.getBlockState(new BlockPos(this.getPos().getX()+1, this.getPos().getY() - k - 1, this.getPos().getZ()+1)), new BlockPos(this.getPos().getX()+1, this.getPos().getY() - k - 1, this.getPos().getZ()+1), new BlockPos(this.getPos().getX(), this.getPos().getY() + 1.3, this.getPos().getZ()));
	        			MainClass.setBlockToAirWithDrop(worldObj, this.worldObj.getBlockState(new BlockPos(this.getPos().getX()-1, this.getPos().getY() - k - 1, this.getPos().getZ()+1)), new BlockPos(this.getPos().getX()-1, this.getPos().getY() - k - 1, this.getPos().getZ()+1), new BlockPos(this.getPos().getX(), this.getPos().getY() + 1.3, this.getPos().getZ()));
	        			MainClass.setBlockToAirWithDrop(worldObj, this.worldObj.getBlockState(new BlockPos(this.getPos().getX()+1, this.getPos().getY() - k - 1, this.getPos().getZ()-1)), new BlockPos(this.getPos().getX()+1, this.getPos().getY() - k - 1, this.getPos().getZ()-1), new BlockPos(this.getPos().getX(), this.getPos().getY() + 1.3, this.getPos().getZ()));
	        			MainClass.setBlockToAirWithDrop(worldObj, this.worldObj.getBlockState(new BlockPos(this.getPos().getX()-1, this.getPos().getY() - k - 1, this.getPos().getZ()-1)), new BlockPos(this.getPos().getX()-1, this.getPos().getY() - k - 1, this.getPos().getZ()-1), new BlockPos(this.getPos().getX(), this.getPos().getY() + 1.3, this.getPos().getZ()));
	        		}
	    			f = 0;
	    			k++;
    			} else {
    				f = 0;
    			}
    		}
    		if (k > 100){
    			b = false;
    			k=0;
    		}
    		//System.out.println(k + " F: " + f + " B :" + b);
    	}
    }

    public void explode()
    {
        //float f = 400.0F;
        //this.worldObj.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, f, true);
    	b = true;
    }
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
	    nbt.setInteger("Energy", this.Energy);
	    nbt.setInteger("cooldown", this.cooldown);
	    super.writeToNBT(nbt);
	    storage.writeToNBT(nbt);
		return nbt;
	}


	@Override
	public void readFromNBT(NBTTagCompound nbt) {
	    this.Energy = nbt.getInteger("Energy");
	    this.cooldown = nbt.getInteger("cooldown");
	    super.readFromNBT(nbt);
	    storage.readFromNBT(nbt);
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY)
			return (T) this.storage;
		return super.getCapability(capability, facing);
	}
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY)
			return true;
		return super.hasCapability(capability, facing);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Miner";
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	
}
