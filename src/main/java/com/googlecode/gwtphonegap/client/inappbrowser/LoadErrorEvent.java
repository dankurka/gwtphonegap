/*
 * Copyright 2014 Daniel Kurka
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

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author vkiran
 */
public class LoadErrorEvent  extends GwtEvent<LoadErrorHandler> {


    private static final GwtEvent.Type<LoadErrorHandler> TYPE = new Type<LoadErrorHandler>();

    public static GwtEvent.Type<LoadErrorHandler> getType() {
        return TYPE;
    }

    private final String url;

    public LoadErrorEvent(String url) {
        this.url = url;

    }
    @Override
    public Type<LoadErrorHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(LoadErrorHandler handler) {
    handler.onLoadError(this);
    }

    public String getUrl() {
        return url;
    }
}
