package com.mraof.minestuck.world.lands.title;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import com.mraof.minestuck.util.AlchemyRecipeHandler;
import com.mraof.minestuck.world.lands.decorator.structure.BasicTowerDecorator;
import com.mraof.minestuck.world.lands.gen.ChunkProviderLands;

public class LandAspectTowers extends TitleLandAspect
{
	
	@Override
	public String getPrimaryName()
	{
		return "Towers";
	}
	
	@Override
	public String[] getNames()
	{
		return new String[] {"tower"};
	}
	
	@Override
	protected void prepareChunkProvider(ChunkProviderLands chunkProvider)
	{
		if(chunkProvider.decorators != null)
		{
			chunkProvider.decorators.add(new BasicTowerDecorator());
			chunkProvider.sortDecorators();
			ChestGenHooks chestGen = chunkProvider.lootMap.get(AlchemyRecipeHandler.BASIC_MEDIUM_CHEST);
			chestGen.addItem(new WeightedRandomChestContent(new ItemStack(Blocks.ladder), 3, 16, 3));
		}
	}
	
}