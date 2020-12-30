package fr.brangers.bijismod.event.gui;

import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class MainMenuEvent {
    @SubscribeEvent
    public static void onOpenGui(GuiOpenEvent event)
    {

    }
}
