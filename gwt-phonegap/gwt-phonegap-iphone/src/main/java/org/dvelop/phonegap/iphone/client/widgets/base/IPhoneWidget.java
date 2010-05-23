package org.dvelop.phonegap.iphone.client.widgets.base;

import com.google.gwt.event.dom.client.*;
import org.dvelop.phonegap.iphone.client.util.IPhoneUtil;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import org.dvelop.phonegap.iphone.client.widgets.event.HasTouchHandler;
import org.dvelop.phonegap.iphone.client.widgets.event.MultipleHandlerRegistration;
import org.dvelop.phonegap.iphone.client.widgets.event.gesture.*;
import org.dvelop.phonegap.iphone.client.widgets.event.touch.*;
import org.dvelop.phonegap.iphone.client.widgets.event.touch.TouchHandler;
import org.dvelop.phonegap.iphone.client.widgets.event.transition.NativeTransitionEvent;
import org.dvelop.phonegap.iphone.client.widgets.event.transition.TransitionEndEvent;
import org.dvelop.phonegap.iphone.client.widgets.event.transition.TransitionEndHandler;

/**
 * Created by IntelliJ IDEA.
 * User: daniel.kurka
 * Date: 09.05.2010
 * Time: 23:59:44
 */
public class IPhoneWidget extends Widget {


    public IPhoneWidget(String tagName) {
        setElement(Document.get().createElement(tagName));
    }

    protected HandlerRegistration addTransitionEndHandler(TransitionEndHandler transitionEndHandler) {
        return addHandler(transitionEndHandler, TransitionEndEvent.getType());
    }

    protected HandlerRegistration addTouchStartHandler(TouchStartHandler touchStartHandler) {
        return addHandler(touchStartHandler, TouchStartEvent.getType());
    }

    protected HandlerRegistration addTouchMoveHandler(TouchMoveHandler touchMoveHandler) {
        return addHandler(touchMoveHandler, TouchMoveEvent.getType());
    }

    protected HandlerRegistration addTouchEndHandler(TouchEndHandler touchEndHandler) {
        return addHandler(touchEndHandler, TouchEndEvent.getType());

    }

    protected HandlerRegistration addTouchCancelHandler(TouchCancelHandler touchCancelHandler) {
        return addHandler(touchCancelHandler, TouchCancelEvent.getType());

    }

    protected HandlerRegistration addTouchHandler(TouchHandler touchHandler) {
        MultipleHandlerRegistration registration = new MultipleHandlerRegistration();
        registration.addHandlerRegistration(addTouchStartHandler(touchHandler));
        registration.addHandlerRegistration(addTouchMoveHandler(touchHandler));
        registration.addHandlerRegistration(addTouchCancelHandler(touchHandler));
        registration.addHandlerRegistration(addTouchEndHandler(touchHandler));
        return registration;
    }

    protected HandlerRegistration addGestureStartHandler(GestureStartHandler gestureStartHandler) {
        return addHandler(gestureStartHandler, GestureStartEvent.getType());

    }

    protected HandlerRegistration addGestureChangeHandler(GestureChangeHandler gestureChangeHandler) {
        return addHandler(gestureChangeHandler, GestureChangeEvent.getType());

    }

    protected HandlerRegistration addGestureEndHandler(GestureEndHandler gestureEndHandler) {
        return addHandler(gestureEndHandler, GestureEndEvent.getType());

    }

    protected HandlerRegistration addGestureHandler(GestureHandler gestureHandler) {
        MultipleHandlerRegistration registration = new MultipleHandlerRegistration();

        registration.addHandlerRegistration(addGestureStartHandler(gestureHandler));
        registration.addHandlerRegistration(addGestureChangeHandler(gestureHandler));
        registration.addHandlerRegistration(addGestureEndHandler(gestureHandler));

        return registration;
    }


    @Override
    protected void onLoad() {
        super.onLoad();
        setUpEventsHooks();

    }

    private class MouseToTouchConverter implements MouseDownHandler, MouseUpHandler, MouseMoveHandler {

        public void onMouseUp(MouseUpEvent event) {
            fireEvent(new TouchEndEvent(new MockedNativeTouchEvent(event.getNativeEvent())));
        }

        public void onMouseMove(MouseMoveEvent event) {
            fireEvent(new TouchMoveEvent(new MockedNativeTouchEvent(event.getNativeEvent())));
        }

        public void onMouseDown(MouseDownEvent event) {
            fireEvent(new TouchStartEvent(new MockedNativeTouchEvent(event.getNativeEvent())));
        }
    }

    private MultipleHandlerRegistration handlerRegistration;

    private void setUpEventsHooks() {
        if (this.isAttached()) {
            if (IPhoneUtil.hasTouchEvent()) {
                registerTouchEvents();
                registerGestureEvents();
            } else {
                //this is done for others browser than apple mobile (test in hosted mode)
                MouseToTouchConverter touchConverter = new MouseToTouchConverter();
                handlerRegistration = new MultipleHandlerRegistration();
                handlerRegistration.addHandlerRegistration(addDomHandler(touchConverter, MouseDownEvent.getType()));
                handlerRegistration.addHandlerRegistration(addDomHandler(touchConverter, MouseMoveEvent.getType()));
                handlerRegistration.addHandlerRegistration(addDomHandler(touchConverter, MouseUpEvent.getType()));
            }

            registerTransistionEndDomEvent();
        }
    }

    private void tearDownEventHooks() {

        if (IPhoneUtil.hasTouchEvent()) {
            unregisterTouchEvents();
            unregisterGestureEvents();
        } else {
            handlerRegistration.removeHandler();
        }


        unregisterTransitionEndDomEvent();


    }

    @Override
    protected void onUnload() {
        super.onUnload();
        tearDownEventHooks();

    }


    //
    //  touch call backs called from jsni
    //

    private void onDomTouchStart(NativeTouchEvent event) {
        fireEvent(new TouchStartEvent(event));
    }

    private void onDomTouchMove(NativeTouchEvent event) {
        fireEvent(new TouchMoveEvent(event));
    }

    private void onDomTouchEnd(NativeTouchEvent event) {
        fireEvent(new TouchEndEvent(event));
    }

    private void onDomTouchCancel(NativeTouchEvent event) {
        fireEvent(new TouchCancelEvent(event));
    }


    //set up native touch event handlers

    private native void registerTouchEvents() /*-{
		var instance = this;
		var element = this.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::getElement()();

		element.ontouchstart = function(e){
			instance.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::onDomTouchStart(Lorg/dvelop/phonegap/iphone/client/widgets/event/touch/NativeTouchEvent;)(e);
		};

		element.ontouchmove = function(e){
			instance.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::onDomTouchMove(Lorg/dvelop/phonegap/iphone/client/widgets/event/touch/NativeTouchEvent;)(e);
		};

		element.ontouchend = function(e){
			instance.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::onDomTouchEnd(Lorg/dvelop/phonegap/iphone/client/widgets/event/touch/NativeTouchEvent;)(e);
		};

        element.ontouchcancel = function(e){
        instance.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::onDomTouchCancel(Lorg/dvelop/phonegap/iphone/client/widgets/event/touch/NativeTouchEvent;)(e);
        };





	}-*/;

    //remove native touch events

    private native void unregisterTouchEvents() /*-{
		var instance = this;
		var element = this.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::getElement()();
		element.ontouchstart = null;
		element.ontouchmove = null;
		element.ontouchend = null;
        element.ontochcancel = null;
	}-*/;


    private void onDomTransitionEnded(NativeTransitionEvent event) {
        fireEvent(new TransitionEndEvent(event));
    }


    //transistion events


    private native void registerTransistionEndDomEvent() /*-{
        var instance = this;
		var element = this.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::getElement()();
		var callBack = function(e){
	        instance.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::onDomTransitionEnded(Lorg/dvelop/phonegap/iphone/client/widgets/event/transition/NativeTransitionEvent;)(e);
		};

		element.webkittransitionend = callBack;
    }-*/;

    private native void unregisterTransitionEndDomEvent() /*-{
        var instance = this;
		var element = this.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::getElement()();
        element.webkittransitionend = null;
    }-*/;

    //gesture events

    private void onDomGestureStart(NativeGestureEvent event) {
        fireEvent(new GestureStartEvent(event));
    }

    private void onDomGestureChange(NativeGestureEvent event) {
        fireEvent(new GestureChangeEvent(event));
    }

    private void onDomGestureEnd(NativeGestureEvent event) {
        fireEvent(new GestureEndEvent(event));
    }


    private native void registerGestureEvents() /*-{
        var instance = this;
		var element = this.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::getElement()();

        element.ongesturestart = function(e){
        instance.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::onDomGestureStart(Lorg/dvelop/phonegap/iphone/client/widgets/event/gesture/NativeGestureEvent;)(e);
        };

        element.ongesturechange = function(e){
        instance.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::onDomGestureChange(Lorg/dvelop/phonegap/iphone/client/widgets/event/gesture/NativeGestureEvent;)(e);
        };

        element.ongestureend = function(e){
        instance.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::onDomGestureEnd(Lorg/dvelop/phonegap/iphone/client/widgets/event/gesture/NativeGestureEvent;)(e);
        };
    }-*/;

    private native void unregisterGestureEvents() /*-{
        var instance = this;
		var element = this.@org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::getElement()();
        element.ongesturestart = null;
        element.ongesturechange = null;
        element.ongestureend = null;
    }-*/;

}
