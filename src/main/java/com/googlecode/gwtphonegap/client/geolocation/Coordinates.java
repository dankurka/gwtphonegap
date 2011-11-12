package com.googlecode.gwtphonegap.client.geolocation;

public interface Coordinates {
	public double getLatitude();

	public double getLongitude();

	public double getAltitude();

	public double getHorizontalAccuracy();

	public double getVerticalAccuracy();

	public double getAltitudeAccuracy();

	public double getHeading();

	public double getSpeed();
}
