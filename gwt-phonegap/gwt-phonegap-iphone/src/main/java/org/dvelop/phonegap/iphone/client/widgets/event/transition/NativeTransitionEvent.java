/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.transition;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author mchrist
 *
 */
public class NativeTransitionEvent extends JavaScriptObject {

	/**
	 * must be protected
     * this is only constructed by the browser
	 */
	protected NativeTransitionEvent() {
	}

	public final native void preventDefault() /*-{
		return this.preventDefault();
	}-*/;

	/**
	 * elapsedTime The duration of the transition, in seconds, since this event
	 * was sent. This value is not affected by the value of the CSS
	 * -webkit-transition-delay property.
	 *
	 * Available in Safari 4.0 and later. Available in iPhone OS 2.0 and later.
	 *
	 * @return
	 */
	public final native double getElapsedTime() /*-{
		return this.elapsedTime;
	}-*/;

	/**
	 * propertyName The name of the CSS property associated with the transition.
	 *
	 * Available in Safari 4.0 and later. Available in iPhone OS 2.0 and later.
	 *
	 * @return
	 */
	public final native String getPropertyName() /*-{
		return this.propertyName;
	}-*/;

}