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
package com.googlecode.gwtphonegap.client.inappbrowser;

import com.google.web.bindery.event.shared.HandlerRegistration;

public interface InAppBrowserReference {
  public HandlerRegistration addLoadStartHandler(LoadStartHandler handler);

  public HandlerRegistration addLoadStopHandler(LoadStopHandler handler);

  public HandlerRegistration addExitHandler(ExitHandler handler);

    public HandlerRegistration addLoadErrorHandler(LoadErrorHandler handler);

  public void close();

  void show();

    /**
     * Injects JavaScript code into the InAppBrowser window
     * @param code :details of the script to run, specifying Text of the script to inject.
     * @param callback : the function that executes after the JavaScript code is injected.
     * If the injected script is of type code, the callback executes with a single parameter,
     * which is the return value of the script, wrapped in an Array.
     * For multi-line scripts, this is the return value of the last statement,
     * or the last expression evaluated.
     */
  void executeScript(String code, InAppBrowserCallback  callback);

    /**
     * Injects JavaScript code into the InAppBrowser window
     * @param url : details of the script to run, specifying URL of the script to inject.
     * @param callback : the function that executes after the JavaScript code is injected.
     */
  void executeScriptFromUrl(String url, InAppBrowserCallback  callback);

    /**
     * Injects CSS into the InAppBrowser window.
     * @param css : details of the script to run, specifying Text of the stylesheet to inject.
     * @param callback : the function that executes after the CSS is injected.
     */
  void injectCss(String css, InAppBrowserCallback  callback);

    /**
     * Injects CSS into the InAppBrowser window.
     * @param url :details of the script to run, specifying URL of the stylesheet to inject.
     * @param callback : the function that executes after the CSS is injected.
     */
  void injectCssFromUrl(String url, InAppBrowserCallback  callback);
}
