package de.kurka.phonegap.client.media.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.media.MediaError;

public final class MediaErrorJsImpl extends JavaScriptObject implements MediaError {

	protected MediaErrorJsImpl() {

	}

	@Override
	public native int getErrorCode() /*-{
		return this.code;
	}-*/;

	@Override
	public native String getErrorMessage() /*-{
		return message;
	}-*/;

}
