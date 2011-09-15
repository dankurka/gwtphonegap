package de.kurka.phonegap.client.compass;

public interface CompassCallback {
	public void onError();

	public void onSuccess(double heading);
}
