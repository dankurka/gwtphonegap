/*
 * Copyright 2011 Daniel Kurka
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
package com.googlecode.gwtphonegap.client.geolocation.browser;

import com.googlecode.gwtphonegap.client.geolocation.Coordinates;

public class CoordinatesBrowserImpl implements Coordinates {

	private double latidue;
	private double longitude;
	private double altitude;
	private double horizontalAccuracy;
	private double verticalAccuracy;
	private double altitudeAccuracy;
	private double heading;
	private double speed;

	@Override
	public double getLatitude() {
		return latidue;
	}

	public void setLatidue(double latidue) {
		this.latidue = latidue;
	}

	@Override
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	@Override
	public double getHorizontalAccuracy() {
		return horizontalAccuracy;
	}

	public void setHorizontalAccuracy(double horizontalAccuracy) {
		this.horizontalAccuracy = horizontalAccuracy;
	}

	@Override
	public double getVerticalAccuracy() {
		return verticalAccuracy;
	}

	public void setVerticalAccuracy(double verticalAccuracy) {
		this.verticalAccuracy = verticalAccuracy;
	}

	@Override
	public double getAltitudeAccuracy() {
		return altitudeAccuracy;
	}

	public void setAltitudeAccuracy(double altitudeAccuracy) {
		this.altitudeAccuracy = altitudeAccuracy;
	}

	@Override
	public double getHeading() {
		return heading;
	}

	public void setHeading(double heading) {
		this.heading = heading;
	}

	@Override
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

}
