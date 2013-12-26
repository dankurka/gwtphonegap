package com.googlecode.gwtphonegap.client.globalization.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.globalization.DayLightSavings;

/**
 * Created by vkiran on 12/19/13.
 */
public final class DayLightSavingsJsImpl extends JavaScriptObject implements DayLightSavings{

    protected DayLightSavingsJsImpl(){

    }
    @Override
    public native boolean getDst()  /*-{
        return this.dst;
    }-*/;
}
