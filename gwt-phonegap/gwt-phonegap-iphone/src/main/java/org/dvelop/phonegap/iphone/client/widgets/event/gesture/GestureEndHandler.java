/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.gesture;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author mchrist
 *
 */
public interface GestureEndHandler extends EventHandler {

	void onGestureEnd(GestureEndEvent gestureEndEvent);

}