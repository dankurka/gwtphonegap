package de.kurka.phonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.file.FileUploadResult;

public final class FileUploadResultJsImpl extends JavaScriptObject implements FileUploadResult {

	protected FileUploadResultJsImpl() {

	}

	@Override
	public long getBytesSent() {
		return Math.round(getBytesSent0());
	}

	private native double getBytesSent0()/*-{
		return this.bytesSent;
	}-*/;

	@Override
	public long getResponseCode() {
		return Math.round(getResponseCode0());
	}

	private native double getResponseCode0()/*-{
		return this.responseCode;
	}-*/;

	@Override
	public native String getResponse() /*-{
		return this.response;
	}-*/;

}
