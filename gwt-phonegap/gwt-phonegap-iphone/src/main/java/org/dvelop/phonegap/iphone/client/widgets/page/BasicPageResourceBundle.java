package org.dvelop.phonegap.iphone.client.widgets.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

/**
 * User: daniel kurka
 * Date: 24.05.2010
 * Time: 14:25:43
 */
public interface BasicPageResourceBundle extends ClientBundle{
    public static final BasicPageResourceBundle INSTANCE = GWT.create(BasicPageResourceBundle.class);

    @Source("org/dvelop/phonegap/iphone/public/css/basicPagePanel.css")
    public BasicPagePanelCssResource css();
}
