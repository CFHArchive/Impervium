package icac.impervium.server;

import icac.impervium.server.entity.living.player.NetworkPlayer;

import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	
	private ServerSocket connection;
	public final Integer version = 639;
	private final Integer port = 21025;
	private Boolean alive = false;
	
	public Server() {
		
	}
	
	public void start() {
		alive = true;
		
		try {
			connection = new ServerSocket(port);
    		new Thread() {
				public void run() {
					connect();
				}
			}.start();
    	} catch(Exception e) {
    		System.out.println(e.getStackTrace());
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
	    		System.out.println(e.getStackTrace());
	    	}
		}
	}
}