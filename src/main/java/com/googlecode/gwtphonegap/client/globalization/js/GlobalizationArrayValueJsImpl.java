package com.googlecode.gwtphonegap.client.globalization.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.googlecode.gwtphonegap.client.file.EntryBase;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationArrayValue;
import com.googlecode.gwtphonegap.collection.shared.LightArray;

import java.lang.reflect.Array;

/**
 * Created by vkiran on 12/21/13.
 */
public final class GlobalizationArrayValueJsImpl extends JavaScriptObject implements GlobalizationArrayValue {

    protected GlobalizationArrayValueJsImpl(){

    }
    @Override
    public native LightArray<String> getValue() /*-{
        return this.value;
    }-*/;
}
