package com.mraof.minestuck.world.lands.terrain;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandomChestContent;

import com.mraof.minestuck.item.MinestuckItems;
import com.mraof.minestuck.util.AlchemyRecipeHandler;
import com.mraof.minestuck.world.lands.decorator.TallGrassDecorator;
import com.mraof.minestuck.world.lands.decorator.ILandDecorator;
import com.mraof.minestuck.world.lands.decorator.BasicTreeDecorator;

public class LandAspectForest extends TerrainLandAspect
{
	
	public LandAspectForest()
	{
		List<WeightedRandomChestContent> list = new ArrayList<WeightedRandomChestContent>();
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 0), 1, 3, 5));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 1), 1, 3, 4));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 2), 1, 2, 3));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 3), 1, 2, 2));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 4), 1, 2, 3));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 5), 1, 3, 4));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.planks, 1, 0), 2, 10, 5));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.planks, 1, 1), 2, 7, 2));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.planks, 1, 5), 2, 7, 2));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.log, 1, 0), 2, 5, 5));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.log, 1, 1), 2, 5, 4));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.log, 1, 2), 2, 5, 2));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.log2, 1, 0), 2, 5, 2));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.log2, 1, 1), 2, 5, 4));
		list.add(new WeightedRandomChestContent(new ItemStack(Blocks.leaves, 1, 0), 1, 4, 2));
		list.add(new WeightedRandomChestContent(new ItemStack(MinestuckItems.deuceClub, 1, 0), 1, 1, 6));
		list.add(new WeightedRandomChestContent(new ItemStack(MinestuckItems.cane, 1, 0), 1, 1, 6));
		list.add(new WeightedRandomChestContent(new ItemStack(Items.stone_axe, 1, 0), 1, 1, 5));
		list.add(new WeightedRandomChestContent(new ItemStack(Items.iron_axe, 1, 0), 1, 1, 3));
		list.add(new WeightedRandomChestContent(new ItemStack(Items.diamond_axe, 1, 0), 1, 1, 1));
		
		this.lootMap.put(AlchemyRecipeHandler.BASIC_MEDIUM_CHEST, list);
	}
	
	@Override
	public IBlockState getSurfaceBlock()
	{
		return Blocks.grass.getDefaultState();
	}
	
	@Override
	public IBlockState getUpperBlock()
	{
		return Blocks.dirt.getDefaultState();
	}
	
	@Override
	public IBlockState[] getStructureBlocks()
	{
		return new IBlockState[] {Blocks.stone.getDefaultState(), Blocks.stonebrick.getDefaultState()};
	}
	
	@Override
	public IBlockState getDecorativeBlockFor(IBlockState state)
	{
		if(state.getBlock() == Blocks.stonebrick)
			return Blocks.stonebrick.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CHISELED);
		else return state;
	}
	
	@Override
	public String getPrimaryName()
	{
		return "Forest";
	}
	
	@Override
	public String[] getNames()
	{
		return new String[] {"forest", "tree"};
	}
	
	@Override
	public List<ILandDecorator> getDecorators()
	{
		ArrayList<ILandDecorator> list = new ArrayList<ILandDecorator>();
		list.add(new BasicTreeDecorator());
		list.add(new TallGrassDecorator(0.5F));
		return list;
	}
	
	@Override
	public int getDayCycleMode()
	{
		return 0;
	}
	
	@Override
	public Vec3 getFogColor()
	{
		return new Vec3(0.0D, 1.0D, 0.6D);
	}
	
	@Override
	public float getRainfall()	//Same as vanilla forest
	{
		return 0.8F;
	}
	
}