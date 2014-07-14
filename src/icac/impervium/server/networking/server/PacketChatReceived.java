package icac.impervium.server.networking.server;

import icac.impervium.server.datatypes.UInt32;
import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.networking.IPacket;
import icac.impervium.server.networking.PacketPayload;
import icac.impervium.server.networking.StarboundInputStream;
import icac.impervium.server.networking.StarboundOutputStream;

public class PacketChatReceived implements IPacket {

	PacketPayload payload = new PacketPayload();
	private UInt8 channel;
	private String world;
	private UInt32 clientID;
	private String sender;
	private String message;
	
	public PacketChatReceived(byte channel, String world, int id, String sender, String message) {
		this.channel = new UInt8(channel);
		this.world = world;
		this.clientID = new UInt32(id);
		this.sender = sender;
		this.message = message;
		this.payload.add(this.channel.getBytes());
		this.payload.add(this.world);
		this.payload.add(this.clientID);
		this.payload.add(this.sender);
		this.payload.add(this.message);
	}

	@Override
	public UInt8 getID() {
		return new UInt8((byte)4);
	}

	@Override
	public void write(StarboundOutputStream sos) throws Exception {
		sos.writeUInt8(this.getID());
		sos.writePayload(this.payload);
		sos.writeUInt8(this.channel);
		sos.writeVLQString(this.world);
		sos.writeUInt32(this.clientID);
		sos.writeVLQString(this.sender);
		sos.writeVLQString(this.message);
		sos.flush();
	}

	@Override
	public void read(StarboundInputStream sis) throws Exception {
		//Server->Client
	}

}
