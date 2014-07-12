package icac.impervium.server;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Random;

public class Utils {
	
	public static String generateSalt() {
		StringBuilder builder = new StringBuilder();
		Random random = new Random();

		final char[] chars = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz+/1234567890".toCharArray();
		
		for(int i = 0; i < 32; i++) {
			builder.append(chars[random.nextInt(chars.length)]);
		}
		return builder.toString();
	}
	
	public static byte[] readByteArray(DataInputStream stream) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int length = stream.available();
		
		byte[] bytes = new byte[length];
		
		int read = 0;
		
		while ((read = stream.read(bytes, 0, bytes.length)) != -1) {
			buffer.write(bytes, 0, read);
		}
		byte[] toReturn = buffer.toByteArray();
		buffer.close();
		return toReturn;
	}
	
	public static byte[] getPrimitiveArray(Byte[] value) {
		byte[] bytes = new byte[value.length];
		for(int i = 0; i < value.length; i++) {
			bytes[i] = value[i];
		}
		return bytes;
	}
}