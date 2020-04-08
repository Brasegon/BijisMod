package fr.brangers.bijismod;


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
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = BijisMod.MODID, name = "BijisMod", version = "0.1", acceptedMinecraftVersions = "[1.12.2]")
public class BijisMod {
	public static final String MODID = "bijismod";
	
	@Instance(BijisMod.MODID)
	public static BijisMod instance;
	@SidedProxy(clientSide = "fr.brangers.bijismod.proxy.BijisModClient", serverSide = "fr.brangers.bijismod.proxy.BijisModServer")
    public static BijisModCommon proxy;
	
	public static Logger logger;
	 
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog(); // initialise le logger.  event.getModLog() retourne un logger avec votre modid
        proxy.preInit(event.getSuggestedConfigurationFile());
        GameRegistry.registerWorldGenerator(new BijisGen(), 3);
        RegistryHandler.preInitRegistries(event);
    }
 
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init();
    }
}
