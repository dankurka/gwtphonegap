package de.kurka.phonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.file.FileTransferError;

public final class FileTransferErrorJsImpl extends JavaScriptObject implements FileTransferError {

	protected FileTransferErrorJsImpl() {

	}

	@Override
	public native int getCode() /*-{
		return this.code;
	}-*/;

}
