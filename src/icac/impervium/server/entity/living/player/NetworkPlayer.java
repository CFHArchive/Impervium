package icac.impervium.server.entity.living.player;

import icac.impervium.server.Server;
import icac.impervium.server.logger.LogType;
import icac.impervium.server.networking.StarboundOutputStream;
import icac.impervium.server.networking.server.PacketProtocolVersion;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class NetworkPlayer {
	
	private Socket socket;
	private StarboundOutputStream sos;
	private DataInputStream dis;
	
	private String ip;
	private boolean isDisconnected = false;
	private Player p;
	
	public NetworkPlayer(Socket socket) {
		try {
			this.socket = socket;
			this.sos = new StarboundOutputStream(socket.getOutputStream());
			this.dis = new DataInputStream(socket.getInputStream());
			this.ip = socket.getRemoteSocketAddress().toString().split(":")[0];
			Server.logger.Log("Connection made from " + this.ip + "!", LogType.Debug);
			p = new Player(this);
			PacketProtocolVersion ppv = new PacketProtocolVersion(Server.version);
			ppv.write(sos);
			new Thread() {
				public void run() {
					listen();
				}
			}.start();
		} catch(Exception e) {
			Server.logger.Log(e);
		}
	}
		
	private void listen() {
		while(!isDisconnected) {
			try {
				if(dis.available() != 0) {
					byte id = dis.readByte();
					Server.logger.Log("Packet received. id: " + id, LogType.Debug);
					
				}
			} catch (IOException e) {
				Server.logger.Log(e.getCause());
				Server.logger.Log(e);
			}
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public StarboundOutputStream getDos() {
		return sos;
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