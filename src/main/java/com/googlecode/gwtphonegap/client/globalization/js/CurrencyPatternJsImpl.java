package com.googlecode.gwtphonegap.client.globalization.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.globalization.CurrencyPattern;

/**
 * Created by vkiran on 12/17/13.
 */
public final class CurrencyPatternJsImpl extends JavaScriptObject implements CurrencyPattern {

    protected CurrencyPatternJsImpl() {

    }

    @Override
    public native String getPattern()  /*-{
        return this.pattern;
    }-*/;

    @Override
    public native String getCode()  /*-{
        return this.code;
    }-*/;

    @Override
    public native String getDecimal()  /*-{
        return this.decimal;
    }-*/;

    @Override
    public native String getGrouping()  /*-{
        return this.grouping;
    }-*/;

    @Override
    public native int getRounding()  /*-{
        return this.rounding;
    }-*/;

    @Override
    public native double getFraction()  /*-{
        return this.fraction;
    }-*/;
}
