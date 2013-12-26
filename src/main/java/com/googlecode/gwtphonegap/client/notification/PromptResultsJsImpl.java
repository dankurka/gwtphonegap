package com.googlecode.gwtphonegap.client.notification;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * Created by vkiran on 10/12/13.
 */
public final class PromptResultsJsImpl extends JavaScriptObject implements PromptResults {

    protected PromptResultsJsImpl(){

    }

    @Override
    public native int getButtonIndex() /*-{
		return this.buttonIndex;
    }-*/;

    @Override
    public native String getInput1() /*-{
		return this.input1;
	}-*/;
}
