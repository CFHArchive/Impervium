package icac.impervium.server.networking.server;

import icac.impervium.server.datatypes.UInt32;
import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.networking.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class PacketProtocolVersion extends Packet {
	
	private UInt32 protocolVersion;
	
	public PacketProtocolVersion(int protocolVersion) {
		this.protocolVersion = new UInt32(protocolVersion);
	}
	
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)0);
	}

	@Override
	public void write(DataOutputStream dos) throws Exception {
		dos.write(this.protocolVersion.getBytes());
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client Packet
	}

}