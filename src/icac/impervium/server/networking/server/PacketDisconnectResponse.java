package icac.impervium.server.networking.server;

import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.networking.IPacket;
import icac.impervium.server.networking.PacketPayload;
import icac.impervium.server.networking.StarboundOutputStream;

import java.io.DataInputStream;

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
	public void write(StarboundOutputStream sos) throws Exception {
		sos.writeUInt8(this.getID());
		sos.writePayload(this.payload);
		sos.writeUInt8(this.unknown);
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client Packet.
	}

}
