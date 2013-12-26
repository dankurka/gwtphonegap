package com.googlecode.gwtphonegap.client.inappbrowser;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by vkiran on 11/24/13.
 */
public interface LoadErrorHandler  extends EventHandler {

    public void onLoadError(LoadErrorEvent event);
}
