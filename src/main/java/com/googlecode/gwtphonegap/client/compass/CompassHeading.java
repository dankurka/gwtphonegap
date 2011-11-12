package com.googlecode.gwtphonegap.client.compass;

public interface CompassHeading {
	public double getMagneticHeading();

	public double getTrueHeading();

	public double getHeadingAccuracy();

	public long getTimeStamp();
}
