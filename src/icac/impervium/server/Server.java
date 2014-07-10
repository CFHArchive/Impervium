package icac.impervium.server;


public class Server {
	
	public final Integer version = 639;
	private Boolean alive = false;
	
	public Server() {
		
	}
	
	public void start() {
		alive = true;
		
		try {
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
			
		}
	}
}