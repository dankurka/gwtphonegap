package org.dvelop.phonegap.iphone.client.widgets.list;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import org.dvelop.phonegap.iphone.client.widgets.footer.FooterPanelCss;

/**
 * User: christian hemker
 * Date: 22.05.2010
 * Time: 19:20:27
 */
public interface ListViewPanelCssBundle extends ClientBundle{

    public static final ListViewPanelCssBundle INSTANCE = GWT.create(ListViewPanelCssBundle.class);

    @Source("org/dvelop/phonegap/iphone/public/css/listview.css")
    ListViewPanelCss css();
}