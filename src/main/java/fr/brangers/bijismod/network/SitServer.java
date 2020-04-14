package fr.brangers.bijismod.network;

import fr.brangers.bijismod.util.SeatUtil;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SitServer implements IMessage {
	private String text;
	 
    public SitServer() { }
 
    public SitServer(String text) {
        this.text = text;
    }
	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		text = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		ByteBufUtils.writeUTF8String(buf, "Siting");
	}
	
	public static class Handler implements IMessageHandler <SitServer, IMessage> {
		 
        @Override
        public IMessage onMessage(SitServer message, MessageContext ctx) {
            System.out.println("Received");
            EntityPlayer player = ctx.getServerHandler().player;
            if(SeatUtil.sitOnBlock(player.world, player.posX, player.posY - 1, player.posZ, player, 1))
	        {
				BlockPos pos = new BlockPos(player.posX, player.posY - 1, player.posZ);
				Block block = player.world.getBlockState(pos).getBlock();
				player.world.updateComparatorOutputLevel(player.getPosition(), block);
	        }
            return null; // no response in this case
        }
    }
}
