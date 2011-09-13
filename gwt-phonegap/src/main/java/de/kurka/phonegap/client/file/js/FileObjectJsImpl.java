package de.kurka.phonegap.client.file.js;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.file.FileObject;

public final class FileObjectJsImpl extends JavaScriptObject implements FileObject {

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
		return @de.kurka.phonegap.client.file.js.FileObjectJsImpl::createDate(D)(this.lastModifiedDate.getTime());
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
