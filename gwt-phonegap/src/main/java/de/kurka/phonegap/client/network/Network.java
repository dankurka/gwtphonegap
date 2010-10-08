/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.kurka.phonegap.client.network;

/**
 * The network object gives access to the device's cellular and wifi connection information.
 * @author Daniel Kurka
 *
 */
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

	/**
	 * Checks if a connection can be established with a specific domain.
	 * 
	 * <h1>Supported Platforms</h1>
	 * 
	 * <ul>
	 * 	<li>Android</li>
	 * 	<li>iPhone</li>
	 * </ul>
	 * @param options
	 * @param callback
	 */
	public native void isNetWorkReachable(NetworkReachableOptions options, NetworkReachableCallback callback)/*-{
		var myfunction = function(){
		};



		$wnd.callbackPhonegapNetworkReach = function(data){
		$wnd.callbackPhonegapNetworkReach = null;
		callback.@de.kurka.phonegap.client.network.NetworkReachableCallback::onSuccess(Lde/kurka/phonegap/client/network/NetworkReachable;)(data);
		};

		$wnd.callbackPhonegapNetworkReach.toString = function(){
		return "function callbackPhonegapNetworkReach() {  }";
		}


		var hostname = options.@de.kurka.phonegap.client.network.NetworkReachableOptions::getHostname()();
		var isIp = options.@de.kurka.phonegap.client.network.NetworkReachableOptions::isIpAddress()();



		var localOptions = {
		isIpAddress: isIp
		};



		$wnd.navigator.network.isReachable(hostname,$wnd.callbackPhonegapNetworkReach, localOptions);
	}-*/;

}
