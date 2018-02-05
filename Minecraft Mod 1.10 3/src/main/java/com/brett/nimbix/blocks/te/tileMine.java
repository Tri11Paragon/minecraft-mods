package com.brett.nimbix.blocks.te;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.blocks.BlockManager;

import cjminecraft.core.energy.EnergyUnits;
import cjminecraft.core.energy.EnergyUtils;
import cjminecraft.core.energy.compat.forge.CustomForgeEnergyStorage;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyConnection;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;
import cofh.api.energy.TileEnergyHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class tileMine extends TileEntity implements ITickable, IInventory {

	private int increasePerTick = 20;
	
	private int maxRF = 100000;
	private int Energy;
	private int cooldown;
	
	
	private CustomForgeEnergyStorage storage;
	private boolean deleteItems;
	
    
    public tileMine(World worldIn)
    {
        super();
        storage = new CustomForgeEnergyStorage(32000, 0);
    }
    int i = 0;
    int f = 0;
    int k = 0;
    boolean b = false;
    @Override
    public void update(){
    	//System.out.println(deleteItems);
    	i++;
    	if (i % 5 == 0){
    		worldObj.spawnParticle(EnumParticleTypes.DRAGON_BREATH, this.getPos().getX() + 0.5, this.getPos().getY() + 0.3, this.getPos().getZ() + 0.5, 0, 0.0088, 0, 0);
    	}
    	if (i > 20){
    		i = 0;
    	}
    	if (!worldObj.isRemote && this.worldObj != null){
    		this.storage.extractEnergyInternal((int)EnergyUtils.giveEnergyAllFaces(this.worldObj, this.pos, 1000, EnergyUnits.FORGE_ENERGY, false), false);
    		this.storage.receiveEnergyInternal((int)EnergyUtils.takeEnergyAllFaces(this.worldObj, this.pos, 1000, EnergyUnits.FORGE_ENERGY, false), false);
    		//System.out.println(this.storage.getEnergyStored());
    		f++;
    		if (f % 1 == 0){
    			if (b){
    				Block bl = this.worldObj.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getY())).getBlock();
    				System.out.println(deleteItems + "SIDE SERVER");
	        		if (bl != Blocks.BEDROCK && bl != BlockManager.mine){
	        			if (deleteItems){
	        				if (bl == Blocks.STONE || bl == Blocks.COBBLESTONE || bl == Blocks.SANDSTONE || bl == Blocks.SAND){
	        					MainClass.setBlockToAir(worldObj, new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getY()));
	        				} else {
	        					MainClass.setBlockToAirWithDrop(worldObj, this.worldObj.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getZ())), new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getZ()), new BlockPos(this.getPos().getX(), this.getPos().getY() + 1.3, this.getPos().getZ()));
	        				}
	        			} else {
	        				MainClass.setBlockToAirWithDrop(worldObj, this.worldObj.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getZ())), new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getZ()), new BlockPos(this.getPos().getX(), this.getPos().getY() + 1.3, this.getPos().getZ()));
	        			}
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
	    nbt.setBoolean("Delete", deleteItems);
	    super.writeToNBT(nbt);
	    storage.writeToNBT(nbt);
		return nbt;
	}


	@Override
	public void readFromNBT(NBTTagCompound nbt) {
	    this.Energy = nbt.getInteger("Energy");
	    this.cooldown = nbt.getInteger("cooldown");
	    this.deleteItems = nbt.getBoolean("Delete");
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
	public boolean getShouldDeleteItems(){
		return this.deleteItems;
	}
	public void setShouldDeleteItems(boolean b){
		this.deleteItems = b;
	}
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		int metadata = getBlockMetadata();
		return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.readFromNBT(tag);
	}

	@Override
	public NBTTagCompound getTileData() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}
	
	
}
