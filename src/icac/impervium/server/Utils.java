package icac.impervium.server;

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
}