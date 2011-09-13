package de.kurka.phonegap.client.file.js;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.file.Metadata;

public class MetaDataJsImpl extends JavaScriptObject implements Metadata {

	@Override
	public native Date getModificationTime() /*-{
		return @de.kurka.phonegap.client.file.js.MetaDataJsImpl::createDate(D)(this.modificationTime.getTime());
	}-*/;

	public static final Date createDate(double value) {
		long time = Math.round(value);
		return new Date(time);
	}

}
