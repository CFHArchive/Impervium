package icac.impervium.server.networking.client;

import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.networking.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class PacketHandshakeResponse extends Packet {

	private String claimResponse;
	private String passwordHash;
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)9);
	}

	@Override
	public void write(DataOutputStream dos) throws Exception {
		//Client->Server Packet
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//TODO: Read this packet
	}

}