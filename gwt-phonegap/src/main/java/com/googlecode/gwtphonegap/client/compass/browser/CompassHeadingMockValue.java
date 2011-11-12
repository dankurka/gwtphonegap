package com.googlecode.gwtphonegap.client.compass.browser;

import com.googlecode.gwtphonegap.client.compass.CompassHeading;

public class CompassHeadingMockValue implements CompassHeading {

	private final double magneticHeading;
	private final double trueHeading;
	private final double headingAccuracy;
	private final long timeStamp;

	public CompassHeadingMockValue(double magneticHeading, double trueHeading, double headingAccuracy) {
		this.magneticHeading = magneticHeading;
		this.trueHeading = trueHeading;
		this.headingAccuracy = headingAccuracy;
		this.timeStamp = System.currentTimeMillis();
	}

	@Override
	public double getMagneticHeading() {
		return magneticHeading;
	}

	@Override
	public double getTrueHeading() {
		return trueHeading;
	}

	@Override
	public double getHeadingAccuracy() {
		return headingAccuracy;
	}

	@Override
	public long getTimeStamp() {
		return timeStamp;
	}

}
