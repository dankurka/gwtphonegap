package com.googlecode.gwtphonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.FileTransferProgressEvent;

public final class FileTransferProgressEventJsImpl extends JavaScriptObject implements FileTransferProgressEvent {

	protected FileTransferProgressEventJsImpl() {

	}

	@Override
	public native boolean isLengthComputable() /*-{
		return this.lengthComputable;
	}-*/;

	@Override
	public long getLoadedBytes() {
		double d = getLoadedBytes0();
		return Math.round(d);
	}

	private native double getLoadedBytes0()/*-{
		return this.loaded;
	}-*/;

	@Override
	public long getTotalBytes() {
		double d = getTotalBytes0();
		return Math.round(d);
	}

	private native double getTotalBytes0()/*-{
		return this.total;
	}-*/;

}
