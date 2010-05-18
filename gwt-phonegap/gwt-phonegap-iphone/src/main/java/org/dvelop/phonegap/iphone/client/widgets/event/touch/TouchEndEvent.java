/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.touch;

import com.google.gwt.event.dom.client.DomEvent;


/**
 * @author mchrist
 *
 */
public class TouchEndEvent extends TouchEvent<TouchEndHandler> {
	private static final DomEvent.Type<TouchEndHandler> TYPE = new DomEvent.Type<TouchEndHandler>(
			"touchend", new TouchEndEvent(null));

	/**
	 *
	 */
	public TouchEndEvent(NativeTouchEvent nativeTouchEvent) {
		super(nativeTouchEvent);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.google.gwt.event.dom.client.DomEvent#getAssociatedType()
	 */
	@Override
	public DomEvent.Type<TouchEndHandler> getAssociatedType() {
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
	protected void dispatch(TouchEndHandler handler) {
		handler.onTouchEnd(this);
	}

	public static DomEvent.Type<TouchEndHandler> getType() {
		return TYPE;
	}

}