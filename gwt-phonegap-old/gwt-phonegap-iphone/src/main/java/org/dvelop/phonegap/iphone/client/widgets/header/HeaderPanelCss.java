package org.dvelop.phonegap.iphone.client.widgets.header;

import com.google.gwt.resources.client.CssResource;

/**
 * User: daniel kurka
 * Date: 11.05.2010
 * Time: 06:49:17
 */
public interface HeaderPanelCss extends CssResource {

    @ClassName("backButton")
    String backButtonClass();

    @ClassName("backButtonPosRight")
    String backButtonPosRight();

    @ClassName("backButtonPosLeft")
    String backButtonPosLeft();

    @ClassName("backButtonStartAnimate")
    String backButtonStartAnimate();

    @ClassName("backButtonStopAnimate")
    String backButtonStopAnimate();

    @ClassName("forwardButton")
    String forwardButtonClass();

    @ClassName("forwardButtonPosRight")
    String forwardButtonPosRight();

    @ClassName("forwardButtonPosLeft")
    String forwardButtonPosLeft();

    @ClassName("forwardButtonStartAnimate")
    String forwardButtonStartAnimate();

    @ClassName("forwardButtonStopAnimate")
    String forwardButtonStopAnimate();

    @ClassName("title")
    String titleClass();

    @ClassName("titlePosRight")
    String titlePosRight();

    @ClassName("titlePosLeft")
    String titlePosLeft();

    @ClassName("titleStartAnimate")
    String titleStartAnimate();

    @ClassName("titleStopAnimate")
    String titleStopAnimate();

    @ClassName("header")
    String headerClass();

}
