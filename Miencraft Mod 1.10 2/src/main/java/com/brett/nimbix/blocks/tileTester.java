package com.brett.nimbix.blocks;

import com.brett.nimbix.MainClass;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class tileTester extends Entity {
	
	private static final DataParameter<Integer> FUSE = EntityDataManager.<Integer>createKey(EntityTNTPrimed.class, DataSerializers.VARINT);
    private EntityLivingBase tntPlacedBy;
    /** How long the fuse is */
    private int fuse;

    public tileTester(World worldIn)
    {
        super(worldIn);
        this.fuse = 80;
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
    }

    public tileTester(World worldIn, double x, double y, double z, EntityLivingBase igniter)
    {
        this(worldIn);
        this.setPosition(x, y, z);
        float f = (float)(Math.random() * (Math.PI * 2D));
        this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
        this.motionY = 0.20000000298023224D;
        this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
        this.setFuse(10);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
        this.tntPlacedBy = igniter;
    }

    protected void entityInit()
    {
        this.dataManager.register(FUSE, Integer.valueOf(80));
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (!this.hasNoGravity())
        {
            this.motionY -= 0.03999999910593033D;
        }

        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
        }

        --this.fuse;

        if (this.fuse <= 0)
        {
            this.setDead();

            if (!this.worldObj.isRemote)
            {
                this.explode();
            }
        }
        else
        {
            this.handleWaterMovement();
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }
    }

    private void explode()
    {
        //float f = 400.0F;
        //this.worldObj.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, f, true);
    	int sizeX = 10;
    	int sizeZ = 10;
    	int sizeY = 100;
    	int d = 0;
    	for (int i=0; i < sizeX; i++){
    		for(int j=0; j < sizeZ; j++){
    			for (int k=0; k < sizeY; k++){
    				Block b = this.worldObj.getBlockState(new BlockPos(this.posX - i, this.posY - k, this.posZ - j)).getBlock();
    				if (b == Blocks.IRON_ORE || b == Blocks.GOLD_ORE || b == Blocks.DIAMOND_ORE || b == Blocks.REDSTONE_ORE || b == Blocks.EMERALD_ORE || b == Blocks.LAPIS_ORE || b == Blocks.COAL_ORE){
    					//MainClass.setBlockToAirWithDrop(this.worldObj, this.worldObj.getBlockState(new BlockPos(this.posX - i, this.posY - k, this.posZ - j)), new BlockPos(this.posX - i, this.posY - k, this.posZ - j), new BlockPos( this.posX, this.posY + 2, this.posZ));
    					this.worldObj.setBlockToAir(new BlockPos(this.posX - i, this.posY - k, this.posZ - j));
    					this.worldObj.spawnEntityInWorld(new EntityTNTPrimed(this.worldObj, this.posX - i, this.posY - k, this.posZ - j, tntPlacedBy));
    					//this.worldObj.setBlockState(new BlockPos(this.posX - i, this.posY - k, this.posZ - j), Blocks.TNT.getDefaultState());
    				}
    			}
    		}
    	}
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setShort("Fuse", (short)this.getFuse());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound compound)
    {
        this.setFuse(compound.getShort("Fuse"));
    }

    /**
     * returns null or the entityliving it was placed or ignited by
     */
    public EntityLivingBase getTntPlacedBy()
    {
        return this.tntPlacedBy;
    }

    public float getEyeHeight()
    {
        return 0.0F;
    }

    public void setFuse(int fuseIn)
    {
        this.dataManager.set(FUSE, Integer.valueOf(fuseIn));
        this.fuse = fuseIn;
    }

    public void notifyDataManagerChange(DataParameter<?> key)
    {
        if (FUSE.equals(key))
        {
            this.fuse = this.getFuseDataManager();
        }
    }

    /**
     * Gets the fuse from the data manager
     */
    public int getFuseDataManager()
    {
        return ((Integer)this.dataManager.get(FUSE)).intValue();
    }

    public int getFuse()
    {
        return this.fuse;
    }
	
}
