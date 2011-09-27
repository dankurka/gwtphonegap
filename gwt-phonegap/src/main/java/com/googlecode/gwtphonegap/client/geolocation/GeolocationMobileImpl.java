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
package com.googlecode.gwtphonegap.client.geolocation;

/**
 * 
 * Geolocation provides location information for the device, such as latitude
 * and longitude. Common sources of location information include Global
 * Positioning System (GPS) and location inferred from network signals such as
 * IP address, RFID, WiFi and Bluetooth MAC addresses, and GSM/CDMA cell IDs. No
 * guarantee is given that the API returns the device's actual location.
 * 
 * This API is based on the W3C Geo location API Specification. Some devices
 * already provide an implementation of this spec. For those devices, the
 * built-in support is used instead of replacing it with PhoneGap's
 * implementation. For devices that don't have geolocation support, PhoneGap's
 * implementation should be compatible with the W3C specification.
 * 
 * @author Daniel Kurka
 * 
 */
public class GeolocationMobileImpl implements Geolocation {

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.client.geolocation.Geolocation#getCurrentPosition(com.googlecode.gwtphonegap.client.geolocation.GeolocationCallback)
	 */
	@Override
	public native void getCurrentPosition(GeolocationCallback callback)/*-{
		var successCallback = function(data) {
			callback.@com.googlecode.gwtphonegap.client.geolocation.GeolocationCallback::onSuccess(Lcom/googlecode/gwtphonegap/client/geolocation/Position;)(data);
		};

		var errorCallback = function() {
			callback.@com.googlecode.gwtphonegap.client.geolocation.GeolocationCallback::onFailure(Lcom/googlecode/gwtphonegap/client/geolocation/PositionError;)(error);
		};

		$wnd.navigator.geolocation.getCurrentPosition($entry(successCallback),
				$entry(errorCallback));
	}-*/;

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.client.geolocation.Geolocation#watchPosition(com.googlecode.gwtphonegap.client.geolocation.GeolocationOptions, com.googlecode.gwtphonegap.client.geolocation.GeolocationCallback)
	 */
	@Override
	public native GeolocationWatcher watchPosition(GeolocationOptions options, GeolocationCallback callback)/*-{
		var successCallback = function(data) {

			callback.@com.googlecode.gwtphonegap.client.geolocation.GeolocationCallback::onSuccess(Lcom/googlecode/gwtphonegap/client/geolocation/Position;)(data);
		};

		var errorCallback = function(error) {
			callback.@com.googlecode.gwtphonegap.client.geolocation.GeolocationCallback::onFailure(Lcom/googlecode/gwtphonegap/client/geolocation/PositionError;)(error);
		};

		var localOptions = {};

		localOptions.frequency = options.@com.googlecode.gwtphonegap.client.geolocation.GeolocationOptions::getFrequency()();
		localOptions.enableHighAccuracy = options
				.@com.googlecode.gwtphonegap.client.geolocation.GeolocationOptions::isEnableHighAccuracy();
		var maxage = options.@com.googlecode.gwtphonegap.client.geolocation.GeolocationOptions::getMaximumAge()();
		if (maxage > 0) {
			localOptions.maximumAge = maxage;
		}

		var timeout = options.@com.googlecode.gwtphonegap.client.geolocation.GeolocationOptions::getTimeout()();
		if (timeout > 0) {
			localOptions.timeout = timeout;
		}

		var watcherId = $wnd.navigator.geolocation.watchPosition(
				$entry(successCallback), $entry(errorCallback), localOptions);

		var watcher = {
			id : watcherId
		};

		return watcher;
	}-*/;

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.client.geolocation.Geolocation#clearWatch(com.googlecode.gwtphonegap.client.geolocation.GeolocationWatcher)
	 */
	@Override
	public native void clearWatch(GeolocationWatcher watcher) /*-{
		$wnd.navigator.geolocation.clearWatch(watcher.id);
	}-*/;

}
