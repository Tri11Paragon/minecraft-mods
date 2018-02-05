package com.brett.nimbix.tileentitys;

import com.brett.nimbix.blocks.Ore;
import com.brett.nimbix.blocks.lamp;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;

import java.util.Random;

public class TileLamp extends TileEntity implements ITickable {
    private static final String[] MODES = new String[]{"Stopped", "Radius: +1, Area: 3x3x3", "Radius: +2, Area: 5x3x5", "Radius: +3, Area: 7x3x7", "Radius: +4, Area: 9x3x9"};
    private static final int SPEEDS = 4;

    private boolean poweredByRedstone;
    private byte speed;
    private byte mode;
    private byte cachedMode;
    private Random rand;

    private int xMin;
    private int yMin;
    private int zMin;
    private int xMax;
    private int yMax;
    private int zMax;

    public TileLamp() {
        this.cachedMode = -1;
        this.rand = new Random();
    }

    protected int speed(final int base) {
        return base;
    }

    @Override
    public void update() {
        if (this.worldObj.isRemote)
            return;

        if (this.poweredByRedstone || this.mode == 0 || this.speed == 0)
            return;

        this.updateCachedModeIfNeeded();
        this.tickNeighbors();
    }

    private void updateCachedModeIfNeeded() {
        if (this.cachedMode != this.mode) {
            this.xMin = this.pos.getX() - this.mode;
            this.yMin = this.pos.getY() - 1;
            this.zMin = this.pos.getZ() - this.mode;
            this.xMax = this.pos.getX() + this.mode;
            this.yMax = this.pos.getY() + 1;
            this.zMax = this.pos.getZ() + this.mode;
            this.cachedMode = this.mode;
        }
    }

    private void tickNeighbors() {
        for (int x = this.xMin; x <= this.xMax; x++) {
            for (int y = this.yMin; y <= this.yMax; y++) {
                for (int z = this.zMin; z <= this.zMax; z++) {
                    this.tickBlock(new BlockPos(x, y, z));
                }
            }
        }
    }

    private void tickBlock(final BlockPos pos) {
        final IBlockState blockState = this.worldObj.getBlockState(pos);
        final Block block = blockState.getBlock();

        if (block == null)
            return;

        if (block == Ore.lamp)
            return;

        if (block instanceof BlockFluidBase)
            return;

        if (block.getTickRandomly()) {
            for (int i = 0; i < this.speed; i++) {
                if (getWorld().getBlockState(pos) != blockState)
                    break;
                block.updateTick(this.worldObj, pos, blockState, this.rand);
            }
        }

        if (block.hasTileEntity(this.worldObj.getBlockState(pos))) {
            final TileEntity tile = this.worldObj.getTileEntity(pos);
            if (tile != null && !tile.isInvalid()) {
                //if (tile.getClass() ==  TileLamp)
                    //return;

                for (int i = 0; i < this.speed(this.speed); i++) {
                    if (tile.isInvalid())
                        break;

                    if (tile instanceof ITickable) {
                        ((ITickable) tile).update();
                    }
                }
            }
        }
    }

    public void setPoweredByRedstone(final boolean poweredByRedstone) {
        this.poweredByRedstone = poweredByRedstone;
    }

    public void changeMode(final boolean sneaking) {
        if (sneaking) {
            if (this.speed < TileLamp.SPEEDS)
                this.speed++;
            else
                this.speed = 0;
        } else {
            if (this.mode < MODES.length - 1)
                this.mode++;
            else
                this.mode = 0;
        }
    }

    public String getSpeedDescription() {
        return this.speed(this.speed) * 100 + "% increase";
    }

    public String getModeDescription() {
        return TileLamp.MODES[this.mode];
    }

    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setByte("Speed", this.speed);
        tag.setByte("Mode", this.mode);
        tag.setBoolean("PoweredByRedstone", this.poweredByRedstone);
        return tag;
    }

    @Override
    public void readFromNBT(final NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.speed = tag.getByte("Speed");
        this.mode = tag.getByte("Mode");
        this.poweredByRedstone = tag.getBoolean("PoweredByRedstone");
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        final NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return new SPacketUpdateTileEntity(getPos(), -999, nbt);
    }

    @Override
    public void onDataPacket(final NetworkManager net, final SPacketUpdateTileEntity pkt) {
        super.onDataPacket(net, pkt);
        this.readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public boolean shouldRefresh(final World world, final BlockPos pos, final IBlockState oldState, final IBlockState newState) {
        return oldState.getBlock() != newState.getBlock();
    }
}