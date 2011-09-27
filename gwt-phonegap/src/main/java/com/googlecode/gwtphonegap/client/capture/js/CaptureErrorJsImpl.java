package com.googlecode.gwtphonegap.client.capture.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.capture.CaptureError;


public final class CaptureErrorJsImpl extends JavaScriptObject implements CaptureError {
	protected CaptureErrorJsImpl() {

	}

	@Override
	public native int getCode() /*-{
		return this.code;
	}-*/;

}
