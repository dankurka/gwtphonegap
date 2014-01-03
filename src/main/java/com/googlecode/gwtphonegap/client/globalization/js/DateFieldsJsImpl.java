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

import com.googlecode.gwtphonegap.client.globalization.DateFields;

/**
 * @author vkiran
 */
public final class DateFieldsJsImpl extends JavaScriptObject implements DateFields {

    protected DateFieldsJsImpl() {

    }

    @Override
    public native int getYear()/*-{
        return this.year;
    }-*/;

    @Override
    public native int getMonth() /*-{
        return this.month;
    }-*/;

    @Override
    public native int getDay() /*-{
        return this.day;
    }-*/;

    @Override
    public native int getHour() /*-{
        return this.hour;
    }-*/;

    @Override
    public native int getMinute() /*-{
        return this.minute;
    }-*/;

    @Override
    public native int getSecond() /*-{
        return this.second;
    }-*/;

    @Override
    public native Long getMillisecond() /*-{
        return this.millisecond;
    }-*/;

}
