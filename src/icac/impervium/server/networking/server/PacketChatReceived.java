package icac.impervium.server.networking.server;

import icac.impervium.server.datatypes.UInt32;
import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.datatypes.VLQString;
import icac.impervium.server.datatypes.sVLQ;
import icac.impervium.server.networking.IPacket;
import icac.impervium.server.networking.PacketPayload;

import java.io.DataInputStream;
import java.io.DataOutputStream;

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
	public void write(DataOutputStream dos) throws Exception {
		dos.write(this.getID().getBytes());
		dos.write(new sVLQ(this.payload.getBytes().length).getBytes());
		dos.write(this.channel.getBytes());
		dos.write(new VLQString(this.world).getBytes());
		dos.write(this.clientID.getBytes());
		dos.write(new VLQString(this.sender).getBytes());
		dos.write(new VLQString(this.message).getBytes());
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client
	}

}
