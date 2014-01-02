/*
 * Copyright 2011 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.media.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.media.Media;
import com.googlecode.gwtphonegap.client.media.MediaPositionCallback;

public final class MediaJsImpl extends JavaScriptObject implements Media {

	protected MediaJsImpl() {
	}

	@Override
	public native void getCurrentPosition(MediaPositionCallback callback) /*-{
		var that = this;

		var suc = function(pos) {
			@com.googlecode.gwtphonegap.client.media.js.MediaJsImpl::onSuccess(Lcom/googlecode/gwtphonegap/client/media/MediaPositionCallback;D)(callback, pos);
		};

		var fail = function(error) {
			callback.@com.googlecode.gwtphonegap.client.media.MediaPositionCallback::onFailure(Lcom/googlecode/gwtphonegap/client/media/MediaError;)(error);
		}

		this.getCurrentPosition($entry(suc), $entry(fail));

	}-*/;

	private static void onSuccess(MediaPositionCallback callback, double position) {
		callback.onSuccess(Math.round(position));
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

    /**
     * Set the volume for audio playback.This is an asynchronous function that sets the volume during audio playback.
     *
     * @param volume : The volume to set for playback. The value must be within the range of 0.0 to 1.0.
     */
    @Override
    public void setVolume(double volume) {
        setVolume0(volume);
    }

    public native void setVolume0(double volume)/*-{
        this.setVolume(volume);
    }-*/;
}
