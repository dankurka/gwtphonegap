package com.googlecode.gwtphonegap.client.globalization.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationIntValue;

/**
 * Created by vkiran on 12/18/13.
 */
public final class GlobalizationIntValueJsImpl extends JavaScriptObject implements GlobalizationIntValue{

    protected GlobalizationIntValueJsImpl(){

    }
    @Override
    public native int getValue() /*-{
        return this.value;
    }-*/;
}
