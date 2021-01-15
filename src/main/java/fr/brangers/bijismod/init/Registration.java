package fr.brangers.bijismod.init;

import fr.brangers.bijismod.BijisMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


public class Registration {

    public static final ItemGroup SOCIAL_KUB = new SocialKubItemGroup("social_kub_item_group");


    public static void register() {
        BijisMod.LOGGER.info("Chargement effectué pour les regustration");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlock.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBlock.FEATURES.register(modEventBus);
    }

    public static RegistryObject<Block> register(String name, Block block) {
        RegistryObject<Block> registryObject = ModBlock.BLOCKS.register(name, () -> block);
        ModItems.ITEMS.register(name, () -> new BlockItem(registryObject.get(),
                new Item.Properties().group(SOCIAL_KUB)));
        return registryObject;
    }

    public static RegistryObject<Item> register(String name, Item item) {
        RegistryObject<Item> registryObject = ModItems.ITEMS.register(name, () -> item);
        return registryObject;
    }

    public static class SocialKubItemGroup extends ItemGroup {

        public SocialKubItemGroup(String label) {
            super(label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlock.KUBIUM_ORE.get());
        }
    }


}
