package org.dvelop.phonegap.iphone.client.widgets.base;

import com.google.gwt.event.shared.HandlerRegistration;
import org.dvelop.phonegap.iphone.client.widgets.event.MultipleHandlerRegistration;
import org.dvelop.phonegap.iphone.client.widgets.event.touch.*;

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
        MyTouchHandler myTouchHandler = new MyTouchHandler(touchHandler);
        MultipleHandlerRegistration registration = new MultipleHandlerRegistration();

        registration.putHandlerRegistration(TouchStartEvent.getType(), addTouchStartHandler(myTouchHandler));
        registration.putHandlerRegistration(TouchMoveEvent.getType(), addTouchMoveHandler(myTouchHandler));
        registration.putHandlerRegistration(TouchEndEvent.getType(), addTouchEndHandler(myTouchHandler));
        registration.putHandlerRegistration(TouchCancelEvent.getType(), addTouchCancelHandler(myTouchHandler));

        return registration;
    }

    private class MyTouchHandler implements TouchStartHandler, TouchCancelHandler, TouchMoveHandler, TouchEndHandler {
        private TouchHandler touchHandler;

        private boolean moved;
        private boolean started;

        public MyTouchHandler(TouchHandler handler) {
            assert handler != null;
            this.touchHandler = handler;
        }

        public void onTouchEnd(TouchEndEvent touchEndEvent) {
            if (started) {
                started = false;
                if (!moved) {
                    moved = false;
                    touchHandler.onTouch(new TouchEvent(TouchableIPhoneWidget.this));
                }
            }
        }

        public void onTouchMove(TouchMoveEvent touchMoveEvent) {
            moved = true;
        }

        public void onTouchStart(TouchStartEvent touchStartEvent) {
            started = true;
            moved = false;
        }

        public void onTouchCancel(TouchCancelEvent touchCancelEvent) {
            started = false;
            moved = false;
        }

    }
}
