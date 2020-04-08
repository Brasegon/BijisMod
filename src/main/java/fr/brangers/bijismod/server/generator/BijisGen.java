package fr.brangers.bijismod.server.generator;

import java.util.Random;

import fr.brangers.bijismod.common.block.BijisBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class BijisGen implements IWorldGenerator{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.getDimension() == 0) { // the overworld
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		BlockPos pos = new BlockPos(chunkX, 0, chunkZ);
		(new BijisOreGen()).generate(world, random, pos);
	}
	
}
