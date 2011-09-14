package de.kurka.phonegap.client.media;

public interface Media {
	public void getCurrentPosition(MediaPositionCallback callback);

	public int getDuration();

	public void play();

	public void pause();

	public void release();

	public void seekTo(long position);

	public void startRecord();

	public void stopRecord();

	public void stop();
}
