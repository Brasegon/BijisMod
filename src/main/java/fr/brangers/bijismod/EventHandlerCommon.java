package fr.brangers.bijismod;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(modid = BijisMod.MODID)
public class EventHandlerCommon
{
    /*
        * Affiche un message de bienvenue au joueur lorsqu'il rejoint la partie
        */
    @SubscribeEvent
    public static void onGuiOpen(GuiOpenEvent event)
    {
    	if (event.getGui() instanceof GuiHopper) {
    		
    		System.out.println("Block Cassé");
    		BijisMod.network.sendToServer(new MyMessage("foobar"));
//    		ByteArrayDataOutput out = ByteStreams.newDataOutput();
//    		out.writeInt(10);
//    		NetHandlerPlayClient nhpc = Minecraft.getMinecraft().getConnection();
//    		CPacketCustomPayload packet = new CPacketCustomPayload("test:init", new PacketBuffer(Unpooled.copiedBuffer(out.toByteArray())));
//    		nhpc.sendPacket(packet);
    	}
    }
}
