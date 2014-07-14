package icac.impervium.server.networking;

import icac.impervium.server.Server;
import icac.impervium.server.datatypes.Bool;
import icac.impervium.server.datatypes.Dubble;
import icac.impervium.server.datatypes.UInt16;
import icac.impervium.server.datatypes.UInt32;
import icac.impervium.server.datatypes.UInt64;
import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.datatypes.VLQ;
import icac.impervium.server.datatypes.VLQString;
import icac.impervium.server.datatypes.Variant;
import icac.impervium.server.datatypes.sVLQ;
import icac.impervium.server.datatypes.exception.InvalidUIntException;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StarboundInputStream extends DataInputStream {

	public StarboundInputStream(InputStream in) {
		super(in);
	}
	
	public Bool readBool() {
		byte[] bytes = new byte[1];
		try {
			bytes[0] = this.readByte();
		} catch (IOException e) {
			Server.logger.Log(e);
		}
		return new Bool(bytes);
	}
	
	public Dubble readDubble() {
		byte[] bytes = new byte[8];
		for(int i = 0; i < 8; i++) {
			try {
				bytes[i] = this.readByte();
			} catch (IOException e) {
				Server.logger.Log(e);
			}
		}
		return new Dubble(bytes);
	}
	
	public sVLQ readSVLQ() {
		//TODO: Create this method.
		return null;
	}
	
	public UInt8 readUInt8() {
		byte[] bytes = new byte[1];
		try {
			bytes[0] = this.readByte();
		} catch (IOException e) {
			Server.logger.Log(e);
		}
		
		UInt8 value = new UInt8((byte)0);
		try {
			value = new UInt8(bytes);
		} catch (InvalidUIntException e) {
			Server.logger.Log(e);
		}
		return value;
	}
	
	public UInt16 readUInt16() {
		byte[] bytes = new byte[2];
		try {
			bytes[0] = this.readByte();
			bytes[1] = this.readByte();
		} catch (IOException e) {
			Server.logger.Log(e);
		}
		
		UInt16 value = new UInt16((byte)0);
		try {
			value = new UInt16(bytes);
		} catch (InvalidUIntException e) {
			Server.logger.Log(e);
		}
		return value;
	}
	
	public UInt32 readUInt32() {
		byte[] bytes = new byte[4];
		for(int i = 0; i < 4; i++) {
			try {
				bytes[i] = this.readByte();
			} catch (IOException e) {
				Server.logger.Log(e);
			}
		}
		
		UInt32 value = new UInt32((byte)0);
		try {
			value = new UInt32(bytes);
		} catch (InvalidUIntException e) {
			Server.logger.Log(e);
		}
		return value;
	}
	
	public UInt64 readUInt64() {
		byte[] bytes = new byte[8];
		for(int i = 0; i < 8; i++) {
			try {
				bytes[i] = this.readByte();
			} catch (IOException e) {
				Server.logger.Log(e);
			}
		}
		
		UInt64 value = new UInt64((byte)0);
		try {
			value = new UInt64(bytes);
		} catch (InvalidUIntException e) {
			Server.logger.Log(e);
		}
		return value;
	}
	
	public Variant readVariant() {
		//TODO: Create this method.
		return null;
	}
	
	public VLQ readVLQ() {
		//TODO: Create this method.
		return null;
	}
	
	public VLQString readVLQString() {
		//TODO: Create this method.
		return null;
	}
}