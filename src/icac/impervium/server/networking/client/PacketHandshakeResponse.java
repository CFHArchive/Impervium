package icac.impervium.server.networking.client;

import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.networking.IPacket;
import icac.impervium.server.networking.PacketPayload;
import icac.impervium.server.networking.StarboundInputStream;
import icac.impervium.server.networking.StarboundOutputStream;

public class PacketHandshakeResponse implements IPacket {

	PacketPayload payload = new PacketPayload();
	private String claimResponse;
	private String passwordHash;
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)9);
	}

	@Override
	public void write(StarboundOutputStream sos) throws Exception {
		//Client->Server Packet
	}

	@Override
	public void read(StarboundInputStream sis) throws Exception {
		//TODO: Read this packet
	}

}