package de.kurka.phonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.file.FileError;

public final class FileErrorJsImpl extends JavaScriptObject implements FileError {

	@Override
	public native int getErrorCode()/*-{
		return this.code;
	}-*/;

}
