package fr.brangers.bijismod.init;

import fr.brangers.bijismod.BijisMod;
import fr.brangers.bijismod.blocks.OreSocialBlock;
import fr.brangers.bijismod.world.generation.Test;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BijisMod.modid);


    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, BijisMod.modid);

    public static final RegistryObject<Block> KUBIUM_ORE = Registration.register("kubium_ore",
            new OreSocialBlock(AbstractBlock.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> KUBIUM_BLOCK = Registration.register("kubium_block",
            new Block(AbstractBlock.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> KUBIUM_SLAB = Registration.register("kubium_slab",
            new SlabBlock(AbstractBlock.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> KUBIUM_STAIRS = Registration.register("kubium_stairs",
            new StairsBlock(() -> KUBIUM_BLOCK.get().getDefaultState(), AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Feature<NoFeatureConfig>> test = FEATURES.register("test", () -> new Test(NoFeatureConfig.field_236558_a_));

}
