package icac.impervium.server.logger;

import icac.impervium.server.Server;

import java.io.PrintStream;

public class ImperviumPrintStream extends PrintStream {

	public ImperviumPrintStream(PrintStream stream) {
		super(stream);
	}
	
	@Override
	public void println(String value) {
		String message = Server.logger.buildPrefix(LogType.INFO) + value;
		super.println(message);
		Server.logger.writeTofile(message);
	}
}