package org.dvelop.phonegap.iphone.client.widgets.footer;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * User: daniel kurka
 * Date: 11.05.2010
 * Time: 09:26:06
 */
public class FooterPanel extends FlowPanel {


    public FooterPanel() {
        super();

        FooterPanelCssBundle.INSTANCE.css().ensureInjected();
        setStyleName(FooterPanelCssBundle.INSTANCE.css().footerClass());

    }
}
