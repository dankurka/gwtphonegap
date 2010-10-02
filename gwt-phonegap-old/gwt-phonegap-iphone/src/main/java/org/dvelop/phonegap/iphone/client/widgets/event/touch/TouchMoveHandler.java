/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.touch;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author mchrist
 *
 */
public interface TouchMoveHandler extends EventHandler {

	void onTouchMove(TouchMoveEvent touchMoveEvent);

}