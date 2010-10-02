package org.dvelop.phonegap.iphone.client.widgets.event;

import com.google.gwt.event.shared.HandlerRegistration;
import org.dvelop.phonegap.iphone.client.widgets.event.touch.SimpleTouchHandler;

/**
 * User: daniel kurka
 * Date: 22.05.2010
 * Time: 22:46:20
 */
public interface HasSimpleTouchHandler {

    public HandlerRegistration addSimpleTouchHandler(SimpleTouchHandler handler);
}
