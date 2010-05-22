package org.dvelop.phonegap.iphone.client.widgets.header;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import org.dvelop.phonegap.iphone.client.widgets.base.TouchEvent;
import org.dvelop.phonegap.iphone.client.widgets.base.TouchHandler;
import org.dvelop.phonegap.iphone.client.widgets.event.MultipleHandlerRegistration;
import org.dvelop.phonegap.iphone.client.widgets.event.touch.SimpleTouchHandler;


import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: kurt
 * Date: 18.02.2010
 * Time: 00:01:01
 * To change this template use File | Settings | File Templates.
 */
public class HeaderPanel extends Composite {


    private HandlerRegistration activeButtonHandler;
    private BackButton activeBackButton;
    private BackButton inactiveBackButton;
    private ForwardButton activeForwardButton;
    private ForwardButton inactiveForwardButton;
    private HandlerRegistration forwardButtonHandler;

    private HeaderPanelCss css;

    public Title getActiveTitle() {
        return activeTitle;
    }

    private Title activeTitle;
    private Title inactiveTitle;
    private FlowPanel main;

    public void setHasBackButton(boolean hasButton) {
        activeBackButton.removeStyleName(css.backButtonPosRight());
        activeBackButton.removeStyleName(css.backButtonPosLeft());
        if (!hasButton) {
            activeBackButton.addStyleName(css.backButtonPosLeft());
        }
        hasBackButton = hasButton;
    }

    private boolean hasBackButton = true;

    public HeaderPanel() {
        HeaderPanelResourceBundle.INSTANCE.css().ensureInjected();
        css = HeaderPanelResourceBundle.INSTANCE.css();
        main = new FlowPanel();
        main.setStyleName(css.headerClass());

        activeBackButton = new BackButton();
        //configureActiveButtonEvent();
        main.add(activeBackButton);
        inactiveBackButton = new BackButton();
        main.add(inactiveBackButton);
        inactiveBackButton.addStyleName(css.backButtonPosLeft());

        activeTitle = new Title();
        main.add(activeTitle);

        inactiveTitle = new Title();
        inactiveTitle.addStyleName(css.titlePosLeft());
        main.add(inactiveTitle);

        activeForwardButton = new ForwardButton();
        activeForwardButton.setText("testactive");
        main.add(activeForwardButton);

        inactiveForwardButton = new ForwardButton();
        inactiveForwardButton.setText("testinactive");
        inactiveForwardButton.addStyleName(css.forwardButtonPosRight());
        main.add(inactiveForwardButton);

        initWidget(main);


    }

    public void setBackButtonText(String text) {
        activeBackButton.setText(text);
    }

    public void setTitleText(String text) {
        activeTitle.setText(text);
    }

    private void removePositionStyles() {
        inactiveBackButton.removeStyleName(css.backButtonPosRight());
        inactiveBackButton.removeStyleName(css.backButtonPosLeft());
        inactiveBackButton.removeStyleName(css.backButtonStartAnimate());
        inactiveBackButton.removeStyleName(css.backButtonStopAnimate());

        activeBackButton.removeStyleName(css.backButtonPosRight());
        activeBackButton.removeStyleName(css.backButtonPosLeft());
        activeBackButton.removeStyleName(css.backButtonStartAnimate());
        activeBackButton.removeStyleName(css.backButtonStopAnimate());


        activeForwardButton.removeStyleName(css.forwardButtonPosRight());
        activeForwardButton.removeStyleName(css.forwardButtonPosLeft());
        activeForwardButton.removeStyleName(css.forwardButtonStopAnimate());
        activeForwardButton.removeStyleName(css.forwardButtonStartAnimate());

        inactiveForwardButton.removeStyleName(css.forwardButtonPosRight());
        inactiveForwardButton.removeStyleName(css.forwardButtonPosLeft());
        inactiveForwardButton.removeStyleName(css.forwardButtonStopAnimate());
        inactiveForwardButton.removeStyleName(css.forwardButtonStartAnimate());

        inactiveTitle.removeStyleName(css.titlePosLeft());
        inactiveTitle.removeStyleName(css.titlePosRight());
        inactiveTitle.removeStyleName(css.titleStopAnimate());

        activeTitle.removeStyleName(css.titlePosLeft());
        activeTitle.removeStyleName(css.titlePosRight());
        activeTitle.removeStyleName(css.titleStopAnimate());
    }

    public void moveForward(final HeaderPanelAnimation info) {
        removePositionStyles();


        final BackButton oldBackButton = activeBackButton;
        if (!hasBackButton) {
            oldBackButton.addStyleName(css.backButtonPosLeft());
        }
        final BackButton newBackButton = inactiveBackButton;
        newBackButton.addStyleName(css.backButtonStopAnimate());
        newBackButton.addStyleName(css.backButtonPosRight());

        if (info.isBackButton()) {
            newBackButton.setText(info.getBackButtonText());
        }


        final ForwardButton oldForwardButton = activeForwardButton;
        if (!hasForwardButton) {
            oldForwardButton.addStyleName(css.forwardButtonPosLeft());
        }
        final ForwardButton newForwardButton = inactiveForwardButton;
        newForwardButton.addStyleName(css.forwardButtonStopAnimate());
        newForwardButton.addStyleName(css.forwardButtonPosRight());
        if (info.isForwardButton()) {
            newForwardButton.setText(info.getForwardButtonText());
        }


        final Title newTitle = inactiveTitle;
        final Title oldTitle = activeTitle;


        newTitle.addStyleName(css.titlePosRight());
        newTitle.addStyleName(css.titleStopAnimate());
        newTitle.setText(info.getTitle());


        DeferredCommand.addCommand(new Command() {
            public void execute() {
                if (hasBackButton) {
                    oldBackButton.addStyleName(css.backButtonPosLeft());
                    oldBackButton.addStyleName(css.backButtonStartAnimate());
                }

                if (info.isBackButton()) {
                    newBackButton.removeStyleName(css.backButtonStopAnimate());
                    newBackButton.removeStyleName(css.backButtonPosRight());
                    newBackButton.addStyleName(css.backButtonStartAnimate());
                }

                if (hasForwardButton) {
                    oldForwardButton.addStyleName(css.forwardButtonPosLeft());
                    oldForwardButton.addStyleName(css.forwardButtonStartAnimate());
                }

                if (info.isForwardButton()) {
                    newForwardButton.removeStyleName(css.forwardButtonStopAnimate());
                    newForwardButton.removeStyleName(css.forwardButtonPosRight());
                    newForwardButton.addStyleName(css.forwardButtonStartAnimate());
                }


                oldTitle.addStyleName(css.titlePosLeft());
                oldTitle.addStyleName(css.titleStartAnimate());

                newTitle.removeStyleName(css.titlePosRight());
                newTitle.removeStyleName(css.titleStopAnimate());
                newTitle.addStyleName(css.titleStartAnimate());


            }
        });

        inactiveBackButton = oldBackButton;
        activeBackButton = newBackButton;

        activeTitle = newTitle;
        inactiveTitle = oldTitle;

        inactiveForwardButton = oldForwardButton;
        activeForwardButton = newForwardButton;

    }

    public HandlerRegistration addBackButtonTouchHandler(SimpleTouchHandler simpleTouchHandler) {
        MultipleHandlerRegistration multipleHandlerRegistration = new MultipleHandlerRegistration();
        multipleHandlerRegistration.addHandlerRegistration(activeBackButton.addSimpleTouchHandler(simpleTouchHandler));
        multipleHandlerRegistration.addHandlerRegistration(inactiveBackButton.addSimpleTouchHandler(simpleTouchHandler));
        return multipleHandlerRegistration;
    }

    public HandlerRegistration addForwardButtonTouchHandler(SimpleTouchHandler simpleTouchHandler) {
        MultipleHandlerRegistration multipleHandlerRegistration = new MultipleHandlerRegistration();
        multipleHandlerRegistration.addHandlerRegistration(activeForwardButton.addSimpleTouchHandler(simpleTouchHandler));
        multipleHandlerRegistration.addHandlerRegistration(inactiveForwardButton.addSimpleTouchHandler(simpleTouchHandler));
        return multipleHandlerRegistration;
    }


    public void moveBackward(final HeaderPanelAnimation info) {
        removePositionStyles();


        final BackButton oldBackButton = activeBackButton;
        if (!hasBackButton) {
            oldBackButton.addStyleName(css.backButtonPosRight());
        }
        final BackButton newBackButton = inactiveBackButton;
        newBackButton.addStyleName(css.backButtonStopAnimate());
        newBackButton.addStyleName(css.backButtonPosLeft());
        if (info.isBackButton()) {
            newBackButton.setText(info.getBackButtonText());
        }


        final ForwardButton oldForwardButton = activeForwardButton;
        if (!hasForwardButton) {
            oldForwardButton.addStyleName(css.forwardButtonPosLeft());

        }
        final ForwardButton newForwardButton = inactiveForwardButton;
        newForwardButton.addStyleName(css.forwardButtonStopAnimate());
        newForwardButton.addStyleName(css.forwardButtonPosLeft());
        if (info.isForwardButton()) {
            newForwardButton.setText(info.getForwardButtonText());
        }


        final Title newTitle = inactiveTitle;
        final Title oldTitle = activeTitle;

        newTitle.addStyleName(css.titlePosLeft());
        newTitle.addStyleName(css.titleStopAnimate());
        newTitle.setText(info.getTitle());


        DeferredCommand.addCommand(new Command() {
            public void execute() {
                if (hasBackButton) {
                    oldBackButton.addStyleName(css.backButtonPosRight());
                    oldBackButton.addStyleName(css.backButtonStartAnimate());
                }
                if (info.isBackButton()) {
                    newBackButton.removeStyleName(css.backButtonStopAnimate());
                    newBackButton.removeStyleName(css.backButtonPosLeft());
                    newBackButton.addStyleName(css.backButtonStartAnimate());
                }

                if (hasForwardButton) {
                    oldForwardButton.addStyleName(css.forwardButtonPosRight());
                    oldForwardButton.addStyleName(css.forwardButtonStartAnimate());
                }
                if (info.isForwardButton()) {
                    newForwardButton.removeStyleName(css.forwardButtonStopAnimate());
                    newForwardButton.removeStyleName(css.forwardButtonPosLeft());
                    newForwardButton.addStyleName(css.forwardButtonStartAnimate());
                }


                oldTitle.addStyleName(css.titlePosRight());
                oldTitle.addStyleName(css.titleStartAnimate());
                newTitle.removeStyleName(css.titlePosLeft());
                newTitle.removeStyleName(css.titleStopAnimate());
                newTitle.addStyleName(css.titleStartAnimate());


            }
        });

        inactiveBackButton = oldBackButton;
        activeBackButton = newBackButton;

        activeTitle = newTitle;
        inactiveTitle = oldTitle;

        inactiveForwardButton = oldForwardButton;
        activeForwardButton = newForwardButton;

    }

    private boolean hasForwardButton = true;


    public void setHasForwardButton(boolean hasForwardButton) {
        activeForwardButton.removeStyleName(css.forwardButtonPosRight());
        activeForwardButton.removeStyleName(css.forwardButtonPosLeft());

        if (!hasForwardButton) {
            activeForwardButton.addStyleName(css.forwardButtonPosRight());
        }
        this.hasForwardButton = hasForwardButton;
    }
}