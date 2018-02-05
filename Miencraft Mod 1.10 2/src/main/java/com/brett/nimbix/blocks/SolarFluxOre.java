package com.brett.nimbix.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SolarFluxOre extends Block {
	
	public SolarFluxOre(Material materialIn) {
		super(materialIn);
		setHarvestLevel("pickaxe", 3);
		setHardness(8.0f);
		setResistance(5.0f);
	}
	
}
