package fr.brangers.bijismod.world.generation;

import fr.brangers.bijismod.BijisMod;
import fr.brangers.bijismod.init.ModBlock;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.PlainFlowerBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OreGeneration {

    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();



    public static void registerOres() {
        overworldOres.add(register("kubium_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
            OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlock.KUBIUM_ORE.get().getDefaultState(), 4))
                .range(128).square()
                .func_242731_b(64)
        ));
    }

    public static ConfiguredFeature<?, ?> ICE_SPIKE;

    public static void registerConfigFeatures() {
        System.out.println("REGISTER FEATURES OKEY");
        ICE_SPIKE = register("test", ModBlock.test.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    }



    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        /*if (event.getCategory() == Biome.Category.PLAINS) {
            generation.getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> ICE_SPIKE);
        }*/
        for(ConfiguredFeature<?, ?> ore : overworldOres) {
            System.out.printf("HOLALALALA");
            if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }

    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, BijisMod.modid + ":" + name, configuredFeature);
    }

}
