package com.brett.nimbix.blocks;

import javax.annotation.Nullable;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.blocks.te.tileBigMine;
import com.brett.nimbix.blocks.te.tileMine;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class bigMine extends Block implements ITileEntityProvider {
	
    public bigMine()
    {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    	@Override
    	@SideOnly(Side.CLIENT)
    	public BlockRenderLayer getBlockLayer() {
    		return BlockRenderLayer.CUTOUT_MIPPED;
    	}
    
    	@Override
    	public boolean isOpaqueCube(IBlockState state) {
    		return false;
    	}
    
    	@Override
    	public boolean isFullBlock(IBlockState state) {
    		return false;
    	}

    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);

        if (worldIn.isBlockPowered(pos))
        {
            this.onBlockDestroyedByPlayer(worldIn, pos, state);
            //worldIn.setBlockToAir(pos);
        }
    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
    {
        if (worldIn.isBlockPowered(pos))
        {
            this.onBlockDestroyedByPlayer(worldIn, pos, state);
            //worldIn.setBlockToAir(pos);
        }
    }

    /**
     * Called when a player destroys this Block
     */
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
    {
        this.explode(worldIn, pos, state, (EntityLivingBase)null);
    }

    public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter)
    {
        if (!worldIn.isRemote)
        {
            tileBigMine m = (tileBigMine)worldIn.getTileEntity(pos);
            m.explode();
        }
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }

    /**
     * Called When an Entity Collided with the Block
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        if (!worldIn.isRemote && entityIn instanceof EntityArrow)
        {
            EntityArrow entityarrow = (EntityArrow)entityIn;

            if (entityarrow.isBurning())
            {
                this.explode(worldIn, pos, worldIn.getBlockState(pos), entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)entityarrow.shootingEntity : null);
               //worldIn.setBlockToAir(pos);
            }
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new tileBigMine(worldIn);
	}
	
}
