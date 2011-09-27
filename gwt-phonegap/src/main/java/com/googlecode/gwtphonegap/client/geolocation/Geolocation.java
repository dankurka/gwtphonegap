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

public interface Geolocation {

	/**
	 * calculates the device's current position as a Position object.
	 * 
	 * Function geolocation.getCurrentPositon is an asynchronous function. It
	 * returns the device's current position to the geolocationSuccess callback
	 * with a Position object as the parameter. If there is an error, the
	 * geolocationError callback is invoked with a PositionError object.
	 * 
	 * <h1>Supported Platforms</h1>
	 * 
	 * <ul>
	 * <li>Android</li>
	 * <li>BlackBerry</li>
	 * <li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * <li>iPhone</li>
	 * </ul>
	 * 
	 * @param options
	 * @param callback
	 */
	public void getCurrentPosition(GeolocationCallback callback);

	/**
	 * Watches for changes to the device's current position.
	 * 
	 * Function geolocation.watchPosition is an asynchronous function. It
	 * returns the device's current position when a change in position has been
	 * detected. When the device has retrieved a new location, the
	 * geolocationSuccess callback is invoked with a Position object as the
	 * parameter. If there is an error, the geolocationError callback is invoked
	 * with a PositionError object.
	 * 
	 * <ul>
	 * <li>Android</li>
	 * <li>BlackBerry (OS 4.6)</li>
	 * <li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * <li>iPhone</li>
	 * </ul>
	 * 
	 * @param options
	 * @param callback
	 * @return a {@link GeolocationWatcher} that references the watch position
	 *         interval. The {@link GeolocationWatcher} can be used with
	 *         {@link GeolocationMobileImpl#clearWatch(GeolocationWatcher)} to
	 *         stop watching for changes in position.
	 */
	public GeolocationWatcher watchPosition(GeolocationOptions options, GeolocationCallback callback);

	/**
	 * top watching for changes to the device's location referenced by the
	 * {@link GeolocationWatcher} parameter.
	 * 
	 * <ul>
	 * <li>Android</li>
	 * <li>BlackBerry (OS 4.6)</li>
	 * <li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * <li>iPhone</li>
	 * </ul>
	 * 
	 * @param watcher
	 */
	public void clearWatch(GeolocationWatcher watcher);

}