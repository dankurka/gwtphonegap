package com.googlecode.gwtphonegap.client.media;

public interface Media {
	public void getCurrentPosition(MediaPositionCallback callback);

	public long getDuration();

	public void play();

	public void pause();

	public void release();

	public void seekTo(long position);

	public void startRecord();

	public void stopRecord();

	public void stop();
}
