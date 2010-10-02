package de.kurka.phonegap.client.geolocation;

public interface GeolocationCallback {
	public void onSuccess(Position position);

	public void onFailure();
}
