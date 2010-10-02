package de.kurka.phonegap.client.network;

public class NetworkReachableOptions {
	private boolean ipAddress;

	private String hostname;

	public NetworkReachableOptions() {

	}

	public boolean isIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(boolean ipAddress) {
		this.ipAddress = ipAddress;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getHostname() {
		return hostname;
	}
}
