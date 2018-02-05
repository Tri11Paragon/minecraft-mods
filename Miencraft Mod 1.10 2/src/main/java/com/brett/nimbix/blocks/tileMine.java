package com.brett.nimbix.blocks;

import com.brett.nimbix.MainClass;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class tileMine extends TileEntity {
	
	private static final DataParameter<Integer> FUSE = EntityDataManager.<Integer>createKey(EntityTNTPrimed.class, DataSerializers.VARINT);
    private EntityLivingBase tntPlacedBy;
    /** How long the fuse is */
    private int fuse;

    public tileMine(World worldIn)
    {
        super();
    }

    public void explode()
    {
        //float f = 400.0F;
        //this.worldObj.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, f, true);
    	int sizeY = 100;
    	int d = 0;
    	for (int k=0; k < sizeY; k++){
    		if (this.worldObj.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getY())).getBlock() != Blocks.BEDROCK && this.worldObj.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - k, this.getPos().getY())).getBlock() != Ore.mine){
    			MainClass.setBlockToAirWithDrop(worldObj, this.worldObj.getBlockState(new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getZ())), new BlockPos(this.getPos().getX(), this.getPos().getY() - k - 1, this.getPos().getZ()), new BlockPos(this.getPos().getX(), this.getPos().getY() + 2, this.getPos().getZ()));
    		}
    	}
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound compound)
    {
        
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound compound)
    {
        
    }
	
}
