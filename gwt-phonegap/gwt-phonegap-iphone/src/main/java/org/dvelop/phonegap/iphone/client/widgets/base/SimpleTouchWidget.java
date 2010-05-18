package org.dvelop.phonegap.iphone.client.widgets.base;

import com.google.gwt.event.shared.HandlerRegistration;
import org.dvelop.phonegap.iphone.client.widgets.event.TouchToClickHandler;
import org.dvelop.phonegap.iphone.client.widgets.event.touch.SimpleTouchHandler;

/**
 * User: daniel kurka
 * Date: 18.05.2010
 * Time: 23:18:40
 */
public class SimpleTouchWidget extends IPhoneWidget {
    public SimpleTouchWidget(String tagName) {
        super(tagName);
    }

    public HandlerRegistration addSimpleTouchHandler(SimpleTouchHandler handler) {
        return addTouchHandler(new TouchToClickHandler(handler));
    }
}
