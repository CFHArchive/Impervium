package icac.impervium.server.networking.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import icac.impervium.server.networking.Packet;

public class HandshakeChallengePacket extends Packet {

	private String claim;
	private String salt;
	private int rounds;
	
	public HandshakeChallengePacket(String claim, int rounds) {
		this.claim = claim;
		//TODO: Base64 Encoder to encode salt
		this.rounds = rounds;
	}
	
	@Override
	public Integer getID() {
		return 3;
	}

	@Override
	public void write(DataOutputStream dos) throws Exception {
		//TODO: Write packet to stream.
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client Packet
	}
}