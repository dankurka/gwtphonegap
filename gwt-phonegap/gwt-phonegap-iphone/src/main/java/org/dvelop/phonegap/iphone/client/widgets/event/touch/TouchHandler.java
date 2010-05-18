package org.dvelop.phonegap.iphone.client.widgets.event.touch;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import org.dvelop.phonegap.iphone.client.widgets.event.MultipleHandlerRegistration;

public interface TouchHandler extends TouchStartHandler, TouchMoveHandler, TouchCancelHandler, TouchEndHandler {


}