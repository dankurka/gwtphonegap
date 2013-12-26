package com.googlecode.gwtphonegap.client.inappbrowser;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by vkiran on 11/24/13.
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
