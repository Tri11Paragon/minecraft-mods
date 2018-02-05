package com.brett.nimbix.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.brett.nimbix.MainClass;
import com.brett.nimbix.tileentitys.TileEntityInfuser;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Infuser extends BlockContainer {

	private static boolean isBurning;
	private final Random random = new Random();

	public Infuser() {
		super(Material.ROCK);
	}
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    } 
	
	@Override
	public boolean isFullCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		// TODO Auto-generated method stub
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		
		playerIn.openGui(MainClass.modInstance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
    	
        return true;
    }

	public Item getItemDropped(int par1, Random random, int par3) {
		return Item.getItemFromBlock(Ore.Infuser);
	}

	public Item getItem(World world, int par2, int par3, int par4) {
		return Item.getItemFromBlock(Ore.Infuser);
	}
	
	/**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityInfuser();
	}

	/*public static void updateBlockState(boolean burning, World world, int x, int y, int z) {
		int direction = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		isBurning = true;

		if (burning) {
			world.setBlock(x, y, z, MainClass.InfuserActive);
		} else {
			world.setBlock(x, y, z, MainClass.Infuser);
		}

		isBurning = false;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);

		if (tileentity != null) {
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}*/

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (!isBurning) {
			TileEntityInfuser tileentitytutfurnace = (TileEntityInfuser) world.getTileEntity(new BlockPos(x, y, z));

			if (tileentitytutfurnace != null) {
				for (int i = 0; i < tileentitytutfurnace.getSizeInventory(); ++i) {
					ItemStack itemstack = tileentitytutfurnace.getStackInSlot(i);

					if (itemstack != null) {
						float f = this.random.nextFloat() * 0.6F + 0.1F;
						float f1 = this.random.nextFloat() * 0.6F + 0.1F;
						float f2 = this.random.nextFloat() * 0.6F + 0.1F;

						while (itemstack.stackSize > 0) {
							int j = this.random.nextInt(21) + 10;

							if (j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}

							itemstack.stackSize -= j;
							EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) {
								entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
							}

							float f3 = 0.025F;
							entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
							entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
							world.spawnEntityInWorld(entityitem);
						}
					}
				}
				//world.func_147453_f(x, y, z, block);
			}
		}
		//super.breakBlock(world, x, y, z, block, meta);
	}

	/*@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if (this.isBurning2) {
			int direction = world.getBlockMetadata(x, y, z);

			float xx = (float) x + 0.5F, yy = (float) y + random.nextFloat() * 6.0F / 16.0F, zz = (float) z + 0.5F, xx2 = random.nextFloat() * 0.3F - 0.2F, zz2 = 0.5F;

			if (direction == 4) {
				world.spawnParticle("smoke", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
			} else if (direction == 5) {
				world.spawnParticle("smoke", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
			} else if (direction == 3) {
				world.spawnParticle("smoke", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
			} else if (direction == 2) {
				world.spawnParticle("smoke", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
			}
		}
	}*/
	
	@Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

}