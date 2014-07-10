package icac.impervium.server.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public abstract class Packet {
	
	public Packet() {
		
	}
	
	public abstract Integer getID();
	public abstract void write(DataOutputStream dos) throws Exception;
	public abstract void read(DataInputStream dis) throws Exception;
}