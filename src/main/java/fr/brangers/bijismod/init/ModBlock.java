package fr.brangers.bijismod.init;

import fr.brangers.bijismod.BijisMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BijisMod.modid);

    public static final RegistryObject<Block> ROCK_BLOCK = BLOCKS.register("rock",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.ANVIL)));

}
