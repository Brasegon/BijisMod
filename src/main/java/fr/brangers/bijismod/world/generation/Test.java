package fr.brangers.bijismod.world.generation;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class Test extends Feature<NoFeatureConfig> {
    public Test(Codec<NoFeatureConfig> p_i231962_1_) {
        super(p_i231962_1_);
    }

    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        BlockPos.Mutable blockpos$mutable1 = pos.toMutable();
        blockpos$mutable1.setPos(pos.getX(), 250, pos.getZ());
        reader.setBlockState(blockpos$mutable1, Blocks.BEDROCK.getDefaultState(), 4);
        return true;
    }
}
