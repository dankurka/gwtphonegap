package org.dvelop.phonegap.iphone.client.widgets.event.gesture;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.EventTarget;

/**
 * User: martin christ
 * Date: 18.05.2010
 * Time: 18:21:01
 */
public class NativeGestureEvent extends JavaScriptObject {

	/**
	 * must be protected
     * event is contructed by browser only
	 */
	protected NativeGestureEvent() {
	}

	public final native void preventDefault() /*-{
		return this.preventDefault();
	}-*/;

	/**
	 * altKey If true, the alt key is pressed; otherwise, it is not. If there is
	 * no keyboard, this value is false.
	 *
	 * Available in iPhone OS 2.0 and later.
	 *
	 * @return
	 */
	public final native boolean getAltKey() /*-{
		return this.altKey;
	}-*/;

	/**
	 * ctrlKey If true, the control key is pressed; otherwise, it is not. If
	 * there is no keyboard, this value is false.
	 *
	 * Available in iPhone OS 2.0 and later.
	 *
	 * @return
	 */
	public final native boolean getCtrlKey() /*-{
		return this.ctrlKey;
	}-*/;

	/**
	 * shiftKey If true, the Shift key is pressed; otherwise, it is not. If
	 * there is no keyboard, this value is false.
	 *
	 * Available in iPhone OS 2.0 and later.
	 *
	 * @return
	 */
	public final native boolean getShiftKey() /*-{
		return this.shiftKey;
	}-*/;

	/**
	 * metaKey If true, the meta key is pressed; otherwise, it is not. If there
	 * is no keyboard, this value is false.
	 *
	 * Available in iPhone OS 2.0 and later.
	 *
	 * @return
	 */
	public final native boolean getMetaKey() /*-{
		return this.metaKey;
	}-*/;

	/**
	 * rotation The delta rotation since the start of an event, in degrees,
	 * where clockwise is positive and counter-clockwise is negative. The
	 * initial value is 0.0.
	 *
	 * Available in iPhone OS 2.0 and later.
	 *
	 * @return
	 */
	public final native float getRotation() /*-{
		return this.rotation;
	}-*/;

	/**
	 * scale The distance between two fingers since the start of an event, as a
	 * multiplier of the initial distance. The initial value is 1.0. If less
	 * than 1.0, the gesture is pinch close (to zoom out). If greater than 1.0,
	 * the gesture is pinch open (to zoom in).
	 *
	 * Available in iPhone OS 2.0 and later.
	 *
	 * @return
	 */
	public final native float getScale() /*-{
		return this.scale;
	}-*/;

	/**
	 * target The target of this gesture.
	 *
	 * Available in iPhone OS 2.0 and later.
	 *
	 * @return
	 */
	public final native EventTarget getTarget() /*-{
		return this.target;
	}-*/;

}
