package fr.brangers.bijismod.init;

import fr.brangers.bijismod.BijisMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;

public class ModBiome {

    public static HashMap<String, Biome> biomeList = new HashMap<>();
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, BijisMod.modid);

    public static final RegistryKey<Biome> testbiome = registerBiome("test", BijisBiome.makeTestBiome());


    private static RegistryKey<Biome> registerBiome(String name, Biome biome) {
        biomeList.put(name, biome);
        BIOMES.register(name, () -> biome);
        System.out.println("Il était un petit navire: " + biome.getScale());
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(BijisMod.modid, name));
    }
}
