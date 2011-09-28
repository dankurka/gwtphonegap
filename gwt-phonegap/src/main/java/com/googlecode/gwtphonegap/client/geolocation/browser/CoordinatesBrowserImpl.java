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
