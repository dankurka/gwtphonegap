package org.dvelop.phonegap.iphone.gui.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import org.dvelop.phonegap.iphone.client.widgets.header.HeaderPanel;

/**
 * User: daniel kurka
 * Date: 10.05.2010
 * Time: 23:43:46
 */
public class IphoneEntryPoint implements EntryPoint{
    public void onModuleLoad() {
        Window.alert("test");

        RootPanel.get().add(new HeaderPanel());
    }
}
