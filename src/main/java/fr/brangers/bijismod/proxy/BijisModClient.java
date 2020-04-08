package fr.brangers.bijismod.proxy;

import java.io.File;

public class BijisModClient extends BijisModCommon {
	@Override
    public void preInit(File configFile)
    {
        // TODO Auto-generated method stub
        super.preInit(configFile);
        System.out.println("pre init côté client");
    }
 
    @Override
    public void init()
    {
        // TODO Auto-generated method stub
        super.init();
    }
}
