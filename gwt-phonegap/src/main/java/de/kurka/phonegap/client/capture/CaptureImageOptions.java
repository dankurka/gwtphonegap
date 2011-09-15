package de.kurka.phonegap.client.capture;

public class CaptureImageOptions {
	private int limit;

	private String mode;

	public CaptureImageOptions() {
		this.limit = 1;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getLimit() {
		return limit;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}
}
