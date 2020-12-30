package fr.brangers.bijismod.init;

import fr.brangers.bijismod.BijisMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


public class Registration {

    public static void register() {
        BijisMod.LOGGER.info("Chargement effectué pour les regustration");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlock.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBiome.BIOMES.register(modEventBus);
    }
}
