package com.brett.direop.other;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBeach;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderSapphire extends WorldProvider{

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBeach.beach, 1.2F);
		this.dimensionId = dimensionRegistry.dimensionId;
	}
	
	public IChunkProvider createChunkGeneration(){
		return null;
	}
	
	@Override
	public String getDimensionName() {
		
		return "Sapphire";
	}

}