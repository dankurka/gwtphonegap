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
package com.googlecode.gwtphonegap.client.geolocation.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.geolocation.Geolocation;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationCallback;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationOptions;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationWatcher;

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

	@Override
	public void getCurrentPosition(GeolocationCallback callback) {
		getCurrentPosition(callback, null);
	}

	@Override
	public native void getCurrentPosition(GeolocationCallback callback, GeolocationOptions options)/*-{
		var successCallback = function(data) {
			@com.googlecode.gwtphonegap.client.geolocation.js.GeolocationMobileImpl::onSuccess(Lcom/googlecode/gwtphonegap/client/geolocation/GeolocationCallback;Lcom/googlecode/gwtphonegap/client/geolocation/js/PositionJsImpl;)(callback, data);
		};

		var errorCallback = function(error) {
			@com.googlecode.gwtphonegap.client.geolocation.js.GeolocationMobileImpl::onFailure(Lcom/googlecode/gwtphonegap/client/geolocation/GeolocationCallback;Lcom/googlecode/gwtphonegap/client/geolocation/js/PositionErrorJSOImpl;)(callback, error);
		};

		var localOptions = this.@com.googlecode.gwtphonegap.client.geolocation.js.GeolocationMobileImpl::createOptions(Lcom/googlecode/gwtphonegap/client/geolocation/GeolocationOptions;)(options);

		$wnd.navigator.geolocation.getCurrentPosition($entry(successCallback),
				$entry(errorCallback), localOptions);
	}-*/;

	public native String watchPosition0(GeolocationOptions options, GeolocationCallback callback)/*-{
		var successCallback = function(data) {
			@com.googlecode.gwtphonegap.client.geolocation.js.GeolocationMobileImpl::onSuccess(Lcom/googlecode/gwtphonegap/client/geolocation/GeolocationCallback;Lcom/googlecode/gwtphonegap/client/geolocation/js/PositionJsImpl;)(callback, data);
		};

		var errorCallback = function(error) {
			@com.googlecode.gwtphonegap.client.geolocation.js.GeolocationMobileImpl::onFailure(Lcom/googlecode/gwtphonegap/client/geolocation/GeolocationCallback;Lcom/googlecode/gwtphonegap/client/geolocation/js/PositionErrorJSOImpl;)(callback, error);
		};

		var localOptions = this.@com.googlecode.gwtphonegap.client.geolocation.js.GeolocationMobileImpl::createOptions(Lcom/googlecode/gwtphonegap/client/geolocation/GeolocationOptions;)(options);

		var watcherId = $wnd.navigator.geolocation.watchPosition(
				$entry(successCallback), $entry(errorCallback), localOptions);

		return watcherId;
	}-*/;

	private static void onFailure(GeolocationCallback callback, PositionErrorJSOImpl error) {
		callback.onFailure(error);
	}

	private static void onSuccess(GeolocationCallback callback, PositionJsImpl posision) {
		callback.onSuccess(posision);
	}

	private native void clearWatch0(String watcher) /*-{
		$wnd.navigator.geolocation.clearWatch(watcher);
	}-*/;

	private native JavaScriptObject createOptions(GeolocationOptions options)/*-{

		var localOptions = {};

		if (options == null)
			return localOptions;

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

		return localOptions;

	}-*/;

	@Override
	public void clearWatch(GeolocationWatcher watcher) {
		if (!(watcher instanceof GeolocationWatcherJSOImpl)) {
			throw new IllegalStateException();
		}
		GeolocationWatcherJSOImpl geolocationWatcherJSOImpl = (GeolocationWatcherJSOImpl) watcher;
		clearWatch0(geolocationWatcherJSOImpl.getId());

	}

	@Override
	public GeolocationWatcher watchPosition(GeolocationOptions options, GeolocationCallback callback) {
		String id = watchPosition0(options, callback);
		return new GeolocationWatcherJSOImpl(id);
	}

}
