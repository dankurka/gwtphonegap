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

import com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowser;
import com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowserReference;

public class InAppBrowserJsImpl implements InAppBrowser {

  @Override
  public InAppBrowserReference open(String url, String windowName, String windowFeatures) {
    JavaScriptObject ref = open0(url, windowName, windowFeatures);
    return new InAppBrowserReferenceJsImpl(ref);
  }

  public native JavaScriptObject open0(String url, String windowName, String windowFeatures)/*-{
		return $wnd.open(url, windowName, windowFeatures);
  }-*/;

}
