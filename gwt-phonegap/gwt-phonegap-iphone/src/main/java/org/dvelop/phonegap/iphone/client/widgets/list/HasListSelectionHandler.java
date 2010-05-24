package org.dvelop.phonegap.iphone.client.widgets.list;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * User: daniel kurka
 * Date: 24.05.2010
 * Time: 22:13:09
 */
public interface HasListSelectionHandler {
    public HandlerRegistration addSelectionHandler(ListSelectionHandler listModelSelectionHandler);
}
