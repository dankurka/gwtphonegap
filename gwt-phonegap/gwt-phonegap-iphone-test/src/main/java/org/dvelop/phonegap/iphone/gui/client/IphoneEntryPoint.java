package org.dvelop.phonegap.iphone.gui.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import org.dvelop.phonegap.iphone.client.widgets.buttons.RefreshButton;
import org.dvelop.phonegap.iphone.client.widgets.event.touch.SimpleTouchHandler;
import org.dvelop.phonegap.iphone.client.widgets.footer.FooterPanel;
import org.dvelop.phonegap.iphone.client.widgets.header.HeaderPanelAnimation;
import org.dvelop.phonegap.iphone.client.widgets.header.HeaderPanel;
import org.dvelop.phonegap.iphone.client.widgets.list.SimpleList;
import org.dvelop.phonegap.iphone.client.widgets.standard.StandardIphoneBundle;

import java.util.ArrayList;
import java.util.List;

/**
 * User: daniel kurka
 * Date: 10.05.2010
 * Time: 23:43:46
 */
public class IphoneEntryPoint implements EntryPoint {
    
    public void onModuleLoad() {
        StandardIphoneBundle.INSTANCE.css().ensureInjected();

        // generateHeaderPanelDemo( RootPanel.get());

        generateListViewPanel( RootPanel.get());
    }


    private void generateHeaderPanelDemo(RootPanel rootPanel){
        final HeaderPanel headerPanel = new HeaderPanel();

        headerPanel.setBackButtonText("back");
        headerPanel.setTitleText("Title");

        headerPanel.addBackButtonTouchHandler(new SimpleTouchHandler() {

            public void onTouch() {
                HeaderPanelAnimation animation = new HeaderPanelAnimation();
                animation.setBackButton(true);
                animation.setBackButtonText("first");
                animation.setForwardButton(true);
                animation.setForwardButtonText("forward");
                animation.setTitle("Title touched");

                headerPanel.moveBackwards(animation);


                //headerPanel.moveBackward(animation);
            }
        });

        rootPanel.add(headerPanel);

        FooterPanel footerPanel = new FooterPanel();

        RefreshButton refreshButton = new RefreshButton();
        footerPanel.add( refreshButton);

        rootPanel.add(footerPanel);
    }


    public void generateListViewPanel( RootPanel rootPanel) {
        StandardIphoneBundle.INSTANCE.css().ensureInjected();

        final HeaderPanel headerPanel = new HeaderPanel();

        headerPanel.setTitleText("Title");
        headerPanel.setHasBackButton(true);
        headerPanel.setHasForwardButton(false);

        rootPanel.add(headerPanel);

        //rootPanel.add(generateListView());

        FooterPanel footerPanel = new FooterPanel();
        RefreshButton refreshButton = new RefreshButton();
        footerPanel.add( refreshButton);
        
        rootPanel.add(footerPanel);
    }
    /*
    private SimpleList generateListView(){
        SimpleList viewSimple = new SimpleList();
        List<ListModel> itemsList = new ArrayList<ListModel>();

        itemsList.add(new ListModel("Network", "currently WiFi used"));
        itemsList.add(new ListModel("Carrier", "Vodafone.de"));
        itemsList.add(new ListModel("Version", "3.1.3"));
        itemsList.add(new ListModel("Available", "9,6 GB"));
        itemsList.add(new ListModel("", ""));

        viewSimple.displayItems(itemsList);
        return viewSimple;
    }  */
}
