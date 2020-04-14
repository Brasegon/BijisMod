package fr.brangers.bijismod.proxy;

import java.io.File;

import fr.brangers.bijismod.common.block.BijisBlock;
import fr.brangers.bijismod.handlers.EventHandlerClient;
import net.minecraftforge.common.MinecraftForge;

public class BijisModCommon {
	
	public void preInit(File configFile)
    {
        System.out.println("pre init côté commun");
//        BijisBlock.init();
    }
 
    public void init()
    {
 
    }
}
