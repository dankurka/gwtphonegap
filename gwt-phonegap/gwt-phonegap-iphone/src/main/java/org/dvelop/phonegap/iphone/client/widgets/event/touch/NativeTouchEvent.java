/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.touch;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;

/**
 * @author mchrist
 * based on: http://www.sitepen.com/blog/2008/07/10/touching-and-gesturing-on-the-iphone/
 */
public class NativeTouchEvent extends JavaScriptObject {

	/**
	 * must be protected
     * native event is contructed by the browser only
	 */
	protected NativeTouchEvent() {
	}

	// clientX: X coordinate of touch relative to the viewport (excludes scroll
	// offset)
	// clientY: Y coordinate of touch relative to the viewport (excludes scroll
	// offset)
	// screenX: Relative to the screen
	// screenY: Relative to the screen
	// pageX: Relative to the full page (includes scrolling)
	// pageY: Relative to the full page (includes scrolling)
	// target: Node the touch event originated from
	// identifier: An identifying number, unique to each touch event



	public final native void preventDefault() /*-{
		return this.preventDefault();
	}-*/;



	public final native int getTouchCount() /*-{
		return this.touches.length;
	}-*/;

	public final native int getTargetTouchCount() /*-{
		return this.targetTouches.length;
	}-*/;

	public final native int getChangedTouchCount() /*-{
		return this.changedTouches.length;
	}-*/;

	/**
	 * information for a finger currently touching the screen.
	 * @param index
	 * @return
	 */
	public final native NativeEvent getTouch(int index) /*-{
		return this.touches[index];
	}-*/;

	/**
	 * like touch, but is filtered to only the information for finger touches that started out within the same node.
	 * @param index
	 * @return
	 */
	public final native NativeEvent getTargetTouch(int index) /*-{
		return this.targetTouches[index];
	}-*/;

	/**
	 * information for a finger involved in the event (see class description)
	 * @param index
	 * @return
	 */
	public final native NativeEvent getChangedTouch(int index) /*-{
		return this.changedTouches[index];
	}-*/;

}