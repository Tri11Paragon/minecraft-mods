package com.brett.nimbix.blocks.ores;

import java.util.List;

import com.brett.nimbix.blocks.item.IMetaBlockName;
import com.brett.nimbix.helpers.EnumHandler;
import com.brett.nimbix.helpers.EnumHandler.OreTypes;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Ores extends Block implements IMetaBlockName {

	public static final PropertyEnum TYPE = PropertyEnum.create("type", OreTypes.class);
	
	private OreTypes type;
	
	public Ores(Material materialIn, OreTypes type) {
		super(materialIn);
		this.type = type;
		this.setHardness(2);
		this.setResistance(2);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, OreTypes.IRIDIUM));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {TYPE});
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		OreTypes type = (OreTypes) state.getValue(TYPE);
		return type.getId();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, OreTypes.values()[meta]);
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for (int i=0;i<OreTypes.values().length;i++){
			list.add(new ItemStack(itemIn, 1, i));
		}
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return OreTypes.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
}
