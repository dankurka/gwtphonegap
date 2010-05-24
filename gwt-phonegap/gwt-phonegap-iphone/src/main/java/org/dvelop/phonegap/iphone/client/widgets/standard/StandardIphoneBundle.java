package org.dvelop.phonegap.iphone.client.widgets.standard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * User: daniel kurka
 * Date: 11.05.2010
 * Time: 00:36:33
 */
public interface StandardIphoneBundle extends ClientBundle{

     public static final StandardIphoneBundle INSTANCE = GWT.create(StandardIphoneBundle.class);

    @Source("org/dvelop/phonegap/iphone/public/css/standard.css")
    StandardIPhoneCssResource css();
}
