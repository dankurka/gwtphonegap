package org.dvelop.phonegap.iphone.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;


/**
 * User: daniel kurka
 * Date: 10.05.2010
 * Time: 22:11:27
 */
public interface HeaderPanelResourceBundle extends ClientBundle{

    @ClientBundle.Source("org/dvelop/phonegap/iphone/public/img/header_middle.png")
    ImageResource headerMiddle();

    @ClientBundle.Source("org/dvelop/phonegap/iphone/public/css/headerPanel.css")
    CssResource css();


}
