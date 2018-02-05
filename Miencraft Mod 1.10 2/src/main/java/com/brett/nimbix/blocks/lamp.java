package com.brett.nimbix.blocks;

import com.brett.nimbix.tileentitys.TileLamp;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import org.apache.logging.log4j.Level;

public class lamp extends BlockTorch implements ITileEntityProvider {
    public lamp() {
        this.setLightLevel(0.75f);
        //this.setUnlocalizedName("torcherino.torcherino");
    }

    @Override
    public void onBlockAdded(final World world, BlockPos pos, final IBlockState state) {
        if (!world.isRemote) {
            final TileEntity tile = world.getTileEntity(pos);

            if (tile != null && tile instanceof TileLamp) {
                ((TileLamp) tile).setPoweredByRedstone(world.isBlockIndirectlyGettingPowered(pos) > 0);
            }
        }

        super.onBlockAdded(world, pos, state);

        //if (Torcherino.logPlacement)
            //Torcherino.logger.log(Level.INFO, "Torcherino was placed at " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ());
    }

    @Override
    public void neighborChanged(final IBlockState state, final World world, final BlockPos pos, final Block block) {
        if (!world.isRemote) {
            final TileEntity tile = world.getTileEntity(pos);

            if (tile != null && tile instanceof TileLamp) {
                ((TileLamp) tile).setPoweredByRedstone(world.isBlockIndirectlyGettingPowered(pos) > 0);
            }
        }

        super.neighborChanged(state, world, pos, block);
    }

    @Override
    public boolean onBlockActivated(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player, final EnumHand hand, final ItemStack heldItem, final EnumFacing side, final float hitX, final float hitY, final float hitZ) {
        if (!world.isRemote) {
            final TileEntity tile = world.getTileEntity(pos);

            if (hand != EnumHand.MAIN_HAND)
                return false;

            if (tile == null || !(tile instanceof TileLamp))
                return false;

            final TileLamp torch = (TileLamp) tile;

            torch.changeMode(player.isSneaking());

            if (player.isSneaking()) {
                player.addChatComponentMessage(new TextComponentString("Changed speed: " + torch.getSpeedDescription()));
            } else {
                player.addChatComponentMessage(new TextComponentString("Changed mode: " + torch.getModeDescription()));
            }
        }

        return false;
    }

    @Override
    public TileEntity createNewTileEntity(final World world, final int i) {
        return new TileLamp();
    }
    
	@Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
}