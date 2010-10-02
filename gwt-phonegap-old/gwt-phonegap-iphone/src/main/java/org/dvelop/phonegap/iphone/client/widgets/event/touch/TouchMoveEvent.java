/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.touch;

import com.google.gwt.event.dom.client.DomEvent;

/**
 * @author mchrist
 *
 */
public class TouchMoveEvent extends TouchEvent<TouchMoveHandler> {
	private static final DomEvent.Type<TouchMoveHandler> TYPE = new DomEvent.Type<TouchMoveHandler>(
			"touchmove", new TouchMoveEvent(null));

	/**
	 *
	 */
	public TouchMoveEvent(NativeTouchEvent nativeTouchEvent) {
		super(nativeTouchEvent);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.google.gwt.event.dom.client.DomEvent#getAssociatedType()
	 */
	@Override
	public DomEvent.Type<TouchMoveHandler> getAssociatedType() {
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
	protected void dispatch(TouchMoveHandler handler) {
		handler.onTouchMove(this);
	}

	public static DomEvent.Type<TouchMoveHandler> getType() {
		return TYPE;
	}

}