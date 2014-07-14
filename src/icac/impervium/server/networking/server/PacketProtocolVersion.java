package icac.impervium.server.networking.server;

import icac.impervium.server.Server;
import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.logger.LogType;
import icac.impervium.server.networking.IPacket;
import icac.impervium.server.networking.PacketPayload;
import icac.impervium.server.networking.StarboundInputStream;
import icac.impervium.server.networking.StarboundOutputStream;

public class PacketProtocolVersion implements IPacket {

	public PacketPayload payload = new PacketPayload();
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
	public void write(StarboundOutputStream sos) throws Exception {
		Server.logger.Log("Sending protocol version. Version: " + this.protocolVersion, LogType.Debug);
		sos.writeUInt8(this.getID());
		sos.writePayload(this.payload);
		sos.writeInt(this.protocolVersion);
		sos.flush();
	}

	@Override
	public void read(StarboundInputStream sis) throws Exception {
		//Server->Client Packet
	}

}