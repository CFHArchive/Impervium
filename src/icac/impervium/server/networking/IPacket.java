package icac.impervium.server.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import icac.impervium.server.datatypes.UInt8;

public interface IPacket {
	UInt8 getID();
	public void write(DataOutputStream dos) throws Exception;
	public void read(DataInputStream dis) throws Exception;
}