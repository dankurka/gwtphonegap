package com.googlecode.gwtphonegap.client.file.js;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.FileObject;


public final class FileObjectJsImpl extends JavaScriptObject implements FileObject {

	protected FileObjectJsImpl() {

	}

	@Override
	public native String getName() /*-{
		return this.name;
	}-*/;

	@Override
	public native String getFullPath() /*-{
		return this.fullPath;
	}-*/;

	@Override
	public native String getType() /*-{
		return this.type;
	}-*/;

	@Override
	public native Date getLastModifiedDate() /*-{
		return @com.googlecode.gwtphonegap.client.file.js.FileObjectJsImpl::createDate(D)(this.lastModifiedDate.getTime());
	}-*/;

	public static final Date createDate(double value) {
		long time = Math.round(value);
		return new Date(time);
	}

	@Override
	public long size() {
		return Math.round(size0());
	}

	public native double size0() /*-{
		return this.size;
	}-*/;

}
