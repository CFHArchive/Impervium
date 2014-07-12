package icac.impervium.server.logger;

public enum LogType {
	Debug("DEBUG"),
	ERROR("ERROR"),
	INFO("INFO"),
	PLUGIN("PLUGIN"),
	WARN("WARNING");
	
	private String prefix;
	private LogType(String prefix) {
		this.prefix = prefix;
	}
	
	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}
}
