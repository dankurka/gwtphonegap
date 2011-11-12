package com.googlecode.gwtphonegap.client.compass.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.compass.CompassHeading;

public final class CompassHeadingJsImpl extends JavaScriptObject implements CompassHeading {

	protected CompassHeadingJsImpl() {

	}

	@Override
	public native double getMagneticHeading()/*-{
		return this.magneticHeading;
	}-*/;

	@Override
	public native double getTrueHeading()/*-{
		return this.trueHeading;
	}-*/;

	@Override
	public native double getHeadingAccuracy() /*-{
		return this.headingAccuracy;
	}-*/;

	@Override
	public long getTimeStamp() {
		return Math.round(getTimeStamp0());
	}

	private native double getTimeStamp0()/*-{
		return this.timestamp;
	}-*/;

}
