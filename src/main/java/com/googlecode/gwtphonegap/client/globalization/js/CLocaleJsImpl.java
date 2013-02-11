package com.googlecode.gwtphonegap.client.globalization.js;

import com.google.gwt.core.client.JavaScriptObject;

import com.googlecode.gwtphonegap.client.globalization.CLocale;

public class CLocaleJsImpl extends JavaScriptObject implements CLocale {

  @Override
  public native String getValue() /*-{
		return this.value;
  }-*/;

}
