package icac.impervium.server.networking.server;

import icac.impervium.server.Server;
import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.datatypes.sVLQ;
import icac.impervium.server.logger.LogType;
import icac.impervium.server.networking.IPacket;
import icac.impervium.server.networking.PacketPayload;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class PacketProtocolVersion implements IPacket {

	PacketPayload payload = new PacketPayload();
	private int protocolVersion;
	
	public PacketProtocolVersion(int protocolVersion) {
		this.protocolVersion = protocolVersion;
		payload.add(this.protocolVersion);
	}
	
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)0);
	}

	@Override
	public void write(DataOutputStream dos) throws Exception {
		Server.logger.Log("Sending protocol version. Version: " + this.protocolVersion, LogType.Debug);
		dos.write(this.getID().getBytes());
		dos.write(new sVLQ(this.payload.getBytes().length).getBytes());
		dos.writeInt(this.protocolVersion);
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client Packet
	}

}