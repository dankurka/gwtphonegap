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
 * The Geolocation options
 * @author Daniel Kurka
 *
 */
public class GeolocationOptions {
	private int frequency;

	private boolean enableHighAccuracy;

	private int timeout;

	private int maximumAge;

	public GeolocationOptions() {
		this.frequency = 10000;
	}

	public int getFrequency() {
		return frequency;
	}

	public int getMaximumAge() {
		return maximumAge;
	}

	public int getTimeout() {
		return timeout;
	}

	public boolean isEnableHighAccuracy() {
		return enableHighAccuracy;
	}

	/**
	 * Provides a hint that the application would like to receive the best possible results. (Boolean)
	 * @param enableHighAccuracy
	 */
	public void setEnableHighAccuracy(boolean enableHighAccuracy) {
		this.enableHighAccuracy = enableHighAccuracy;
	}

	/**
	 *  How often to retrieve the position in milliseconds. This option is not part of the W3C spec and will be removed in the future. maximumAge should be used instead. (Number) (Default: 10000)
	 * @param frequency
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * Accept a cached position whose age is no greater than the specified time in milliseconds. (Number)
	 * @param maximumAge
	 */
	public void setMaximumAge(int maximumAge) {
		this.maximumAge = maximumAge;
	}

	/**
	 * The maximum length of time (msec) that is allowed to pass from the call to geolocation.getCurrentPosition or geolocation.watchPosition until the corresponding geolocationSuccess callback is invoked. (Number)
	 * @param timeout
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
}
