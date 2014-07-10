package icac.impervium.server.entity.living.player;

public class Player {
	
	private NetworkPlayer netPlayer;
	
	private String username;
	private String accountName;
	private String species;
	
	public Player(NetworkPlayer netPlayer) {
		this.netPlayer = netPlayer;
	}
	
	public NetworkPlayer getNetPlayer() {
		return netPlayer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
}