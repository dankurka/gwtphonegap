package com.googlecode.gwtphonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.FileError;


public final class FileErrorJsImpl extends JavaScriptObject implements FileError {

	protected FileErrorJsImpl() {

	}

	@Override
	public native int getErrorCode()/*-{
		return this.code;
	}-*/;

}
