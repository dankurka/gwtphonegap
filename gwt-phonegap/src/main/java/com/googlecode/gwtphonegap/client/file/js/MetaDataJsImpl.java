package com.googlecode.gwtphonegap.client.file.js;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.Metadata;


public final class MetaDataJsImpl extends JavaScriptObject implements Metadata {

	protected MetaDataJsImpl() {

	}

	@Override
	public native Date getModificationTime() /*-{
		return @com.googlecode.gwtphonegap.client.file.js.MetaDataJsImpl::createDate(D)(this.modificationTime.getTime());
	}-*/;

	public static final Date createDate(double value) {
		long time = Math.round(value);
		return new Date(time);
	}

}