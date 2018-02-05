package com.brett.nimbix.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.brett.nimbix.tileentitys.TestBlockTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TestBlock extends Block implements ITileEntityProvider {
	
	public TestBlock(Material materialIn) {
		super(materialIn);
		setHarvestLevel("pickaxe", 2);
		setHardness(3.0f);
		setResistance(5.0f);
		// TODO Auto-generated constructor stub
	}
	
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            ILockableContainer ilockablecontainer = this.getLockableContainer(worldIn, pos);

            if (ilockablecontainer != null)
            {
                playerIn.displayGUIChest(ilockablecontainer);
                System.out.println("TEST 1");
            }

            return true;
        }
    }
    
    @Nullable
    public ILockableContainer getLockableContainer(World worldIn, BlockPos pos)
    {
        return this.getContainer(worldIn, pos, false);
    }
    
    @Nullable
    public ILockableContainer getContainer(World p_189418_1_, BlockPos p_189418_2_, boolean p_189418_3_)
    {
        TileEntity tileentity = p_189418_1_.getTileEntity(p_189418_2_);

        if (!(tileentity instanceof TestBlockTileEntity))
        {
        	 System.out.println("TEST BAD 2");
            return null;
        }
        else
        {
            ILockableContainer ilockablecontainer = (TestBlockTileEntity)tileentity;

            if (!p_189418_3_ && this.isBlocked(p_189418_1_, p_189418_2_))
            {
            	 System.out.println("TEST BAD 1");
                return null;
            }
            else
            {
            	ilockablecontainer = new InventoryLargeChest("container.chestDouble", (TestBlockTileEntity)tileentity, ilockablecontainer);
            	
            	 System.out.println("TEST 2");
            	
                return ilockablecontainer;
            }
        }
    }
    
    private boolean isBlocked(World worldIn, BlockPos pos)
    {
    	 System.out.println("TEST 3");
        //return this.isBelowSolidBlock(worldIn, pos) || this.isOcelotSittingOnChest(worldIn, pos);
    	return false;
    }
	

	int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0;

	boolean red = false;

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TestBlockTileEntity();
	}

	@Override
	public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int eventID, int eventParam) {
		super.eventReceived(state, worldIn, pos, eventID, eventParam);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof TestBlockTileEntity)
			return Container.calcRedstoneFromInventory((TestBlockTileEntity) tileentity);
		else
			return 0;
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		world.scheduleUpdate(new BlockPos(i, j, k), this, this.tickRate(world));

	}

	@Override
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return red ? 15 : 0;
	}

	@Override
	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return red ? 15 : 0;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.SOLID;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	}

	@Override
	public int tickRate(World world) {
		return 10;
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
	}
	
}
