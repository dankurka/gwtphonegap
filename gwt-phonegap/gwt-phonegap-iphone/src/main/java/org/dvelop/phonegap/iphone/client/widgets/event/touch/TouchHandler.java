package org.dvelop.phonegap.iphone.client.widgets.event.touch;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import org.dvelop.phonegap.iphone.client.widgets.event.MultipleHandlerRegistration;

public interface TouchHandler extends TouchStartHandler, TouchMoveHandler,
		TouchCancelHandler, TouchEndHandler {

    public static class TouchHandlerRegistration extends MultipleHandlerRegistration {
        public void putHandlerRegistration(GwtEvent.Type<?> type, HandlerRegistration registration){
            super.putHandlerRegistration(type, registration);
        }

//        public HandlerRegistration getTouchStartHandlerRegistration(){
//            return getHandlerRegistration(TouchStartEvent.getType());
//        }

//        registration.putHandlerRegistration(TouchStartEvent.getType(), startRegistration);
//        registration.putHandlerRegistration(TouchMoveEvent.getType(), moveRegistration);
//        registration.putHandlerRegistration(TouchCancelEvent.getType(), canelRegistration);
//        registration.putHandlerRegistration(TouchEndEvent.getType(), endRegistration);


    }
}