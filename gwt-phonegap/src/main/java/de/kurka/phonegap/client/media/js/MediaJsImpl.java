package de.kurka.phonegap.client.media.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.media.Media;
import de.kurka.phonegap.client.media.MediaPositionCallback;

public final class MediaJsImpl extends JavaScriptObject implements Media {

	protected MediaJsImpl() {
	}

	@Override
	public native void getCurrentPosition(MediaPositionCallback callback) /*-{
		var that = this;

		var suc = function(pos) {
			@de.kurka.phonegap.client.media.js.MediaJsImpl::onSuccess(Lde/kurka/phonegap/client/media/MediaPositionCallback;D)(callback, pos);
		};

		var fail = function(error) {
			callback.@de.kurka.phonegap.client.media.MediaPositionCallback::onFailure(Lde/kurka/phonegap/client/media/MediaError;)(error);
		}

		this.getCurrentPosition($entry(suc), $entry(fail));

	}-*/;

	private static void onSuccess(MediaPositionCallback callback, double postion) {
		callback.onSuccess(Math.round(postion));
	}

	@Override
	public long getDuration() {
		return Math.round(getDuration0());
	}

	private native double getDuration0() /*-{
		return this.getDuration();
	}-*/;

	@Override
	public native void play() /*-{
		return this.play();
	}-*/;

	@Override
	public native void pause() /*-{
		return this.pause();
	}-*/;

	@Override
	public native void release() /*-{
		return this.release();
	}-*/;

	@Override
	public void seekTo(long position) {
		seekTo0(position);

	}

	private native void seekTo0(double position)/*-{
		return this.seekTo(position);
	}-*/;

	@Override
	public native void startRecord() /*-{
		return this.startRecord();
	}-*/;

	@Override
	public native void stopRecord() /*-{
		return this.stopRecord();
	}-*/;

	@Override
	public native void stop() /*-{
		return this.stop();
	}-*/;

}
