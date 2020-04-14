package fr.brangers.bijismod.handlers;

import fr.brangers.bijismod.BijisMod;
import fr.brangers.bijismod.GuiLol;
import fr.brangers.bijismod.network.GetMoney;
import fr.brangers.bijismod.network.SitServer;
import fr.brangers.bijismod.proxy.BijisModClient;
import fr.brangers.bijismod.util.SeatUtil;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(value = Side.CLIENT, modid = BijisMod.MODID)
public class EventHandlerClient {
	@SubscribeEvent
    public static void onGuiOpen(GuiOpenEvent event)
    {
    	if (event.getGui() instanceof GuiHopper) {
    		EntityPlayer player = Minecraft.getMinecraft().player;
    		event.setGui(new GuiLol("LOL"));
    		BijisMod.network.sendToServer(new GetMoney("foobar"));
    	}
    }
	@SubscribeEvent
	public static void keyPressed(KeyInputEvent event) {
		EntityPlayer player = Minecraft.getMinecraft().player;
		if(!player.isSneaking()) {
			if (BijisModClient.keyBindTest.isKeyDown()) {
				BijisMod.network2.sendToServer(new SitServer("foobar"));
			}
		}
	}
}
