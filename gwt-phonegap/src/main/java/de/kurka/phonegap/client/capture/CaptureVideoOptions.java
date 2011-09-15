package de.kurka.phonegap.client.capture;

public class CaptureVideoOptions {
	private int limit;

	private long duration;

	private String mode;

	public CaptureVideoOptions() {
		this.limit = 1;
		this.duration = -1;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}

}
