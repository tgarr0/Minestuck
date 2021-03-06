package com.mraof.minestuck.world.lands.terrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.mraof.minestuck.util.AlchemyRecipeHandler;
import com.mraof.minestuck.world.lands.ILandAspect;
import com.mraof.minestuck.world.lands.decorator.ILandDecorator;
import com.mraof.minestuck.world.lands.gen.ChunkProviderLands;
import com.mraof.minestuck.world.lands.gen.DefaultTerrainGen;
import com.mraof.minestuck.world.lands.gen.ILandTerrainGen;
import com.mraof.minestuck.world.lands.structure.GateStructurePillar;
import com.mraof.minestuck.world.lands.structure.IGateStructure;
import com.mraof.minestuck.world.lands.structure.LandStructureHandler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandomChestContent;

public abstract class TerrainLandAspect implements ILandAspect<TerrainLandAspect>
{
	
	public final Map<String, List<WeightedRandomChestContent>> lootMap = new HashMap<String, List<WeightedRandomChestContent>>();
	
		/**
		 * Returns the blocks that can possibly be use in the land's underground blocks.
		 * @return
		 */
		public IBlockState getSurfaceBlock()
		{
			return getUpperBlock();
		}
		
		/**
		 * Returns the blocks that can possibly be use in the land's topmost layer of blocks.
		 * @return
		 */
		public abstract IBlockState getUpperBlock();
		
		public IBlockState getGroundBlock()
		{
			return Blocks.stone.getDefaultState();
		}
		
		/**
		 * Returns the block that is a part of the land's ocean.
		 * @return
		 */
		public IBlockState getOceanBlock()
		{
			return Blocks.water.getDefaultState();
		}
		
		public IBlockState getRiverBlock()
		{
			return getOceanBlock();
		}
		
		public abstract List<ILandDecorator> getDecorators();
		
		/**
		 *  Returns a integer representing how they land's day cycle will proceed.
		 *  
		 *  0 = Normal day cycle;
		 *  1 = Always day;
		 *  2 = Always night.
		 */
		public abstract int getDayCycleMode();

		public abstract Vec3 getFogColor();
	
	public IBlockState[] getStructureBlocks()
	{
		return new IBlockState[] {getGroundBlock()};
	}
	
	public int getWeatherType()
	{
		return -1;
	}
	
	public float getRainfall()
	{
		return 0.5F;
	}
	
	public float getTemperature()
	{
		return 0.7F;
	}
	
	public float getOceanChance()
	{
		return 1/2F;
	}
	
	@Override
	public List<TerrainLandAspect> getVariations()
	{
		ArrayList<TerrainLandAspect> list = new ArrayList<TerrainLandAspect>();
		list.add(this);
		return list;
	}
	
	@Override
	public TerrainLandAspect getPrimaryVariant()
	{
		return this;
	}
	
	/**
	 * Returns a block state for use in decoration based on an other block state
	 * @param state The state that will be primary used alongside the returned state. This parameter will always be a block state provided from getStructureBlocks()
	 * @return The block to be used for decorative details in structures
	 */
	public IBlockState getDecorativeBlockFor(IBlockState state)
	{
		return state;
	}
	
	public ILandTerrainGen createTerrainGenerator(ChunkProviderLands chunkProvider, Random rand)
	{
		return new DefaultTerrainGen(chunkProvider, rand);
	}
	
	public void modifyStructureList(List<LandStructureHandler.StructureEntry> list)
	{}
	
	public void modifyChestContent(List<WeightedRandomChestContent> content, String lootType)
	{
		if(lootMap.containsKey(lootType))
			content.addAll(lootMap.get(lootType));
		else content.addAll(lootMap.get(AlchemyRecipeHandler.BASIC_MEDIUM_CHEST)); //Default value
	}
	
	@Override
	public IGateStructure getGateStructure()
	{
		return new GateStructurePillar();
	}
	
}
