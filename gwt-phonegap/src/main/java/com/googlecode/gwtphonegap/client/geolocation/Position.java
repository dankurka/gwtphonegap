package com.googlecode.gwtphonegap.client.geolocation;

import com.googlecode.gwtphonegap.client.geolocation.js.CoordinatesJsImpl;

public interface Position {
	public CoordinatesJsImpl getCoordinates();

	public long getTimeStamp();
}
