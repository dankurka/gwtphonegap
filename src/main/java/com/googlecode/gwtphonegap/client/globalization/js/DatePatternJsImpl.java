/*
 * Copyright 2012 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.globalization.js;

import com.google.gwt.core.client.JavaScriptObject;

import com.googlecode.gwtphonegap.client.globalization.DatePattern;

public final class DatePatternJsImpl extends JavaScriptObject implements DatePattern {

  protected DatePatternJsImpl() {

  }

  @Override
  public native String getPattern() /*-{
		return this.pattern;
  }-*/;

    @Override
    public native String getTimeZone() /*-{
        return this.timezone;
    }-*/;

    @Override
    public native int getUtc_offset() /*-{
        return this.utc_offset;
    }-*/;

    @Override
    public native int getDst_offset() /*-{
        return this.dst_offset;
    }-*/;

}
