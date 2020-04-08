package fr.brangers.bijismod.handlers;

import fr.brangers.bijismod.common.block.BijisBlock;
import fr.brangers.bijismod.common.block.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.registerAll(
				((BlockBase) BijisBlock.COPPER).createItemBlock(),
				((BlockBase) BijisBlock.PLATINE).createItemBlock()
		);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		IForgeRegistry<Block> registry = event.getRegistry();
		registry.registerAll(
			BijisBlock.COPPER,
			BijisBlock.PLATINE
		);
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{		
		registerModels(Item.getItemFromBlock(BijisBlock.PLATINE));
    	registerModels(Item.getItemFromBlock(BijisBlock.COPPER));
	}
	private static void registerModels(Item item) {
    	ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
	@SubscribeEvent
	public static void registerEnchantment(RegistryEvent.Register<Enchantment> event)
	{
		
	}
	
	
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
	}
	
	public static void initRegistries(FMLInitializationEvent event)
	{
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event)
	{
	}
	
	public static void serverRegistries(FMLServerStartingEvent event)
	{
	}
}
