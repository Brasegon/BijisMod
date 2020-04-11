package fr.brangers.bijismod;


import java.util.EnumMap;

import org.apache.logging.log4j.Logger;

import fr.brangers.bijismod.handlers.RegistryHandler;
import fr.brangers.bijismod.proxy.BijisModCommon;
import fr.brangers.bijismod.server.generator.BijisGen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.FMLEmbeddedChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = BijisMod.MODID, name = "BijisMod", version = "0.1", acceptedMinecraftVersions = "[1.12.2]")
public class BijisMod {
	public static final String MODID = "bijismod";
	public static String money;
	@Instance(BijisMod.MODID)
	public static BijisMod instance;
	@SidedProxy(clientSide = "fr.brangers.bijismod.proxy.BijisModClient", serverSide = "fr.brangers.bijismod.proxy.BijisModServer")
    public static BijisModCommon proxy;
	
	public static Logger logger;

	public static SimpleNetworkWrapper network;
	 
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog(); // initialise le logger.  event.getModLog() retourne un logger avec votre modid
        proxy.preInit(event.getSuggestedConfigurationFile());
        network = NetworkRegistry.INSTANCE.newSimpleChannel("test:init");
        network.registerMessage(MyMessage.Handler.class, MyMessage.class, 0, Side.CLIENT);
        GameRegistry.registerWorldGenerator(new BijisGen(), 3);
        RegistryHandler.preInitRegistries(event);
    }
 
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init();
    }
}
