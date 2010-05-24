package org.dvelop.phonegap.iphone.client.widgets.page;

import com.google.gwt.resources.client.CssResource;

/**
 * User: daniel kurka
 * Date: 24.05.2010
 * Time: 14:26:20
 */
public interface BasicPagePanelCssResource extends CssResource {

    @ClassName("movingPanel")
    public String movingPanel();
    @ClassName("movingPanelLeft")
    public String movingPanelLeft();
    @ClassName("movingPanelRight")
    public String movingPanelRight();
    @ClassName("movingPanelAnimate")
    public String movingPanelAnimate();
    @ClassName("movingPanelNormal")
    public String movingPanelNormal();


}
