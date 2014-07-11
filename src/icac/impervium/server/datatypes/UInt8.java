package icac.impervium.server.datatypes;

import icac.impervium.server.datatypes.exception.InvalidUIntException;

public class UInt8 extends UIntXX {
	public UInt8(byte[] bytes) throws InvalidUIntException
	{
		super(bytes, 1);
	}
	public UInt8(byte value)
	{
		super(value, 1);
	}
}
