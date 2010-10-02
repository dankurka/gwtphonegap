package de.kurka.phonegap.client.geolocation;

public class GeolocationOptions {
	private int frequency;

	public GeolocationOptions() {

	}

	public GeolocationOptions(int frequency) {
		this.frequency = frequency;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
}
