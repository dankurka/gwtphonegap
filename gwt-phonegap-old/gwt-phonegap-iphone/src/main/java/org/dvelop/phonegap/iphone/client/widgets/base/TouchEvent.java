package org.dvelop.phonegap.iphone.client.widgets.base;

import com.google.gwt.event.shared.GwtEvent;

/**
 * User: daniel kurka
 * Date: 10.05.2010
 * Time: 00:00:51
 */
public class TouchEvent extends GwtEvent<TouchHandler> {
    private static final Type<TouchHandler> TYPE = new Type<TouchHandler>();

    private IPhoneWidget source;

    public TouchEvent(IPhoneWidget source) {
        this.source = source;
    }


    @Override
    public Type<TouchHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(TouchHandler handler) {
        handler.onTouch(this);
    }

    public static Type<?> getType() {
        return TYPE;
    }


    public IPhoneWidget getSource() {
        return source;
    }
}
