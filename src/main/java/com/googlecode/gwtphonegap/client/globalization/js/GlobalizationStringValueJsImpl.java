package com.googlecode.gwtphonegap.client.globalization.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationStringValue;

/**
 * Created by vkiran on 12/18/13.
 */
public final class GlobalizationStringValueJsImpl extends JavaScriptObject implements GlobalizationStringValue {

    protected GlobalizationStringValueJsImpl(){

    }
    @Override
    public native String getValue() /*-{
        return this.value;
    }-*/;
}
