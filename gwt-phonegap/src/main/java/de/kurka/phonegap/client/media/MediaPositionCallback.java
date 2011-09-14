package de.kurka.phonegap.client.media;

public interface MediaPositionCallback {
	public void onSuccess(long position);

	public void onFailure(MediaError error);
}
