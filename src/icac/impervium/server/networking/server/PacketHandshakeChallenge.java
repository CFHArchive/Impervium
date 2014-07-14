package icac.impervium.server.networking.server;

import icac.impervium.server.Utils;
import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.networking.IPacket;
import icac.impervium.server.networking.PacketPayload;
import icac.impervium.server.networking.StarboundInputStream;
import icac.impervium.server.networking.StarboundOutputStream;

public class PacketHandshakeChallenge implements IPacket {

	PacketPayload payload = new PacketPayload();
	private String claim;
	private String salt;
	private int rounds;
	
	public PacketHandshakeChallenge(String claim, int rounds) {
		this.claim = claim;
		this.salt = Utils.generateSalt();
		this.rounds = rounds;
		this.payload.add(this.claim);
		this.payload.add(this.salt);
		this.payload.add(this.rounds);
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)3);
	}

	@Override
	public void write(StarboundOutputStream sos) throws Exception {
		sos.writeUInt8(this.getID());
		sos.writePayload(this.payload);
		sos.writeVLQString(this.claim);
		sos.writeVLQString(this.salt);
		sos.writeInt(this.rounds);
		sos.flush();
	}

	@Override
	public void read(StarboundInputStream sis) throws Exception {
		//Server->Client Packet
	}
}