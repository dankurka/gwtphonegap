package de.kurka.phonegap.client.camera;

public class PictureOptions {

	private int quality;

	public PictureOptions() {
		quality = 75;
	}

	public PictureOptions(int quality) {
		this.quality = quality;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

}
