package icac.impervium.server.entity.living.player;

import icac.impervium.server.Server;
import icac.impervium.server.logger.LogType;
import icac.impervium.server.networking.StarboundInputStream;
import icac.impervium.server.networking.StarboundOutputStream;
import icac.impervium.server.networking.server.PacketProtocolVersion;

import java.io.IOException;
import java.net.Socket;

public class NetworkPlayer {
	
	private Socket socket;
	private StarboundOutputStream sos;
	private StarboundInputStream sis;
	
	private String ip;
	private boolean isDisconnected = false;
	private Player p;
	
	public NetworkPlayer(Socket socket) {
		try {
			this.socket = socket;
			this.sos = new StarboundOutputStream(socket.getOutputStream());
			this.sis = new StarboundInputStream(socket.getInputStream());
			this.ip = socket.getRemoteSocketAddress().toString().split(":")[0];
			Server.logger.Log("Connection made from " + this.ip + "!", LogType.Debug);
			p = new Player(this);
			PacketProtocolVersion ppv = new PacketProtocolVersion(Server.version);
			try {
				ppv.write(this.sos);
				Server.logger.Log("Sent Protocol Version.", LogType.Debug);
			} catch (Exception e) {
				Server.logger.Log(e);
			}
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
		Server.logger.Log("Listen", LogType.Debug);
		while(!isDisconnected) {
			try {
				if(sis.available() != 0) {
					byte id = sis.readByte();
					Server.logger.Log("Packet received. id: " + id, LogType.Debug);
					
				}
			} catch (IOException e) {
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

	public StarboundInputStream getDis() {
		return sis;
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