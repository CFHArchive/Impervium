package icac.impervium.server.entity.living.player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NetworkPlayer {
	
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	
	private String ip;
	private boolean isDisconnected = false;
	private Player p;
	
	public NetworkPlayer(Socket socket) {
		try {
			this.socket = socket;
			this.dos = new DataOutputStream(socket.getOutputStream());
			this.dis = new DataInputStream(socket.getInputStream());
			this.ip = socket.getRemoteSocketAddress().toString().split(":")[0];
			System.out.println("Connection made from " + this.ip + "!");
			p = new Player(this);
			new Thread() {
				public void run() {
					listen();
				}
			}.start();
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
		
	private void listen() {
		while(!isDisconnected) {
			try {
				if(dis.available() != 0) {
					//TODO: Read packets.
				}
			} catch (IOException e) {
				System.out.println(e.getStackTrace());
			}
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public DataOutputStream getDos() {
		return dos;
	}

	public DataInputStream getDis() {
		return dis;
	}

	public String getIp() {
		return ip;
	}

	public boolean isDisconnected() {
		return isDisconnected;
	}

	public Player getP() {
		return p;
	}
}