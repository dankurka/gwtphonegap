package com.googlecode.gwtphonegap.client.globalization.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationDoubleValue;


/**
 * Created by vkiran on 12/18/13.
 */
public final class GlobalizationDoubleValueJsImpl extends JavaScriptObject implements GlobalizationDoubleValue{

    protected GlobalizationDoubleValueJsImpl(){

    }
    @Override
    public native double getValue() /*-{
        return this.value;
    }-*/;
}
