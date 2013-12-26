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

import com.google.gwt.event.shared.HandlerManager;
import com.google.web.bindery.event.shared.HandlerRegistration;

public abstract class InAppBrowserReferenceBaseImpl implements InAppBrowserReference {

  private HandlerManager handlerManager;

  @Override
  public abstract void close();

  @Override
  public HandlerRegistration addExitHandler(ExitHandler handler) {
    addJavaScriptHandlers();
    return handlerManager.addHandler(ExitEvent.getType(), handler);
  }

  @Override
  public HandlerRegistration addLoadStartHandler(LoadStartHandler handler) {
    addJavaScriptHandlers();
    return handlerManager.addHandler(LoadStartEvent.getType(), handler);
  }

  @Override
  public HandlerRegistration addLoadStopHandler(LoadStopHandler handler) {
    addJavaScriptHandlers();
    return handlerManager.addHandler(LoadStopEvent.getType(), handler);
  }

    @Override
    public HandlerRegistration addLoadErrorHandler(LoadErrorHandler handler){
    addJavaScriptHandlers();
    return handlerManager.addHandler(LoadErrorEvent.getType(),handler);
    }
  protected HandlerManager createHandlerManager() {
    return new HandlerManager(this);
  }

  protected void ensureHandlers() {
    if (handlerManager == null) {
      handlerManager = createHandlerManager();
      addJavaScriptHandlers();
    }
  }

  protected abstract void addJavaScriptHandlers();

  protected void fireLoadStartEvent(String url) {
    if (handlerManager != null) {
      handlerManager.fireEvent(new LoadStartEvent(url));
    }
  }

  protected void fireLoadStopEvent(String url) {
    if (handlerManager != null) {
      handlerManager.fireEvent(new LoadStopEvent(url));
    }
  }

  protected void fireExitEvent() {
    if (handlerManager != null) {
      handlerManager.fireEvent(new ExitEvent());
    }
  }

    protected  void fireLoadErrorEvent(String url){
        if(handlerManager != null){
            handlerManager.fireEvent(new LoadErrorEvent(url));
        }
    }
}
