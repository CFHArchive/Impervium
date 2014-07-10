package icac.impervium.server.datatypes;

public class VLQ implements DataType {
	private long value;
	private byte[] bytes;
	
	public VLQ(byte[] bytes)
	{
		long value = 0;
	    for (int i = 0; i < bytes.length; i++)
	    {
	      int curByte = bytes[i] & 0xFF;
	      value = (value << 7) | (curByte & 0x7F);
	      if ((curByte & 0x80) == 0)
	        break;
	    }
	    this.bytes = bytes;
	    this.value = value;
	}
	public VLQ(long value)
	{
		int numRelevantBits = 64 - Long.numberOfLeadingZeros(value);
	    int numBytes = (numRelevantBits + 6) / 7;
	    if (numBytes == 0)
	      numBytes = 1;
	    byte[] bytes = new byte[numBytes];
	    for (int i = numBytes - 1; i >= 0; i--)
	    {
	      int curByte = (int)(value & 0x7F);
	      if (i != (numBytes - 1))
	        curByte |= 0x80;
	      bytes[i] = (byte)curByte;
	      value >>>= 7;
	    }
	    this.bytes = bytes;
		this.value = value;
	}
	
	public long getLong()
	{
		return value;
	}
	public byte[] getBytes() {
		return bytes;
	}
}
