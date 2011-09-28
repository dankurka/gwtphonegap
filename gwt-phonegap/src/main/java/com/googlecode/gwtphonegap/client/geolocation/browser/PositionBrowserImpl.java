package com.googlecode.gwtphonegap.client.geolocation.browser;

import com.googlecode.gwtphonegap.client.geolocation.Coordinates;
import com.googlecode.gwtphonegap.client.geolocation.Position;

public class PositionBrowserImpl implements Position {

	private final Coordinates coordinates;
	private final long timestamp;

	public PositionBrowserImpl(Coordinates coordinates, long timestamp) {
		this.coordinates = coordinates;
		this.timestamp = timestamp;
	}

	@Override
	public Coordinates getCoordinates() {
		return coordinates;
	}

	@Override
	public long getTimeStamp() {
		return timestamp;
	}

}
