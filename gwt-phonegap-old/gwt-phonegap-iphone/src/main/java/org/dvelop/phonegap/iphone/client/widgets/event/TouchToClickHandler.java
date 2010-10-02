package org.dvelop.phonegap.iphone.client.widgets.event;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import org.dvelop.phonegap.iphone.client.widgets.event.touch.*;


/**
 * User: daniel kurka
 * Date: 18.05.2010
 * Time: 23:08:55
 */
public class TouchToClickHandler implements TouchHandler {
    private boolean moved;
    private boolean started;
    private SimpleTouchHandler touchHandler;

    public TouchToClickHandler(SimpleTouchHandler handler) {
        assert handler != null;
        this.touchHandler = handler;
    }

    public void onTouchEnd(TouchEndEvent touchEndEvent) {
        //touchEndEvent.getNativeTouchEvent().preventDefault();
        if (started) {
            started = false;
            if (!moved) {
                moved = false;
                touchHandler.onTouch();
            }
        }
    }

    public void onTouchMove(TouchMoveEvent touchMoveEvent) {
        //touchMoveEvent.getNativeTouchEvent().preventDefault();
        moved = true;
    }

    public void onTouchStart(TouchStartEvent touchStartEvent) {
        //touchStartEvent.getNativeTouchEvent().preventDefault();
        started = true;
        moved = false;
    }

    public void onTouchCancel(TouchCancelEvent touchCancelEvent) {
        //touchCancelEvent.getNativeTouchEvent().preventDefault();
        started = false;
        moved = false;
    }
}
