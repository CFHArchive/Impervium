package icac.impervium.server.networking.server;

import icac.impervium.server.Utils;
import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.datatypes.VLQString;
import icac.impervium.server.networking.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class PacketHandshakeChallenge extends Packet {

	private String claim;
	private String salt;
	private int rounds;
	
	public PacketHandshakeChallenge(String claim, int rounds) {
		this.claim = claim;
		this.salt = Utils.generateSalt();
		this.rounds = rounds;
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)3);
	}

	@Override
	public void write(DataOutputStream dos) throws Exception {
		dos.write(new VLQString(this.claim).getBytes());
		dos.write(new VLQString(this.salt).getBytes());
		dos.writeInt(this.rounds);
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client Packet
	}
}