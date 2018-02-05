

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Container;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.Block;

import java.util.Random;

public class mcreator_bLOCK {

	public mcreator_bLOCK() {
	}

	public static BlockBLOCK block;

	public static Object instance;

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}

	public void registerRenderers() {
	}

	public void load(FMLInitializationEvent event) {
		GameRegistry.registerTileEntity(mcreator_bLOCK.TileEntityCustom.class, "TileEntitybLOCK");
		if (event.getSide() == Side.CLIENT) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation("TestEnvironmentMod:BLOCK", "inventory"));
		}

		GameRegistry.addRecipe(new ItemStack(block, 1), new Object[]{"X1X", "XXX", "XXX", Character.valueOf('1'), new ItemStack(Blocks.LOG, 1, 2),});
	}

	static {

		block = (BlockBLOCK) (new BlockBLOCK().setHardness(2.0F).setResistance(10.0F).setLightLevel(0.0F).setUnlocalizedName("BLOCK")
				.setLightOpacity(0).setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
		block.setHarvestLevel("pickaxe", 0);
	}

	public void generateSurface(World world, java.util.Random rand, int chunkX, int chunkZ) {
		for (int i = 0; i < 30; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(72) + 49;
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(mcreator_bLOCK.block.getDefaultState(), 30)).generate(world, rand, new BlockPos(randPosX, randPosY, randPosZ));
		}
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	static class BlockBLOCK extends Block implements ITileEntityProvider {

		int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0;

		boolean red = false;

		protected BlockBLOCK() {
			super(Material.GROUND);

			GameRegistry.registerBlock(this, "BLOCK");
			setSoundType(SoundType.GROUND);

		}

		@Override
		public TileEntity createNewTileEntity(World worldIn, int meta) {
			return new TileEntityCustom();
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
			if (tileentity instanceof mcreator_bLOCK.TileEntityCustom)
				return Container.calcRedstoneFromInventory((TileEntityCustom) tileentity);
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

	public static class TileEntityCustom extends TileEntityLockable implements IInventory {
		private static final Random RNG = new Random();
		private ItemStack[] stacks = new ItemStack[50];
		protected String customName;

		@Override
		public int getSizeInventory() {
			return 50;
		}

		@Override
		public ItemStack getStackInSlot(int index) {
			return this.stacks[index];
		}

		@Override
		public ItemStack decrStackSize(int index, int count) {
			if (this.stacks[index] != null) {
				if (this.stacks[index].stackSize <= count) {
					ItemStack itemstack1 = this.stacks[index];
					this.stacks[index] = null;
					this.markDirty();
					return itemstack1;
				} else {
					ItemStack itemstack = this.stacks[index].splitStack(count);

					if (this.stacks[index].stackSize == 0) {
						this.stacks[index] = null;
					}

					this.markDirty();
					return itemstack;
				}
			} else {
				return null;
			}
		}

		/**
		 * Removes a stack from the given slot and returns it.
		 */
		@Override
		public ItemStack removeStackFromSlot(int index) {
			if (this.stacks[index] != null) {
				ItemStack itemstack = this.stacks[index];
				this.stacks[index] = null;
				return itemstack;
			} else {
				return null;
			}
		}

		@Override
		public void setInventorySlotContents(int index, ItemStack stack) {
			this.stacks[index] = stack;

			if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
				stack.stackSize = this.getInventoryStackLimit();
			}

			this.markDirty();
		}

		@Override
		public String getName() {
			return this.hasCustomName() ? this.customName : "container.dispenser";
		}

		@Override
		public boolean hasCustomName() {
			return this.customName != null;
		}

		@Override
		public void readFromNBT(NBTTagCompound compound) {
			super.readFromNBT(compound);
			NBTTagList nbttaglist = compound.getTagList("Items", 10);
			this.stacks = new ItemStack[this.getSizeInventory()];

			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
				int j = nbttagcompound.getByte("Slot") & 255;

				if (j >= 0 && j < this.stacks.length) {
					this.stacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
				}
			}
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound compound) {
			super.writeToNBT(compound);
			NBTTagList nbttaglist = new NBTTagList();

			for (int i = 0; i < this.stacks.length; ++i) {
				if (this.stacks[i] != null) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("Slot", (byte) i);
					this.stacks[i].writeToNBT(nbttagcompound);
					nbttaglist.appendTag(nbttagcompound);
				}
			}

			compound.setTag("Items", nbttaglist);

			return compound;
		}

		@Override
		public int getInventoryStackLimit() {
			return 64;
		}

		@Override
		public boolean isUseableByPlayer(EntityPlayer player) {
			return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double) this.pos.getX() + 0.5D,
					(double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
		}

		@Override
		public void openInventory(EntityPlayer player) {
		}

		@Override
		public void closeInventory(EntityPlayer player) {
		}

		/**
		 * Returns true if automation is allowed to insert the given stack
		 * (ignoring stack size) into the given slot.
		 */
		@Override
		public boolean isItemValidForSlot(int index, ItemStack stack) {
			return true;
		}

		@Override
		public String getGuiID() {
			return "minecraft:bLOCK";
		}

		@Override
		public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int getField(int id) {
			return 0;
		}

		@Override
		public void setField(int id, int value) {
		}

		@Override
		public int getFieldCount() {
			return 0;
		}

		@Override
		public void clear() {
			for (int i = 0; i < this.stacks.length; ++i) {
				this.stacks[i] = null;
			}
		}
	}
}
