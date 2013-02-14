package com.googlecode.gwtphonegap.client.globalization.js;

import com.google.gwt.core.client.JavaScriptObject;

import com.googlecode.gwtphonegap.client.globalization.CLocale;

public final class CLocaleJsImpl extends JavaScriptObject implements CLocale {

  protected CLocaleJsImpl() {

  }

  @Override
  public native String getValue() /*-{
		return this.value;
  }-*/;

}
