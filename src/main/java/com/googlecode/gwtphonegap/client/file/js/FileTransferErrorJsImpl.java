package com.googlecode.gwtphonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.FileTransferError;


public final class FileTransferErrorJsImpl extends JavaScriptObject implements FileTransferError {

	protected FileTransferErrorJsImpl() {

	}

	@Override
	public native int getCode() /*-{
		return this.code;
	}-*/;

}
