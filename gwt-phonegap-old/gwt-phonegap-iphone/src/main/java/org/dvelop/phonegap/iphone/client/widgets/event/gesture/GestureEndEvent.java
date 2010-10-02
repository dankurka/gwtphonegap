/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.gesture;

/**
 * @author mchrist
 *
 */
public class GestureEndEvent extends GestureEvent<GestureEndHandler> {
	private static final Type<GestureEndHandler> TYPE = new Type<GestureEndHandler>(
			"gestureend", new GestureEndEvent(null));

	public GestureEndEvent(NativeGestureEvent nativeGestureEvent) {
		super(nativeGestureEvent);
	}

	@Override
	public Type<GestureEndHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GestureEndHandler handler) {
		handler.onGestureEnd(this);
	}

	public static Type<GestureEndHandler> getType() {
		return TYPE;
	}

}