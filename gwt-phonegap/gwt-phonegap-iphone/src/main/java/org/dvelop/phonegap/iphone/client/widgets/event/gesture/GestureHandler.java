package org.dvelop.phonegap.iphone.client.widgets.event.gesture;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public interface GestureHandler extends GestureStartHandler,
		GestureChangeHandler, GestureEndHandler {

    public static class GestureHandlerRegistration extends MultipleHandlerRegistration {
        public void putHandlerRegistration(GwtEvent.Type<?> type, HandlerRegistration registration){
            super.putHandlerRegistration(type, registration);
        }
    }

}