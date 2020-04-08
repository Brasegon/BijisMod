package fr.brangers.bijismod.common.block;

import java.util.ArrayList;
import java.util.List;

import fr.brangers.bijismod.BijisMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class BijisBlock {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block COPPER = new BlockOre(Material.ROCK, "copper").setHardness(0f);
	public static final Block PLATINE = new BlockOre(Material.ROCK, "platine").setHardness(0f);
	
}
