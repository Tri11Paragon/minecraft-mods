package com.brett.nimbix.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class CopperOre extends Block{

	public CopperOre(Material materialIn) {
		super(materialIn);
		setHarvestLevel("pickaxe", 2);
		setHardness(3.0f);
		setResistance(5.0f);
		// TODO Auto-generated constructor stub
		
	}
	
	/*public void generateSurface(World world, java.util.Random rand, int chunkX, int chunkZ) {
		for (int i = 0; i < 20; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(48) + 15;
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(Ore.Copper.getDefaultState(), 16)).generate(world, rand, new BlockPos(randPosX, randPosY, randPosZ));
		}
		System.out.println("GENERATING");
	}*/

}
