package de.kurka.phonegap.client.capture;

public class CaptureAudioOptions {
	private int limit;

	private long duration;

	private String mode;

	public CaptureAudioOptions() {
		this.limit = 1;
		this.duration = -1;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getLimit() {
		return limit;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getDuration() {
		return duration;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}
}
