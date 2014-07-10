package icac.impervium.server.networking.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import icac.impervium.server.networking.Packet;

public class PacketClientConnect extends Packet {

	private int[] digest;
	//TODO: Variant DataType.
	private boolean uuidFlag;
	private int[] uuid;
	private String username;
	private String species;
	private int[] shipworld;
	private String accountName;
	
	public PacketClientConnect() {
		uuid = new int[16];
	}
	
	@Override
	public Integer getID() {
		return 7;
	}

	@Override
	public void write(DataOutputStream dos) throws Exception {
		//Client->Server Packet
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//TODO: Read this packet.
	}

}
