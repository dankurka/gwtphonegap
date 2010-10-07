package de.kurka.phonegap.client.network;

import com.google.gwt.core.client.JavaScriptObject;

public final class NetworkReachable extends JavaScriptObject {

	protected NetworkReachable() {

	}

	public native String getHostname()/*-{
		return this.hostName;
	}-*/;

	public native String getIpAddress()/*-{
		return this.ipAddress;
	}-*/;

	public native int getRemoteHostStatus()/*-{
		return this.remoteHostStatus;
	}-*/;

	public native int getInternetConnectionStatus()/*-{
		return this.internetConnectionStatus;
	}-*/;

	public native int getLocalWiFiConnectionStatus()/*-{
		return this.localWiFiConnectionStatus;
	}-*/;

}
