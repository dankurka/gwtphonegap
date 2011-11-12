package com.googlecode.gwtphonegap.client.capture.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.capture.ConfigurationData;


public final class ConfigurationDataJsImpl extends JavaScriptObject implements ConfigurationData {

	protected ConfigurationDataJsImpl() {

	}

	@Override
	public native String getType() /*-{
		return this.type;
	}-*/;

	@Override
	public native int getHeight() /*-{
		return this.height;
	}-*/;

	@Override
	public native int getWidth() /*-{
		return this.width;
	}-*/;

}
