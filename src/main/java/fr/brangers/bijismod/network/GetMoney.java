package fr.brangers.bijismod.network;

import fr.brangers.bijismod.BijisMod;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class GetMoney implements IMessage{
	
	private String text;
	 
    public GetMoney() { }
 
    public GetMoney(String text) {
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
		ByteBufUtils.writeUTF8String(buf, "Get Money");
	}
	
	public static class Handler implements IMessageHandler <GetMoney, IMessage> {
		 
        @Override
        public IMessage onMessage(GetMoney message, MessageContext ctx) {
            System.out.println(String.format("Received %s", message.text));
            BijisMod.money = message.text;
            return null; // no response in this case
        }
    }

}
