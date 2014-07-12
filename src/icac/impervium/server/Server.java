package icac.impervium.server;

import icac.impervium.server.entity.living.player.NetworkPlayer;
import icac.impervium.server.logger.Logger;

import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static Logger logger;
	
	private ServerSocket connection;
	public final static int version = 643;
	private final Integer port = 21025;
	private Boolean alive = false;
	
	public Server() {
		logger = new Logger();
	}
	
	public void start() {
		alive = true;
		
		logger.Log("Starting Impervium Server ");
		
		try {
			connection = new ServerSocket(port);
			new Thread() {
				public void run() {
					connect();
				}
			}.start();
    	} catch(Exception e) {
			logger.Log(e);
    	}
	}
	
	public void stop() {
		
	}
	
	private void connect() {
		while(alive) {
			try {
				Socket client = connection.accept();
				new NetworkPlayer(client);
			} catch(Exception e) {
				logger.Log(e);
	    	}
		}
	}
}