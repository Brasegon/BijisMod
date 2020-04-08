package fr.brangers.bijismod.proxy;

import java.io.File;

public class BijisModServer extends BijisModCommon{
	@Override
    public void preInit(File configFile)
    {
        super.preInit(configFile);
        System.out.println("pre init côté serveur");
    }
 
    @Override
    public void init()
    {
        super.init();
    }
}
