package com.googlecode.gwtphonegap.client.capture.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.capture.MediaFileData;


public final class MediaFileDataJsImpl extends JavaScriptObject implements MediaFileData {

	protected MediaFileDataJsImpl() {

	}

	@Override
	public native String getCodecs() /*-{
		return this.codecs;
	}-*/;

	@Override
	public long getBitRate() {
		return Math.round(getBitRate0());
	}

	private native double getBitRate0()/*-{
		return this.bitrate;
	}-*/;

	@Override
	public native int getHeight() /*-{
		return this.height;
	}-*/;

	@Override
	public native int getWidth()/*-{
		return this.width;
	}-*/;

	@Override
	public long getDuration() {
		return Math.round(getDuration0());
	}

	private native double getDuration0()/*-{
		return this.duration;
	}-*/;

}
