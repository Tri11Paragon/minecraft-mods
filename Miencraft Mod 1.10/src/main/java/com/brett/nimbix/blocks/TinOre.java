package com.brett.nimbix.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TinOre extends Block {

	public TinOre(Material materialIn) {
		super(materialIn);
		setHarvestLevel("pickaxe", 2);
		setHardness(3.0f);
		setResistance(5.0f);
		// TODO Auto-generated constructor stub
	}

}
