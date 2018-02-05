package com.brett.nimbix.blocks.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemOres extends ItemBlock {

	public ItemOres(Block block) {
		super(block);
		if (!(block instanceof IMetaBlockName)) {
			throw new IllegalArgumentException(String.format("The given Block %s is not an instance of IMetaBlockName!", block.getUnlocalizedName()));
		}
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + ((IMetaBlockName) this.block).getSpecialName(stack);
	}
	
	@Override
	public int getMetadata(int damage) {
		// TODO Auto-generated method stub
		return damage;
	}
	
}
