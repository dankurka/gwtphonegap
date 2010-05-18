/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.gesture;

import com.google.gwt.event.dom.client.DomEvent;

/**
 * @author mchrist
 *
 */
public class GestureStartEvent extends GestureEvent<GestureStartHandler> {
	private static final DomEvent.Type<GestureStartHandler> TYPE = new DomEvent.Type<GestureStartHandler>(
			"gesturestart", new GestureStartEvent(null));

	public GestureStartEvent(NativeGestureEvent nativeGestureEvent) {
		super(nativeGestureEvent);
	}

	@Override
	public DomEvent.Type<GestureStartHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GestureStartHandler handler) {
		handler.onGestureStart(this);
	}

	public static DomEvent.Type<GestureStartHandler> getType() {
		return TYPE;
	}

}