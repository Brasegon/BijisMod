package fr.brangers.bijismod.proxy;

import java.io.File;

import fr.brangers.bijismod.common.block.BijisBlock;

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
