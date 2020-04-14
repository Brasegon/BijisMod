package fr.brangers.bijismod.proxy;

import java.io.File;

import org.lwjgl.input.Keyboard;

import fr.brangers.bijismod.handlers.EventHandlerClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class BijisModClient extends BijisModCommon {
	public static KeyBinding keyBindTest;

	@Override
    public void preInit(File configFile)
    {
        // TODO Auto-generated method stub
        super.preInit(configFile);
        System.out.println("pre init côté client");
        keyBindTest = new KeyBinding("modtest.key", Keyboard.KEY_C, "key.categories.gameplay");
        ClientRegistry.registerKeyBinding(keyBindTest);
    }
 
    @Override
    public void init()
    {
        // TODO Auto-generated method stub
        super.init();
    }
}
