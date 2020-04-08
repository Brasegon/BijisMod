package fr.brangers.bijismod.common.fluid;

import fr.brangers.bijismod.BijisMod;
import fr.brangers.bijismod.common.block.BlockBase;
import fr.brangers.bijismod.common.block.BlockOre;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = BijisMod.MODID)
public class BijisFluid {
	public static final Fluid MOLTEN_COPPER_FLUID = new FluidLiquid("molten_copper", new ResourceLocation("tutorial:blocks/molten_copper_still"), new ResourceLocation("tutorial:blocks/molten_copper_flow"));
	
	public static void registerFluids()
	{
		registerFluid(MOLTEN_COPPER_FLUID);
	}
	public static void registerFluid(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
}
