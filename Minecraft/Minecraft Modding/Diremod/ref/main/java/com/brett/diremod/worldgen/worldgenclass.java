package com.brett.diremod.worldgen;

import java.util.Random;

import com.brett.diremod.MainClass;
import com.brett.diremodcore.Core;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class worldgenclass implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case -1:
			generateInNether(world, random, chunkX*16, chunkZ*16);
			break;
		case 0:
			generateInOverworld(world, random, chunkX*16, chunkZ*16);
			break;
		case 1:
			generateInEnd(world, random, chunkX*16, chunkZ*16);
			break;
		}
	}

	private void generateInNether(World world, Random random, int x, int z) {
		for(int i = 0; i < 50; i++){ // number == rairty
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(256);
			int ChunkZ = z + random.nextInt(16);
			(new NetherGenMinable(Blocks.quartz_ore, 25)).generate(world, random, chunkX, chunkY, ChunkZ);
			}
	}

	private void generateInOverworld(World world, Random random, int x, int z) {
		for(int i = 0; i < 10; i++){ // number == rairty
			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(256);
			int ChunkZ = z + random.nextInt(16);
			(new WorldGenMinable(Blocks.bedrock, 50)).generate(world, random, chunkX, chunkY, ChunkZ);
			}
	}

	private void generateInEnd(World world, Random random, int x, int z) {
		
	}

}