package icac.impervium.server.networking.server;

import icac.impervium.server.datatypes.VLQ;
import icac.impervium.server.networking.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class PacketConnectionResponse extends Packet {

	private boolean success;
	private VLQ clientID;
	private String rejectionReason;
	private boolean celestialInfo;
	private int orbitalLevels;
	private int chunkSize;
	private int xyMin;
	private int xyMax;
	private int zMin;
	private int zMax;
	private VLQ sectorsNumber;
	private String sectorID;
	private String sectorName;
	private long sectorSeed;
	private String sectorPrefix;
	//TODO: Variant DataType
	
	public PacketConnectionResponse(boolean success, VLQ clientID, boolean celestrialInfo) {
		this.success = success;
		this.clientID = clientID;
		this.celestialInfo = celestrialInfo;
	}
	
	@Override
	public Integer getID() {
		return 1;
	}

	@Override
	public void write(DataOutputStream dos) throws Exception {
		//TODO: Write packet to stream.
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client Packet
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @param clientID the clientID to set
	 */
	public void setClientID(VLQ clientID) {
		this.clientID = clientID;
	}

	/**
	 * @param rejectionReason the rejectionReason to set
	 */
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	/**
	 * @param celestialInfo the celestialInfo to set
	 */
	public void setCelestialInfo(boolean celestialInfo) {
		this.celestialInfo = celestialInfo;
	}

	/**
	 * @param orbitalLevels the orbitalLevels to set
	 */
	public void setOrbitalLevels(int orbitalLevels) {
		this.orbitalLevels = orbitalLevels;
	}

	/**
	 * @param chunkSize the chunkSize to set
	 */
	public void setChunkSize(int chunkSize) {
		this.chunkSize = chunkSize;
	}

	/**
	 * @param xyMin the xyMin to set
	 */
	public void setXyMin(int xyMin) {
		this.xyMin = xyMin;
	}

	/**
	 * @param xyMax the xyMax to set
	 */
	public void setXyMax(int xyMax) {
		this.xyMax = xyMax;
	}

	/**
	 * @param zMin the zMin to set
	 */
	public void setzMin(int zMin) {
		this.zMin = zMin;
	}

	/**
	 * @param zMax the zMax to set
	 */
	public void setzMax(int zMax) {
		this.zMax = zMax;
	}

	/**
	 * @param sectorsNumber the sectorsNumber to set
	 */
	public void setSectorsNumber(VLQ sectorsNumber) {
		this.sectorsNumber = sectorsNumber;
	}

	/**
	 * @param sectorID the sectorID to set
	 */
	public void setSectorID(String sectorID) {
		this.sectorID = sectorID;
	}

	/**
	 * @param sectorName the sectorName to set
	 */
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	/**
	 * @param sectorSeed the sectorSeed to set
	 */
	public void setSectorSeed(long sectorSeed) {
		this.sectorSeed = sectorSeed;
	}

	/**
	 * @param sectorPrefix the sectorPrefix to set
	 */
	public void setSectorPrefix(String sectorPrefix) {
		this.sectorPrefix = sectorPrefix;
	}

}