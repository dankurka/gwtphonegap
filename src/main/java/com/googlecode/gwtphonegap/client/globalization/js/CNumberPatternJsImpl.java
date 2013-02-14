/*
 * Copyright 2012 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.globalization.js;

import com.google.gwt.core.client.JavaScriptObject;

import com.googlecode.gwtphonegap.client.globalization.CNumberPattern;

public final class CNumberPatternJsImpl extends JavaScriptObject implements CNumberPattern {

  protected CNumberPatternJsImpl() {

  }

  @Override
  public native String getPattern() /*-{
		return this.pattern;
  }-*/;

  @Override
  public native String getSymbol() /*-{
		return this.pattern;
  }-*/;

  @Override
  public native int getFraction() /*-{
		return this.pattern;
  }-*/;

  @Override
  public native double getRounding() /*-{
		return this.pattern;
  }-*/;

  @Override
  public native String getPositive() /*-{
		return this.pattern;
  }-*/;

  @Override
  public native String getNegative() /*-{
		return this.pattern;
  }-*/;

  @Override
  public native String getDecimal() /*-{
		return this.pattern;
  }-*/;

  @Override
  public native String getGrouping() /*-{
		return this.pattern;
  }-*/;

}
