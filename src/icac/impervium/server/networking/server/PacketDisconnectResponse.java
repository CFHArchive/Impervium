package icac.impervium.server.networking.server;

import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.networking.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class PacketDisconnectResponse extends Packet {

	private UInt8 unknown;
	
	public PacketDisconnectResponse(byte unknown) {
		this.unknown = new UInt8(unknown);
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)2);
	}

	@Override
	public void write(DataOutputStream dos) throws Exception {
		dos.write(this.unknown.getBytes());
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client Packet.
	}

}
