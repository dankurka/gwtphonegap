/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.touch;

import com.google.gwt.event.dom.client.DomEvent;


/**
 * @author mchrist
 *
 */
public class TouchCancelEvent extends TouchEvent<TouchCancelHandler> {
	private static final DomEvent.Type<TouchCancelHandler> TYPE = new DomEvent.Type<TouchCancelHandler>(
			"touchcancel", new TouchCancelEvent(null));

	/**
	 *
	 */
	public TouchCancelEvent(NativeTouchEvent nativeTouchEvent) {
		super(nativeTouchEvent);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.google.gwt.event.dom.client.DomEvent#getAssociatedType()
	 */
	@Override
	public DomEvent.Type<TouchCancelHandler> getAssociatedType() {
		return TYPE;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared
	 * .EventHandler)
	 */
	@Override
	protected void dispatch(TouchCancelHandler handler) {
		handler.onTouchCancel(this);
	}

	public static DomEvent.Type<TouchCancelHandler> getType() {
		return TYPE;
	}

}