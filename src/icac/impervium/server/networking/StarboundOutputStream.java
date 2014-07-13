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
import icac.impervium.server.datatypes.exception.VLQNegativeException;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class StarboundOutputStream extends DataOutputStream {

	public StarboundOutputStream(OutputStream out) {
		super(out);
	}
	
	public void writePayload(PacketPayload write) {
		try {
			this.write(new sVLQ(write.getBytes().length).getBytes());
		} catch (IOException e) {
			Server.logger.Log(e);
		}
	}
	
	public void writeBool(Bool write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Server.logger.Log(e);
		}
	}
	
	public void writeDubble(Dubble write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Server.logger.Log(e);
		}
	}
	
	public void writeSVLQ(sVLQ write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Server.logger.Log(e);
		}
	}
	
	public void writeUInt8(UInt8 write) {
		try {
			this.out.write(write.getBytes());
		} catch (IOException e) {
			Server.logger.Log(e);
		}
	}
	
	public void writeUInt8Array(UInt8[] write) {
		for(UInt8 value : write) {
			this.writeUInt8(value);
		}
	}
	
	public void writeUInt16(UInt16 write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Server.logger.Log(e);
		}
	}
	
	public void writeUInt32(UInt32 write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Server.logger.Log(e);
		}
	}
	
	public void writeUInt64(UInt64 write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Server.logger.Log(e);
		}
	}
	
	public void writeVariant(Variant write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Server.logger.Log(e);
		}
	}
	
	public void writeVLQ(VLQ write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Server.logger.Log(e);
		}
	}
	
	public void writeVLQString(VLQString write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Server.logger.Log(e);
		}
	}
	
	public void writeVLQString(String write) {
		try {
			this.writeVLQString(new VLQString(write));
		} catch (VLQNegativeException e) {
			Server.logger.Log(e);
		} catch (UnsupportedEncodingException e) {
			Server.logger.Log(e);
		}
	}
}