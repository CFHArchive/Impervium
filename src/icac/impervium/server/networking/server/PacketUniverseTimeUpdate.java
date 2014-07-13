package icac.impervium.server.networking.server;

import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.datatypes.sVLQ;
import icac.impervium.server.networking.IPacket;
import icac.impervium.server.networking.PacketPayload;
import icac.impervium.server.networking.StarboundOutputStream;

import java.io.DataInputStream;

public class PacketUniverseTimeUpdate implements IPacket {

	PacketPayload payload = new PacketPayload();
	private sVLQ time;
	
	public PacketUniverseTimeUpdate(long time) {
		this.time = new sVLQ(time);
		this.payload.add(this.time);
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)5);
	}

	@Override
	public void write(StarboundOutputStream sos) throws Exception {
		sos.writeUInt8(this.getID());
		sos.writePayload(this.payload);
		sos.writeSVLQ(this.time);
		sos.flush();
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client Packet.
	}

}
