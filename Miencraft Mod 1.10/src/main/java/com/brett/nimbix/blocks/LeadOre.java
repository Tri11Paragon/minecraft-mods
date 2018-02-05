package com.brett.nimbix.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class LeadOre extends Block {

	public LeadOre(Material materialIn) {
		super(materialIn);
		setHarvestLevel("pickaxe", 2);
		setHardness(3.0f);
		setResistance(5.0f);
	}

}
