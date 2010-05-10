package com.dvelop.phonegap.iphone.client.widgets.base;

import com.dvelop.phonegap.iphone.client.util.IPhoneUtil;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by IntelliJ IDEA.
 * User: daniel.kurka
 * Date: 09.05.2010
 * Time: 23:59:44
 */
public class IPhoneWidget extends Widget {

    private boolean touchMoved;
    private HandlerRegistration handlerRegistration;


    public IPhoneWidget(String tagName) {
        setElement(Document.get().createElement(tagName));
    }


    public final HandlerRegistration addHandler(TouchHandler handler) {
        return this.addHandler(handler, (GwtEvent.Type<TouchHandler>) TouchEvent.getType());
    }


    @Override
    protected void onLoad() {
        setUpEventsHooks();
    }

    private void setUpEventsHooks() {
        if (this.isAttached()) {
            if (IPhoneUtil.hasTouchEvent(this.getElement())) {
                registerTouchEvents();
            } else {
                //this is done for others browser than apple mobile (test in hosted mode)
                handlerRegistration = this.addDomHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        event.preventDefault();
                        fireEvent(new TouchEvent(IPhoneWidget.this));
                    }
                }, ClickEvent.getType());
            }

            registerTransistionEndDomEvent();
        }
    }

    private void tearDownEventHooks() {

        if (IPhoneUtil.hasTouchEvent(this.getElement())) {
            unregisterTouchEvents();
        } else {
            handlerRegistration.removeHandler();
        }


        unregisterTransitionEndDomEvent();


    }

    @Override
    protected void onUnload() {
        tearDownEventHooks();
    }

    private void onDomTouchStart() {
        touchMoved = false;
    }

    private void onDomTouchMove() {
        touchMoved = true;
    }

    private void onDomTouchEnd() {
        if (touchMoved) {
            return;
        }

        fireEvent(new TouchEvent(this));
    }


    private void onDomTransitionEnded() {

    }

    private JavaScriptObject transitionCallbackEndFunction;


    private native void registerTouchEvents() /*-{
		var instance = this;
		var element = this.@com.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::getElement()();

		element.ontouchstart = function(e){
			instance.@com.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::onDomTouchStart()();
		};

		element.ontouchmove = function(e){
			instance.@com.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::onDomTouchMove()();
		};

		element.ontouchend = function(e){
			instance.@com.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::onDomTouchEnd()();
		};

	}-*/;

    private native void unregisterTouchEvents() /*-{
		var instance = this;
		var element = this.@com.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::getElement()();
		element.ontouchstart = null;
		element.ontouchmove = null;
		element.ontouchend = null;
	}-*/;

    private native void registerTransistionEndDomEvent() /*-{
        var instance = this;
		var element = this.@com.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::getElement()();

        try
		{


			var callBack = function(e){
				instance.@com.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::onDomTransitionEnded()();
			};

			element.addEventListener('webkitTransitionEnd', callBack, false);

            instance.@com.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::transitionCallbackEndFunction = callback;
		}
		catch (exception)
		{
		}
    }-*/;

    private native void unregisterTransitionEndDomEvent() /*-{
        var instance = this;
		var element = this.@com.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::getElement()();
        element.removeEventListener('webkitTransitionEnd', instance.@com.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget::transitionCallbackEndFunction, false);
    }-*/;

}
