/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.touch;

import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.shared.EventHandler;

/**
 * @author mchrist
 *
 */
public abstract class TouchEvent<H extends EventHandler> extends DomEvent<H> {
	private NativeTouchEvent nativeTouchEvent;

	public TouchEvent(NativeTouchEvent nativeTouchEvent) {
		this.nativeTouchEvent = nativeTouchEvent;
	}

	public NativeTouchEvent getNativeTouchEvent() {
		return nativeTouchEvent;
	}
}