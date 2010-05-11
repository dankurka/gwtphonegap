package org.dvelop.phonegap.iphone.gui.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import org.dvelop.phonegap.iphone.client.widgets.base.TouchEvent;
import org.dvelop.phonegap.iphone.client.widgets.base.TouchHandler;
import org.dvelop.phonegap.iphone.client.widgets.header.HeaderPanelAnimation;
import org.dvelop.phonegap.iphone.client.widgets.header.HeaderPanelResourceBundle;
import org.dvelop.phonegap.iphone.client.widgets.header.HeaderPanel;
import org.dvelop.phonegap.iphone.client.widgets.standard.StandardIphoneBundle;

/**
 * User: daniel kurka
 * Date: 10.05.2010
 * Time: 23:43:46
 */
public class IphoneEntryPoint implements EntryPoint{
    public void onModuleLoad() {
        //Window.alert("test");

        StandardIphoneBundle.INSTANCE.css().ensureInjected();

        HeaderPanelResourceBundle.INSTANCE.css().ensureInjected();

        final HeaderPanel panel = new HeaderPanel();

        panel.setBackButtonText("back");
        panel.setTitleText("Title");

        panel.addBackButtonListener(new TouchHandler(){

            public void onTouch(TouchEvent event) {
                HeaderPanelAnimation animation = new HeaderPanelAnimation();
                animation.setBackButton(true);
                animation.setBackButtonText("bb");
                animation.setForwardButton(true);
                animation.setForwardButtonText("bla");
                animation.setTitle("jo");

                panel.moveBackward(animation);

            }
        });
        

        RootPanel.get().add(panel);
    }
}
