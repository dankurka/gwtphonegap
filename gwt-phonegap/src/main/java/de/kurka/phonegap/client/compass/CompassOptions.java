package de.kurka.phonegap.client.compass;

public class CompassOptions {
	private int frequency;

	public CompassOptions() {
		this(100);
	}

	public CompassOptions(int frequency) {
		this.frequency = frequency;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
