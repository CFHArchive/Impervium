package icac.impervium.server.networking;

import icac.impervium.server.datatypes.UInt8;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public abstract class Packet {
	
	public Packet() {
		
	}
	
	public abstract UInt8 getID();
	public abstract void write(DataOutputStream dos) throws Exception;
	public abstract void read(DataInputStream dis) throws Exception;
}