package com.brett.worldgen;

import java.util.Random;

import com.brett.nimbix.blocks.Ore;
import com.brett.nimbix.blocks.SolarFluxOre;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {
	
	//World Generators
	private WorldGenerator solar_overworld;
	private WorldGenerator solar_nether;
	private WorldGenerator solar_end;
	
	private WorldGenerator copper;
	private WorldGenerator tin;
	private WorldGenerator lead;
	
	private WorldGenerator test;
	
	
	public OreGen() {
		solar_overworld = new WorldGenMinable(Ore.SolarFluxOre.getDefaultState(), 8);
		solar_nether = new WorldGenMinable(Ore.SolarFluxOre.getDefaultState(), 4, new NetherGenPredicate());
		solar_end = new WorldGenMinable(Ore.SolarFluxOre.getDefaultState(), 10, new EndGenPredicate());
		
		copper = new WorldGenMinable(Ore.Copper.getDefaultState(), 8);
		tin = new WorldGenMinable(Ore.Tin.getDefaultState(), 8);
		lead = new WorldGenMinable(Ore.Lead.getDefaultState(), 8);
		
		//test = new WorldGenMinable(Blocks.DIAMOND_BLOCK.getDefaultState(), 64, new AirGenPredicate());
	}
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i ++) {
			int x = chunk_X * 16 + rand.nextInt(16);
		        int y = minHeight + rand.nextInt(heightDiff);
		        int z = chunk_Z * 16 + rand.nextInt(16);
		        generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()){
		case 0: // OverWorld
			this.runGenerator(solar_overworld, world, random, chunkX, chunkZ, 20, 0, 70);
			this.runGenerator(copper, world, random, chunkX, chunkZ, 30, 0, 120);
			this.runGenerator(tin, world, random, chunkX, chunkZ, 19, 0, 120);
			this.runGenerator(lead, world, random, chunkX, chunkZ, 22, 0, 100); 
			//this.runGenerator(test, world, random, chunkX, chunkZ, 60, 0, 200); 
		case 1: //END
			this.runGenerator(solar_end, world, random, chunkX, chunkZ, 20, 0, 70);
		case -1: // NETHER
			this.runGenerator(solar_nether, world, random, chunkX, chunkZ, 20, 0, 70);
		case 6:
			this.runGenerator(solar_overworld, world, random, chunkX, chunkZ, 20, 0, 70);
		}
	}

}
