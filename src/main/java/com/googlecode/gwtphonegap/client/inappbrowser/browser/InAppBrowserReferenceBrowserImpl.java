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
package com.googlecode.gwtphonegap.client.inappbrowser.browser;

import com.google.gwt.core.client.JavaScriptObject;

import com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserCallback;
import com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserReferenceBaseImpl;

public class InAppBrowserReferenceBrowserImpl extends InAppBrowserReferenceBaseImpl {

  private final JavaScriptObject windowRef;

  public InAppBrowserReferenceBrowserImpl(JavaScriptObject windowRef) {
    this.windowRef = windowRef;
  }

  @Override
  public native void close() /*-{
		var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.browser.InAppBrowserReferenceBrowserImpl::windowRef;
		ref.close();

  }-*/;

  @Override
  protected void addJavaScriptHandlers() {

  }

  @Override
  public native void show() /*-{
    var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.browser.InAppBrowserReferenceBrowserImpl::windowRef;
    ref.show();
  }-*/;

  @Override
  public native void executeScript(String code, InAppBrowserCallback callback) /*-{
    var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.browser.InAppBrowserReferenceBrowserImpl::windowRef;

    var script = ref.document.createElement('script');
    script.type = 'text/javascript';
    script.innerText = code;
    ref.document.head.appendChild(script);
    
    var c = function(){
      callback.@com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserCallback::done()();
    };
    
    setTimeout($entry(c), 1);
  }-*/;

  @Override
  public native void executeScriptFromUrl(String url, InAppBrowserCallback callback) /*-{
    var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.browser.InAppBrowserReferenceBrowserImpl::windowRef;

    var script = ref.document.createElement('script');
    script.type = 'text/javascript';
    script.src = url;
    ref.document.head.appendChild(script);

    var c = function(){
      callback.@com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserCallback::done()();
    };

    setTimeout($entry(c), 1);
  }-*/;

  @Override
  public native void injectCss(String css, InAppBrowserCallback callback) /*-{
    var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.browser.InAppBrowserReferenceBrowserImpl::windowRef;

    var link = ref.document.createElement('style');
    link.type = 'text/css';
    link.innertText = css;
    ref.document.head.appendChild(link);

    var c = function(){
      callback.@com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserCallback::done()();
    };

    setTimeout($entry(c), 1);
  }-*/;

  //<link rel="stylesheet" type="text/css" href="themes/euroPort/master/styles.css">
  @Override
  public native void injectCssFromUrl(String url, InAppBrowserCallback callback) /*-{
    var ref = this.@com.googlecode.gwtphonegap.client.inappbrowser.browser.InAppBrowserReferenceBrowserImpl::windowRef;

    var link = ref.document.createElement('link');
    link.rel = 'stylesheet';
    link.type = 'text/css';
    link.href = url;
    ref.document.head.appendChild(link);

    var c = function(){
      callback.@com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserCallback::done()();
    };

    setTimeout($entry(c), 1);
}-*/;

}
