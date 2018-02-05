package com.brett.nimbix.items;

import java.util.List;
import java.util.Random;

import java.util.HashSet;
import java.util.Set;

import com.brandon3055.brandonscore.inventory.BlockToStackHelper;
import com.brandon3055.brandonscore.inventory.InventoryDynamic;
import com.brett.nimbix.KeyBindings;
import com.brett.nimbix.MainClass;
import com.brett.nimbix.Values;
import com.brett.nimbix.helpers.NBTHelper;
import com.brett.nimbix.helpers.PairKV;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.realmsclient.gui.ChatFormatting;

import codechicken.lib.inventory.InventoryUtils;
import codechicken.lib.raytracer.RayTracer;
import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class StaffOfPower extends ItemStaffOfMiningTool implements IEnergyContainerItem {

	private int usage;
	private int maxStorage;
	private boolean AOEEnabled = false;

	private int currentSizeOfAOE = 1;
	private boolean SPEED = false;

	protected StaffOfPower(ToolMaterial material, int energyUsage, int maxEnergyStorage) {
		super(material);
		this.usage = energyUsage;
		this.maxStorage = maxEnergyStorage;
	}

	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos,
			EntityLivingBase playerIn) {
		if (stack.getTagCompound() != null) {
			if (getEnergyStored(stack) >= usage) {
				// System.out.println("WE ARE MINING");
				// System.out.println("We are AOE: " + NBTHelper.getInteger(stack, "AOE"));
				//extractEnergy(stack, usage * NBTHelper.getInteger(stack, "AOE") * 8, false);
				//breakAOEBlocksNew(stack, pos, NBTHelper.getInteger(stack, "AOE"), 0, (EntityPlayer) playerIn,worldIn);
			}
		}
		return true;
		//return false;
	}
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
		
        return false;
    }

	public boolean breakAOEBlocksNew(ItemStack stack, BlockPos pos, int breakRadius, int breakDepth,
			EntityPlayer player, World world) {
		IBlockState blockState = player.worldObj.getBlockState(pos);


		InventoryDynamic inventoryDynamic = new InventoryDynamic();

		float refStrength = ForgeHooks.blockStrength(blockState, player, player.worldObj, pos);

		PairKV<BlockPos, BlockPos> aoe = getMiningArea(pos, player, breakRadius, breakDepth);
		List<BlockPos> aoeBlocks = Lists.newArrayList(BlockPos.getAllInBox(aoe.getKey(), aoe.getValue()));
		if (true) {
			for (BlockPos block : aoeBlocks) {
				if (!player.worldObj.isAirBlock(block) && player.worldObj.getTileEntity(block) != null) {
					if (player.worldObj.isRemote) {
						player.addChatComponentMessage(
								new TextComponentTranslation("Unable to AOE, Safe mode detected a tile entity"));
					} else {
						((EntityPlayerMP) player).connection
								.sendPacket(new SPacketBlockChange(((EntityPlayerMP) player).worldObj, block));
					}
					return true;
				}
			}
		}

		player.worldObj.playEvent(2001, pos, Block.getStateId(blockState));

		for (BlockPos block : aoeBlocks) {
			breakExtraBlockNew(stack, player.worldObj, block, player, refStrength, inventoryDynamic);
		}

		List<EntityItem> items = player.worldObj.getEntitiesWithinAABB(EntityItem.class,
				new AxisAlignedBB(aoe.getKey(), aoe.getValue().add(1, 1, 1)));
		for (EntityItem item : items) {
			if (!player.worldObj.isRemote && !item.isDead) {
				InventoryUtils.insertItem(inventoryDynamic, item.getEntityItem(), false);
			}
		}

		return true;
	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean isToolEffective(ItemStack stack, IBlockState state) {
		if (getEnergyStored(stack) < usage) {
			return false;
		}

		for (String type : stack.getItem().getToolClasses(stack)) {
			if (state.getBlock().isToolEffective(type, state) || Values.EFFECTIVE_ON_PICK.contains(state.getBlock())
					|| Values.EFFECTIVE_ON_PICK.contains(state.getMaterial())) {
				return true;
			}
		}

		return false;
	}
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		RayTraceResult result = playerIn.rayTrace(600, 1);
		ActionResult<ItemStack> ar = super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);

		try {
			if (!worldIn.isRemote && playerIn.isSneaking()) {
				int var24 = MathHelper.floor_double((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
				int i = (int) result.hitVec.xCoord;
				int j = (int) result.hitVec.yCoord;
				int k = (int) result.hitVec.zCoord;

				int t = NBTHelper.getInteger(itemStackIn, "AOE");

				for (int x = 0; x < t; x++) {
					for (int y = 0; y < t; y++) {
						for (int z = 0; z < t; z++) {
							int posx = i + (x - (t / 2));
							int posy = j + (y - (t / 2));
							int posz = k + (z - (t / 2));
							BlockPos pos = new BlockPos(posx, posy, posz);
							IBlockState state = worldIn.getBlockState(pos);
							// Item item = Item.getItemFromBlock(state.getBlock());
							// System.out.println(item.getUnlocalizedName());
							if (state != Blocks.STONE.getDefaultState() && state != Blocks.DIRT.getDefaultState()
									&& state != Blocks.GRASS.getDefaultState()
									&& state != Blocks.COBBLESTONE.getDefaultState()
									&& state != Blocks.BEDROCK.getDefaultState()
									&& state != Blocks.SANDSTONE.getDefaultState() && state != Blocks.SAND) {
								Item item = state.getBlock().getItemDropped(state, itemRand, 0);
								if (item != Item.getItemFromBlock(Blocks.STONE)
										&& item != Item.getItemFromBlock(Blocks.COBBLESTONE)
										&& item != Item.getItemFromBlock(Blocks.GRAVEL)
										&& item != Item.getItemFromBlock(Blocks.SANDSTONE)
										&& item != Item.getItemFromBlock(Blocks.SAND)) {
									if (playerIn.inventory.getFirstEmptyStack() != -1) {
										playerIn.inventory.addItemStackToInventory(new ItemStack(item));
									} else {
										EntityItem worldItem = new EntityItem(worldIn, playerIn.getPosition().getX(),
												playerIn.getPosition().getY(), playerIn.getPosition().getZ(),
												new ItemStack(item));
										worldItem.setNoPickupDelay();
										worldIn.spawnEntityInWorld(worldItem);
									}
								}
							}
							if (state != Blocks.BEDROCK.getDefaultState())
								worldIn.setBlockToAir(pos);
						}
					}
				}
			}

		} catch (Exception e) {
		}

		return ar;
	}

	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		itemStack.setTagCompound(new NBTTagCompound());
		itemStack.getTagCompound().setInteger("code", (int) (Math.random() * Integer.MAX_VALUE));
		itemStack.getTagCompound().setInteger("AOE", currentSizeOfAOE);
		itemStack.getTagCompound().setBoolean("SPEED", SPEED);
		this.setSpeed(22);
	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (isSelected) {
			// System.out.println("stack name " + stack.getItem().getUnlocalizedName());
			keyPressed(stack);
			if (stack.getTagCompound() != null) {
				stack.getTagCompound().setInteger("AOE", currentSizeOfAOE);
				stack.getTagCompound().setBoolean("SPEED", SPEED);
			} else {
				stack.setTagCompound(new NBTTagCompound());
				stack.getTagCompound().setInteger("AOE", currentSizeOfAOE);
				stack.getTagCompound().setBoolean("SPEED", SPEED);
			}
		}
	}

	int p = 1;

	public void keyPressed(ItemStack stack) {
		if (KeyBindings.AOESize.isPressed()) {
			AOEEnabled = !AOEEnabled;
			System.out.println(AOEEnabled);
			if (AOEEnabled) {
				currentSizeOfAOE = 3;
			} else {
				currentSizeOfAOE = 1;
			}
		}
		if (KeyBindings.Power.isPressed()) {
			SPEED = !SPEED;
			if (stack.getTagCompound() != null){
				stack.getTagCompound().setBoolean("SPEED", SPEED);
			}
			if (stack.getTagCompound().getBoolean("SPEED")) {
				this.setSpeed(90);
			} else {
				this.setSpeed(22);
			}
		}
	}

	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {
		list.add(ChatFormatting.DARK_GREEN + "Just your normal super pickaxe");
		if (itemstack.getTagCompound() != null) {
			int code = NBTHelper.getInteger(itemstack, "AOE");
			list.add(ChatFormatting.DARK_RED + "Mining Radius: " + code + "x" + code);
			if (itemstack.getTagCompound().getBoolean("SPEED")) {
				list.add(ChatFormatting.DARK_RED + "Speed: " + ChatFormatting.DARK_GREEN + "SUPER" + ChatFormatting.WHITE +"SPEED");} else {
				list.add(ChatFormatting.DARK_RED + "Speed: Regular");
			}
			list.add(ChatFormatting.GOLD + "Energy: " + MainClass.foramteNumber(getEnergyStored(itemstack) + "") + " / "
					+ MainClass.foramteNumber(getMaxEnergyStored(itemstack) + ""));
		}
	}

	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
		if (this.getMaxEnergyStored(container) <= 0) {
			return 0;
		}

		if (container.getTagCompound() == null || !container.getTagCompound().hasKey("Energy")) {
			return 0;
		}
		int energy = container.getTagCompound().getInteger("Energy");
		int energyExtracted = Math.min(energy, Math.min(this.getMaxEnergyStored(container), maxExtract));

		if (!simulate) {
			energy -= energyExtracted;
			container.getTagCompound().setInteger("Energy", energy);
		}
		// updateBar(container);
		return energyExtracted;
	}

	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
		if (this.getMaxEnergyStored(container) <= 0) {
			return 0;
		}

		if (container.getTagCompound() == null) {
			container.setTagCompound(new NBTTagCompound());
		}
		int energy = container.getTagCompound().getInteger("Energy");
		int energyReceived = Math.min(this.getMaxEnergyStored(container) - energy,
				Math.min(this.getMaxEnergyStored(container), maxReceive));

		if (!simulate) {
			energy += energyReceived;
			container.getTagCompound().setInteger("Energy", energy);
		}
		// updateBar(container);
		return energyReceived;
	}

	public int getEnergyStored(ItemStack container) {
		// TODO Auto-generated method stub
		if (container.getTagCompound() == null || !container.getTagCompound().hasKey("Energy")) {
			return 0;
		}
		return container.getTagCompound().getInteger("Energy");
	}

	public int getMaxEnergyStored(ItemStack container) {
		// TODO Auto-generated method stub
		return maxStorage;
	}
	
	protected void breakExtraBlockNew(ItemStack stack, World world, BlockPos pos, EntityPlayer player,
			float refStrength, InventoryDynamic inventory) {
		if (world.isAirBlock(pos)) {
			return;
		}

		IBlockState state = world.getBlockState(pos);
		Block block = state.getBlock();

		if (!isToolEffective(stack, state)) {
			return;
		}

		float strength = ForgeHooks.blockStrength(state, player, world, pos);

		if (!ForgeHooks.canHarvestBlock(block, player, world, pos) || refStrength / strength > 10f) {
			return;
		}

		if (player.capabilities.isCreativeMode) {
			if (world.isRemote && itemRand.nextInt(10) == 0) {
				world.playEvent(2001, pos, Block.getStateId(state));
			}

			block.onBlockHarvested(world, pos, state, player);
			if (block.removedByPlayer(state, world, pos, player, false)) {
				block.onBlockDestroyedByPlayer(world, pos, state);
			}

			if (!world.isRemote) {
				((EntityPlayerMP) player).connection.sendPacket(new SPacketBlockChange(world, pos));
			}

			return;
		}

		if (!world.isRemote) {
			int xp = ForgeHooks.onBlockBreakEvent(world, ((EntityPlayerMP) player).interactionManager.getGameType(),
					(EntityPlayerMP) player, pos);
			if (xp == -1) {
				EntityPlayerMP mpPlayer = (EntityPlayerMP) player;
				mpPlayer.connection.sendPacket(new SPacketBlockChange(world, pos));
				return;
			}

			// stack.onBlockDestroyed(world, state, pos, player);

			player.worldObj.getBlockState(pos).getBlock().dropBlockAsItem(player.worldObj, pos,
					player.worldObj.getBlockState(pos), 1);
			BlockToStackHelper.breakAndCollectWithPlayer(world, pos, inventory, player, xp);
		} else {
			if (itemRand.nextInt(10) == 0) {
				world.playEvent(2001, pos, Block.getStateId(state));
			}
			if (block.removedByPlayer(state, world, pos, player, true)) {
				block.onBlockDestroyedByPlayer(world, pos, state);
			}

			stack.onBlockDestroyed(world, state, pos, player);

			Minecraft.getMinecraft().getConnection()
					.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, pos,
							Minecraft.getMinecraft().objectMouseOver.sideHit));
		}
	}

	public PairKV<BlockPos, BlockPos> getMiningArea(BlockPos pos, EntityPlayer player, int breakRadius,
			int breakDepth) {
		RayTraceResult traceResult = RayTracer.retrace(player, 4.5);

		if (traceResult == null || traceResult.typeOfHit != RayTraceResult.Type.BLOCK) {
			return new PairKV<>(pos, pos);
		}

		int sideHit = traceResult.sideHit.getIndex();

		int xMax = breakRadius;
		int xMin = breakRadius;
		int yMax = breakRadius;
		int yMin = breakRadius;
		int zMax = breakRadius;
		int zMin = breakRadius;
		int yOffset = 0;

		switch (sideHit) {
		case 0:
			yMax = breakDepth;
			yMin = 0;
			zMax = breakRadius;
			break;
		case 1:
			yMin = breakDepth;
			yMax = 0;
			zMax = breakRadius;
			break;
		case 2:
			xMax = breakRadius;
			zMin = 0;
			zMax = breakDepth;
			yOffset = breakRadius - 1;
			break;
		case 3:
			xMax = breakRadius;
			zMax = 0;
			zMin = breakDepth;
			yOffset = breakRadius - 1;
			break;
		case 4:
			xMax = breakDepth;
			xMin = 0;
			zMax = breakRadius;
			yOffset = breakRadius - 1;
			break;
		case 5:
			xMin = breakDepth;
			xMax = 0;
			zMax = breakRadius;
			yOffset = breakRadius - 1;
			break;
		}

		if (breakRadius == 0) {
			yOffset = 0;
		}

		return new PairKV<>(pos.add(-xMin, yOffset - yMin, -zMin), pos.add(xMax, yOffset + yMax, zMax));
	}

}
