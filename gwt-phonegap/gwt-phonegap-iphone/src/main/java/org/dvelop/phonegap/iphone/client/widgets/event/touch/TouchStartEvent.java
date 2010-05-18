/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.touch;

/**
 * @author mchrist
 *
 */
public class TouchStartEvent extends TouchEvent<TouchStartHandler> {
	private static final Type<TouchStartHandler> TYPE = new Type<TouchStartHandler>(
			"touchstart", new TouchStartEvent(null));

	public TouchStartEvent(NativeTouchEvent nativeTouchEvent) {
		super(nativeTouchEvent);
	}

	@Override
	public Type<TouchStartHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(TouchStartHandler handler) {
		handler.onTouchStart(this);
	}

	public static Type<TouchStartHandler> getType() {
		return TYPE;
	}

}