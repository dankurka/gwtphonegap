package org.dvelop.phonegap.iphone.client.widgets.header;

import com.google.gwt.user.client.ui.Widget;

/**
 * User: daniel kurka
 * Date: 11.05.2010
 * Time: 00:11:01
 */
public class HeaderPanelAnimation {
    public HeaderPanelAnimation() {
        forwardButton = false;
        forwardButtonText = "";
        backButton = false;
        backButtonText = "";
        this.title = "";
    }


    private boolean forwardButton;

    public String getForwardButtonText() {
        return forwardButtonText;
    }

    public void setForwardButtonText(String forwardButtonText) {
        this.forwardButtonText = forwardButtonText;
    }

    public boolean isBackButton() {
        return backButton;
    }

    public void setBackButton(boolean backButton) {
        this.backButton = backButton;
    }

    public String getBackButtonText() {
        return backButtonText;
    }

    public void setBackButtonText(String backButtonText) {
        this.backButtonText = backButtonText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    private String forwardButtonText;
    private boolean backButton;
    private String backButtonText;
    private String title;


    public boolean isForwardButton() {
        return forwardButton;
    }

    public void setForwardButton(boolean forwardButton) {
        this.forwardButton = forwardButton;
    }
}
