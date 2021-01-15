package fr.brangers.bijismod.world.generation;

import fr.brangers.bijismod.BijisMod;
import fr.brangers.bijismod.init.ModBlock;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.PlainFlowerBlockStateProvider;
import net.minecraft.world.gen.feature.*;
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

    @Mod.EventBusSubscriber(modid = BijisMod.modid, bus = Bus.MOD)
    public static class Registrative {
        @SubscribeEvent(priority = EventPriority.LOW)
        public static void test(final RegistryEvent.Register<Feature<?>> event) {
            System.out.printf("TEST ICE SPIKE");
            ICE_SPIKE = register("test", Feature.ICE_SPIKE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(3));
        }
    }



    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        generation.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Features.BASALT_PILLAR);

        for(ConfiguredFeature<?, ?> ore : overworldOres){
            System.out.printf("HOLALALALA");
            if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }
        List<Supplier<ConfiguredFeature<?, ?>>> l = generation.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES);

        for (Supplier<ConfiguredFeature<?, ?>> m:
             l) {
            System.out.println(m.get().getFeature().getRegistryType().getName());
        }

    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, BijisMod.modid + ":" + name, configuredFeature);
    }

}
