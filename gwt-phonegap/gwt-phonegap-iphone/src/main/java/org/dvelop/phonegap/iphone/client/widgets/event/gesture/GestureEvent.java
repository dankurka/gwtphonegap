/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.gesture;

import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.shared.EventHandler;

/**
 * @author mchrist
 *
 */
public abstract class GestureEvent<H extends EventHandler> extends DomEvent<H> {
	private NativeGestureEvent nativeGestureEvent;

	public GestureEvent(NativeGestureEvent nativeGestureEvent) {
		this.nativeGestureEvent = nativeGestureEvent;
	}

	public NativeGestureEvent getNativeGestureEvent() {
		return nativeGestureEvent;
	}
}