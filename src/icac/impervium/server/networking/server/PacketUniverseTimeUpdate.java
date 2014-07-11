package icac.impervium.server.networking.server;

import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.datatypes.sVLQ;
import icac.impervium.server.networking.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class PacketUniverseTimeUpdate extends Packet {

	private sVLQ time;
	
	public PacketUniverseTimeUpdate(long time) {
		this.time = new sVLQ(time);
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)5);
	}

	@Override
	public void write(DataOutputStream dos) throws Exception {
		dos.write(this.time.getBytes());
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client Packet.
	}

}
