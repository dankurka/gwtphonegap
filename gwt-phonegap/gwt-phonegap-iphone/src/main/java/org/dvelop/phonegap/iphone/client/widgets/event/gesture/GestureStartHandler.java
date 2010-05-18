/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.gesture;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author mchrist
 *
 */
public interface GestureStartHandler extends EventHandler {

	void onGestureStart(GestureStartEvent gestureStartEvent);

}