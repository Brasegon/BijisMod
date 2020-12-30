package fr.brangers.bijismod.init;

import com.mojang.serialization.Codec;
import fr.brangers.bijismod.BijisMod;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class BijisBiome  {

    public static enum Category implements IStringSerializable {
        NONE("none"),
        TAIGA("taiga"),
        EXTREME_HILLS("extreme_hills"),
        JUNGLE("jungle"),
        MESA("mesa"),
        PLAINS("plains"),
        SAVANNA("savanna"),
        ICY("icy"),
        THEEND("the_end"),
        BEACH("beach"),
        FOREST("forest"),
        OCEAN("ocean"),
        DESERT("desert"),
        RIVER("river"),
        SWAMP("swamp"),
        MUSHROOM("mushroom"),
        NETHER("nether");

        public static final Codec<Biome.Category> CODEC = IStringSerializable.createEnumCodec(Biome.Category::values, Biome.Category::byName);

        private final String name;

        private Category(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static Biome.Category byName(String name) {
            return BY_NAME.get(name);
        }

        public String getString() {
            return this.name;
        }
    }

    public static Biome makeTestBiome() {
        BiomeGenerationSettings.Builder genSettings =  genSettings(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_SAND_CONFIG);
        return new Biome.Builder().precipitation(Biome.RainType.SNOW)
                .category(Biome.Category.PLAINS)
                .depth(0.13f)
                .scale(0.5f)
                .temperature(0.5f)
                .downfall(0.3f)
                .category(Biome.Category.PLAINS)
                .withGenerationSettings(genSettings.build())
                .withMobSpawnSettings(MobSpawnInfo.EMPTY)
                .setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).withSkyColor(1).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build())
                .build();
    }

    private static <C extends ISurfaceBuilderConfig> BiomeGenerationSettings.Builder genSettings
            (SurfaceBuilder<C> surfaceBuilder, C config) {
        return new BiomeGenerationSettings.Builder().withSurfaceBuilder(surfaceBuilder.func_242929_a(config));
    }
}
