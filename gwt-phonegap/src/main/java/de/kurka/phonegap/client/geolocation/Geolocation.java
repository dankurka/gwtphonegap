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
package de.kurka.phonegap.client.geolocation;

/**
 * 
 * Geolocation provides location information for the device, such as latitude and longitude. Common sources of location information include Global Positioning System (GPS) and location inferred from network signals such as IP address, RFID, WiFi and Bluetooth MAC addresses, and GSM/CDMA cell IDs. No guarantee is given that the API returns the device's actual location.
 * 
 * This API is based on the W3C Geo location API Specification. Some devices already provide an implementation of this spec. For those devices, the built-in support is used instead of replacing it with PhoneGap's implementation. For devices that don't have geolocation support, PhoneGap's implementation should be compatible with the W3C specification.
 * 
 * @author Daniel Kurka
 *
 */
public class Geolocation {

	/**
	 * is the geolocation module available
	 * @return true if it is available
	 */
	public native boolean isAvailable() /*-{
		if(!(typeof($wnd.navigator.geolocation) == "undefined"))
		{
		return true;
		}
		return false;
	}-*/;

	/**
	 * calculates the device's current position as a Position object.
	 * 
	 * Function geolocation.getCurrentPositon is an asynchronous function. It returns the device's current position to the geolocationSuccess callback with a Position object as the parameter. If there is an error, the geolocationError callback is invoked with a PositionError object.
	 * 
	 * <h1>Supported Platforms</h1>
	 * 
	 * <ul>
	 * 	<li>Android</li>
	 * 	<li>BlackBerry</li>
	 * 	<li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * 	<li>iPhone</li>
	 * </ul>
	 * 
	 * @param options
	 * @param callback
	 */
	public native void getCurrentPosition(GeolocationCallback callback)/*-{
		var successCallback = function(data){
		callback.@de.kurka.phonegap.client.geolocation.GeolocationCallback::onSuccess(Lde/kurka/phonegap/client/geolocation/Position;)(data);
		};

		var errorCallback = function(){
		callback.@de.kurka.phonegap.client.geolocation.GeolocationCallback::onFailure(Lde/kurka/phonegap/client/geolocation/PositionError;)(error);
		};

		$wnd.navigator.geolocation.getCurrentPosition(successCallback, errorCallback);
	}-*/;

	/**
	 * Watches for changes to the device's current position.
	 * 
	 * Function geolocation.watchPosition is an asynchronous function. It returns the device's current position when a change in position has been detected. When the device has retrieved a new location, the geolocationSuccess callback is invoked with a Position object as the parameter. If there is an error, the geolocationError callback is invoked with a PositionError object.
	 * 
	 * <ul>
	 * 	<li>Android</li>
	 * 	<li>BlackBerry (OS 4.6)</li>
	 * 	<li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * 	<li>iPhone</li>
	 * </ul>
	 * 
	 * @param options
	 * @param callback
	 * @return a {@link GeolocationWatcher} that references the watch position interval. The {@link GeolocationWatcher} can be used with {@link Geolocation#clearWatch(GeolocationWatcher)} to stop watching for changes in position.
	 */
	public native GeolocationWatcher watchPosition(GeolocationOptions options, GeolocationCallback callback)/*-{
		var successCallback = function(data){

		callback.@de.kurka.phonegap.client.geolocation.GeolocationCallback::onSuccess(Lde/kurka/phonegap/client/geolocation/Position;)(data);
		};

		var errorCallback = function(error){
		callback.@de.kurka.phonegap.client.geolocation.GeolocationCallback::onFailure(Lde/kurka/phonegap/client/geolocation/PositionError;)(error);
		};



		var localOptions = {
		};

		localOptions.frequency = options.@de.kurka.phonegap.client.geolocation.GeolocationOptions::getFrequency()();
		localOptions.enableHighAccuracy = options.@de.kurka.phonegap.client.geolocation.GeolocationOptions::isEnableHighAccuracy();
		var maxage = options.@de.kurka.phonegap.client.geolocation.GeolocationOptions::getMaximumAge()();
		if(maxage > 0)
		{
		localOptions.maximumAge = maxage;
		}

		var timeout = options.@de.kurka.phonegap.client.geolocation.GeolocationOptions::getTimeout()();
		if(timeout > 0)
		{
		localOptions.timeout = timeout;
		}


		return $wnd.navigator.geolocation.watchPosition(successCallback, errorCallback, localOptions);
	}-*/;

	/**
	 * top watching for changes to the device's location referenced by the {@link GeolocationWatcher} parameter.
	 * 
	 * <ul>
	 * 	<li>Android</li>
	 * 	<li>BlackBerry (OS 4.6)</li>
	 * 	<li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * 	<li>iPhone</li>
	 * </ul>
	 * 
	 * @param watcher
	 */
	public native void clearWatch(GeolocationWatcher watcher) /*-{
		$wnd.navigator.geolocation.clearWatch(watcher);
	}-*/;

}
