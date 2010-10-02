package de.kurka.phonegap.client.network;

public class Network {

	public static final int NETWORK_STATUS_NOT_REACHABLE = 0;
	public static final int NETWORK_STATUS_REACHABLE_VIA_CARRIER_DATA_NETWORK = 1;
	public static final int NETWORK_STATUS_REACHABLE_VIA_WIFI_NETWORK = 2;

	public native boolean isAvailable() /*-{
		if(!(typeof($wnd.navigator.network) == "undefined"))
		{
		return true;
		}
		return false;
	}-*/;

	public native void isNetWorkReachable(NetworkReachableOptions options, NetworkReachableCallback callback)/*-{
		var successCallback = function(data){
		callback.@de.kurka.phonegap.client.network.NetworkReachableCallback::onSuccess(I)(data);
		};


		var hostname = options.@de.kurka.phonegap.client.network.NetworkReachableOptions::getHostname()();
		var isIp = options.@de.kurka.phonegap.client.network.NetworkReachableOptions::isIpAddress()();

		var localOptions = {
		isIpAddress: isIp
		};

		$wnd.navigator.network.isReachable(hostname, successCallback, localOptions);
	}-*/;

}
