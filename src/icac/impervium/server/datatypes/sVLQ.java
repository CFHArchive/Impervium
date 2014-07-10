package icac.impervium.server.datatypes;

public class sVLQ implements DataType {
	private long value;
	private byte[] bytes;
	
	public sVLQ(byte[] bytes)
	{	
		long value = 0;
		
	    for (int i = 0; i < bytes.length; i++)
	    {
	      int curByte = bytes[i] & 0xFF;
	      value = (value << 7) | (curByte & 0x7F);
	      if ((curByte & 0x80) == 0)
	        break;
	    }
	    
	    value = (value + 1)/2;
	    
	    this.bytes = bytes;
	    this.value = value;
	}
	public sVLQ(long value)
	{
		// signed algorithm is *2-1
		value = value * 2 - 1;
		
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
