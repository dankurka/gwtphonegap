package org.dvelop.phonegap.iphone.client.widgets.css;

import com.google.gwt.resources.client.CssResource;

/**
 * User: daniel kurka
 * Date: 16.05.2010
 * Time: 18:22:58
 */
public interface StandardCss extends CssResource {
    @ClassName("progressIndicator")
    String progressIndicatorClass();
    @ClassName("progressIndicatorText")
    String progressIndicatorTextClass();
}
