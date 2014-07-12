package icac.impervium.server.networking.server;

import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.datatypes.sVLQ;
import icac.impervium.server.networking.IPacket;
import icac.impervium.server.networking.PacketPayload;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class PacketDisconnectResponse implements IPacket {

	PacketPayload payload = new PacketPayload();
	private UInt8 unknown;
	
	public PacketDisconnectResponse(byte unknown) {
		this.unknown = new UInt8(unknown);
		this.payload.add(this.unknown);
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)2);
	}

	@Override
	public void write(DataOutputStream dos) throws Exception {
		dos.write(this.getID().getBytes());
		dos.write(new sVLQ(this.payload.getBytes().length).getBytes());
		dos.write(this.unknown.getBytes());
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client Packet.
	}

}
