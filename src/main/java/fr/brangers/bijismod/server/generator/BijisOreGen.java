package fr.brangers.bijismod.server.generator;

import java.util.Random;

import fr.brangers.bijismod.common.block.BijisBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BijisOreGen extends WorldGenerator{

	@Override
	public boolean generate(World world, Random random, BlockPos pos) {
		generateOre(BijisBlock.COPPER.getDefaultState(), world, random, pos.getX() * 16, pos.getZ() * 16, 16, 256, 4 + random.nextInt(4), 200);
		return true;
	}
	
	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
		int deltaY = maxY - minY;
	
		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
	
			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
		}
	}
}
