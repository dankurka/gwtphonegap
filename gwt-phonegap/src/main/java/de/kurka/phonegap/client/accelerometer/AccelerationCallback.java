package de.kurka.phonegap.client.accelerometer;

public interface AccelerationCallback {
	public void onSuccess(Acceleration acceleration);

	public void onFailure();
}
