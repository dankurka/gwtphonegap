package com.googlecode.gwtphonegap.client.globalization.js;
import com.google.gwt.core.client.JavaScriptObject;

import com.googlecode.gwtphonegap.client.globalization.DateFields;

/**
 * Created by vkiran on 12/4/13.
 */
public final class DateFieldsJsImpl extends JavaScriptObject implements DateFields {

    protected DateFieldsJsImpl() {

    }

    public native int getYear()/*-{
        return this.year;
    }-*/;

    public native int getMonth() /*-{
        return this.month;
    }-*/;

    public native int getDay() /*-{
        return this.day;
    }-*/;

    public native int getHour() /*-{
        return this.hour;
    }-*/;

    public native int getMinute() /*-{
        return this.minute;
    }-*/;

    public native int getSecond() /*-{
        return this.second;
    }-*/;

    public native Long getMillisecond() /*-{
        return this.millisecond;
    }-*/;

}
