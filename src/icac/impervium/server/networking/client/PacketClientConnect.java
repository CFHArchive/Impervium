package icac.impervium.server.networking.client;

import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.networking.IPacket;
import icac.impervium.server.networking.PacketPayload;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class PacketClientConnect implements IPacket {

	PacketPayload payload = new PacketPayload();
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
	public UInt8 getID() {
		return new UInt8((byte)7);
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
