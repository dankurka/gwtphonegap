/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.gesture;

/**
 * @author mchrist
 *
 */
public class GestureChangeEvent extends GestureEvent<GestureChangeHandler> {
	private static final Type<GestureChangeHandler> TYPE = new Type<GestureChangeHandler>(
			"gesturechange", new GestureChangeEvent(null));

	public GestureChangeEvent(NativeGestureEvent nativeGestureEvent) {
		super(nativeGestureEvent);
	}

	@Override
	public Type<GestureChangeHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GestureChangeHandler handler) {
		handler.onGestureChange(this);
	}

	public static Type<GestureChangeHandler> getType() {
		return TYPE;
	}

}