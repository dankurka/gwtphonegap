package com.dvelop.phonegap.iphone.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * User: daniel kurka
 * Date: 10.05.2010
 * Time: 21:48:00
 */
public interface IPhoneResourceBundle extends ClientBundle{
    public static final IPhoneResourceBundle INSTANCE = GWT.create(IPhoneResourceBundle.class);

    @Source("org/dvelop/phonegap/iphone/public/iphone.css")
    public CssResource stylesheet1();

}
