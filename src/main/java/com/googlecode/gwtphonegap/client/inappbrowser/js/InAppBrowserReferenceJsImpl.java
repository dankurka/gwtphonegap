/*
 * Copyright 2013 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.inappbrowser.js;

import com.google.gwt.core.client.JavaScriptObject;

import com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserCallback;
import com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserReferenceBaseImpl;

public class InAppBrowserReferenceJsImpl extends InAppBrowserReferenceBaseImpl {

  private final JavaScriptObject jsWindowRef;

  public InAppBrowserReferenceJsImpl(JavaScriptObject jsWindowRef) {
    this.jsWindowRef = jsWindowRef;
  }

  @Override
  public native void close() /*-{
		var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.js.InAppBrowserReferenceJsImpl::jsWindowRef;
		ref.close();
  }-*/;

  @Override
  protected native void addJavaScriptHandlers() /*-{
		var that = this;
		var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.js.InAppBrowserReferenceJsImpl::jsWindowRef;

		var loadStart = function(event) {
			that.@com.googlecode.gwtphonegap.client.inappbrowser.js.InAppBrowserReferenceJsImpl::fireLoadStartEvent(Ljava/lang/String;)(event.url);
		};

		var loadStop = function(event) {
			that.@com.googlecode.gwtphonegap.client.inappbrowser.js.InAppBrowserReferenceJsImpl::fireLoadStopEvent(Ljava/lang/String;)(event.url);
		};

		var exit = function(event) {
			ref.removeEventListener("loadstart", loadStart);
			ref.removeEventListener("loadstop", loadStop);
			ref.removeEventListener("exit", exit);

			that.@com.googlecode.gwtphonegap.client.inappbrowser.js.InAppBrowserReferenceJsImpl::fireExitEvent()();
		};

		ref.addEventListener("loadstart", loadStart);
		ref.addEventListener("loadstop", loadStop);
		ref.addEventListener("exit", exit);

  }-*/;

  @Override
  public native void show() /*-{
    var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.js.InAppBrowserReferenceJsImpl::jsWindowRef;
    ref.show();
  }-*/;

  @Override
  public native void executeScript(String code, InAppBrowserCallback callback) /*-{
    var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.js.InAppBrowserReferenceJsImpl::jsWindowRef;

    var script = {code: code};
    var c = function(){
      callback.@com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserCallback::done()();
    };

    ref.executeScript(script, $entry(c));
  }-*/;


  @Override
  public native void executeScriptFromUrl(String url, InAppBrowserCallback callback) /*-{
    var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.js.InAppBrowserReferenceJsImpl::jsWindowRef;

    var script = {file: url};
    var c = function(){
      callback.@com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserCallback::done()();
    };

    ref.executeScript(script, $entry(c));
}-*/;

  @Override
  public native void injectCss(String css, InAppBrowserCallback callback) /*-{
    var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.js.InAppBrowserReferenceJsImpl::jsWindowRef;

    var script = {code: css};
    var c = function(){
      callback.@com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserCallback::done()();
    };

    ref.insertCSS(script, $entry(c));
  }-*/;

  @Override
  public native void injectCssFromUrl(String url, InAppBrowserCallback callback) /*-{
    var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.js.InAppBrowserReferenceJsImpl::jsWindowRef;

    var script = {file: url};
    var c = function(){
      callback.@com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserCallback::done()();
    };

    ref.insertCSS(script, $entry(c));
  }-*/;

}
