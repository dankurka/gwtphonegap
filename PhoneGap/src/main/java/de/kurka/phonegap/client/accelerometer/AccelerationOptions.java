package de.kurka.phonegap.client.accelerometer;

public class AccelerationOptions {

	private double frequency;

	public AccelerationOptions() {
		this.frequency = 10000;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

}
