package org.dvelop.phonegap.iphone.client.widgets.base;

import com.google.gwt.event.shared.HandlerRegistration;
import org.dvelop.phonegap.iphone.client.widgets.event.MultipleHandlerRegistration;
import org.dvelop.phonegap.iphone.client.widgets.event.TouchToClickHandler;
import org.dvelop.phonegap.iphone.client.widgets.event.touch.*;
import org.dvelop.phonegap.iphone.client.widgets.event.touch.TouchHandler;

/**
 * User: daniel kurka
 * Date: 18.05.2010
 * Time: 21:19:43
 */
public class TouchableIPhoneWidget extends IPhoneWidget {

    public TouchableIPhoneWidget(String tagName) {
        super(tagName);
    }

    public HandlerRegistration addTouchHandler(TouchHandler touchHandler) {
        return addTouchHandler(touchHandler);
    }

    

}
