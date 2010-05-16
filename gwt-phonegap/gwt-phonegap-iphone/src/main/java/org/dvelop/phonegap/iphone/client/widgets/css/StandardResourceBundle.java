package org.dvelop.phonegap.iphone.client.widgets.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

/**
 * User: daniel kurka
 * Date: 16.05.2010
 * Time: 18:22:33
 */
public interface StandardResourceBundle extends ClientBundle{
    public static final StandardResourceBundle INSTANCE = GWT.create(StandardResourceBundle.class);

    @Source("org/dvelop/phonegap/iphone/public/css/widgets.css")
    StandardCss css();
}
