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
 * The network object gives access to the device's cellular and wifi connection
 * information.
 * 
 * @author Daniel Kurka
 * 
 */
public class NetworkMobileImpl implements Network {

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.network.Network#isNetWorkReachable(de.kurka.phonegap.client.network.NetworkReachableOptions, de.kurka.phonegap.client.network.NetworkReachableCallback)
	 */
	@Override
	public native void isNetWorkReachable(NetworkReachableOptions options, NetworkReachableCallback callback)/*-{

		var func = function(data) {
			callback.@de.kurka.phonegap.client.network.NetworkReachableCallback::onSuccess(I)(data);
		};

		var hostname = options.@de.kurka.phonegap.client.network.NetworkReachableOptions::getHostname()();
		var isIp = options.@de.kurka.phonegap.client.network.NetworkReachableOptions::isIpAddress()();

		var localOptions = {
			isIpAddress : isIp
		};

		$wnd.navigator.network.isReachable(hostname, func, localOptions);
	}-*/;

}
