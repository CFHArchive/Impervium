package icac.impervium.server.networking.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import icac.impervium.server.networking.Packet;

public class PacketProtocolVersion extends Packet {

	@Override
	public Integer getID() {
		return 0;
	}

	@Override
	public void write(DataOutputStream dos) throws Exception {
		//TODO: Print UInt32 of Server-Supported Protocol Version
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client Packet
	}

}