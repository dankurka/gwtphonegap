package org.dvelop.phonegap.iphone.client.widgets.footer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

/**
 * User: daniel kurka
 * Date: 11.05.2010
 * Time: 10:10:27
 */
public interface FooterPanelCssBundle extends ClientBundle{

    public static final FooterPanelCssBundle INSTANCE = GWT.create(FooterPanelCssBundle.class);

    @Source("org/dvelop/phonegap/iphone/public/css/footer.css")
    FooterPanelCss css();
}
