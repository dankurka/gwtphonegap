package org.dvelop.phonegap.iphone.client.widgets.header;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import org.dvelop.phonegap.iphone.client.widgets.base.TouchEvent;
import org.dvelop.phonegap.iphone.client.widgets.base.TouchHandler;


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

    public Title getActiveTitle() {
        return activeTitle;
    }

    private Title activeTitle;
    private Title inactiveTitle;
    private FlowPanel main;

    public void setHasBackButton(boolean hasButton) {
        activeBackButton.removeStyleName("pos-right");
        activeBackButton.removeStyleName("pos-left");
        if (!hasButton) {
            activeBackButton.addStyleName("pos-left");
        }
        hasBackButton = hasButton;
    }

    private boolean hasBackButton;

    public HeaderPanel() {
        main = new FlowPanel();
        main.getElement().setId("header");

        activeBackButton = new BackButton();
        //configureActiveButtonEvent();
        main.add(activeBackButton);
        inactiveBackButton = new BackButton();
        main.add(inactiveBackButton);
        inactiveBackButton.addStyleName("pos-left");

        activeTitle = new Title();
        main.add(activeTitle);

        inactiveTitle = new Title();
        inactiveTitle.addStyleName("pos-left");
        main.add(inactiveTitle);

        activeForwardButton = new ForwardButton();
        activeForwardButton.setText("testactive");
        main.add(activeForwardButton);

        inactiveForwardButton = new ForwardButton();
        inactiveForwardButton.setText("testinactive");
        inactiveForwardButton.addStyleName("pos-right");
        main.add(inactiveForwardButton);

        initWidget(main);

        setUpEventListenerOnActiveButtons();


    }

    public void setBackButtonText(String text) {
        activeBackButton.setText(text);
    }

    public void setTitleText(String text) {
        activeTitle.setText(text);
    }

    private void removePositionStyles() {
        inactiveBackButton.removeStyleName("pos-right");
        inactiveBackButton.removeStyleName("pos-left");
        inactiveBackButton.removeStyleName("animate-off");
        inactiveBackButton.removeStyleName("animate-on");

        activeBackButton.removeStyleName("pos-right");
        activeBackButton.removeStyleName("pos-left");
        activeBackButton.removeStyleName("animate-off");
        activeBackButton.removeStyleName("animate-on");


        activeForwardButton.removeStyleName("pos-right");
        activeForwardButton.removeStyleName("pos-left");
        activeForwardButton.removeStyleName("animate-off");
        activeForwardButton.removeStyleName("animate-on");

        inactiveForwardButton.removeStyleName("pos-right");
        inactiveForwardButton.removeStyleName("pos-left");
        inactiveForwardButton.removeStyleName("animate-off");
        inactiveForwardButton.removeStyleName("animate-on");

        inactiveTitle.removeStyleName("pos-left");
        inactiveTitle.removeStyleName("pos-right");
        inactiveTitle.removeStyleName("animate-off");

        activeTitle.removeStyleName("pos-left");
        activeTitle.removeStyleName("pos-right");
        activeTitle.removeStyleName("animate-off");
    }

    public void moveForward(final HeaderPanelAnimation info) {
        removePositionStyles();


        final BackButton oldBackButton = activeBackButton;
        if (!hasBackButton) {
            oldBackButton.addStyleName("pos-left");
        }
        final BackButton newBackButton = inactiveBackButton;
        newBackButton.addStyleName("animate-off");
        newBackButton.addStyleName("pos-right");

        if (info.isBackButton()) {
            newBackButton.setText(info.getBackButtonText());
        }


        final ForwardButton oldForwardButton = activeForwardButton;
        if (!hasForwardButton) {
            oldForwardButton.addStyleName("pos-left");
        }
        final ForwardButton newForwardButton = inactiveForwardButton;
        newForwardButton.addStyleName("animate-off");
        newForwardButton.addStyleName("pos-right");
        if (info.isForwardButton()) {
            newForwardButton.setText(info.getForwardButtonText());
        }


        final Title newTitle = inactiveTitle;
        final Title oldTitle = activeTitle;


        newTitle.addStyleName("pos-right");
        newTitle.addStyleName("animate-off");
        newTitle.setText(info.getTitle());


        DeferredCommand.addCommand(new Command() {
            public void execute() {
                if (hasBackButton) {
                    oldBackButton.addStyleName("pos-left");
                    oldBackButton.addStyleName("animate-on");
                }

                if (info.isBackButton()) {
                    newBackButton.removeStyleName("animate-off");
                    newBackButton.removeStyleName("pos-right");
                    newBackButton.addStyleName("animate-on");
                }

                if (hasForwardButton) {
                    oldForwardButton.addStyleName("pos-left");
                    oldForwardButton.addStyleName("animate-on");
                }

                if (info.isForwardButton()) {
                    newForwardButton.removeStyleName("animate-off");
                    newForwardButton.removeStyleName("pos-right");
                    newForwardButton.addStyleName("animate-on");
                }


                oldTitle.addStyleName("pos-left");
                oldTitle.addStyleName("animate-on");

                newTitle.removeStyleName("pos-right");
                newTitle.removeStyleName("animate-off");
                newTitle.addStyleName("animate-on");


            }
        });

        inactiveBackButton = oldBackButton;
        activeBackButton = newBackButton;

        activeTitle = newTitle;
        inactiveTitle = oldTitle;

        inactiveForwardButton = oldForwardButton;
        activeForwardButton = newForwardButton;


        setUpEventListenerOnActiveButtons();
    }

    private void setUpEventListenerOnActiveButtons() {
        if (activeButtonHandler != null) {
            activeButtonHandler.removeHandler();
        }

        activeButtonHandler = activeBackButton.addHandler(new TouchHandler() {
            public void onTouch(TouchEvent event) {

                fireBackButtonTouched(event);
            }
        });

        if (forwardButtonHandler != null) {
            forwardButtonHandler.removeHandler();
        }

        forwardButtonHandler = activeForwardButton.addHandler(new TouchHandler() {
            public void onTouch(TouchEvent event) {
                fireForwardButtonTouched(event);

            }
        });

    }


    private LinkedList<TouchHandler> backButtonListeners = new LinkedList<TouchHandler>();
    private LinkedList<TouchHandler> forwardButtonListeners = new LinkedList<TouchHandler>();

    public void addBackButtonListener(TouchHandler handler) {
        if (!backButtonListeners.contains(handler))
            backButtonListeners.add(handler);
    }

    public void removeBackButtonListener(TouchHandler handler) {
        backButtonListeners.remove(handler);
    }

    public void addForwardButtonListener(TouchHandler handler) {
        if (!forwardButtonListeners.contains(handler))
            forwardButtonListeners.add(handler);
    }

    public void removeForwardButtonListener(TouchHandler handler) {
        forwardButtonListeners.remove(handler);
    }

    private void fireBackButtonTouched(TouchEvent event) {
        for (TouchHandler h : backButtonListeners) {
            h.onTouch(event);
        }
    }

    private void fireForwardButtonTouched(TouchEvent event) {
        for (TouchHandler h : forwardButtonListeners) {
            h.onTouch(event);
        }
    }


    public void moveBackward(final HeaderPanelAnimation info) {
        removePositionStyles();


        final BackButton oldBackButton = activeBackButton;
        if (!hasBackButton) {
            oldBackButton.addStyleName("pos-right");
        }
        final BackButton newBackButton = inactiveBackButton;
        newBackButton.addStyleName("animate-off");
        newBackButton.addStyleName("pos-left");
        if (info.isBackButton()) {
            newBackButton.setText(info.getBackButtonText());
        }


        final ForwardButton oldForwardButton = activeForwardButton;
        if (!hasForwardButton) {
            oldForwardButton.addStyleName("pos-left");

        }
        final ForwardButton newForwardButton = inactiveForwardButton;
        newForwardButton.addStyleName("animate-off");
        newForwardButton.addStyleName("pos-left");
        if (info.isForwardButton()) {
            newForwardButton.setText(info.getForwardButtonText());
        }


        final Title newTitle = inactiveTitle;
        final Title oldTitle = activeTitle;

        newTitle.addStyleName("pos-left");
        newTitle.addStyleName("animate-off");
        newTitle.setText(info.getTitle());


        DeferredCommand.addCommand(new Command() {
            public void execute() {
                if (hasBackButton) {
                    oldBackButton.addStyleName("pos-right");
                    oldBackButton.addStyleName("animate-on");
                }
                if (info.isBackButton()) {
                    newBackButton.removeStyleName("animate-off");
                    newBackButton.removeStyleName("pos-left");
                    newBackButton.addStyleName("animate-on");
                }

                if (hasForwardButton) {
                    oldForwardButton.addStyleName("pos-right");
                    oldForwardButton.addStyleName("animate-on");
                }
                if (info.isForwardButton()) {
                    newForwardButton.removeStyleName("animate-off");
                    newForwardButton.removeStyleName("pos-left");
                    newForwardButton.addStyleName("animate-on");
                }


                oldTitle.addStyleName("pos-right");
                oldTitle.addStyleName("animate-on");
                newTitle.removeStyleName("pos-left");
                newTitle.removeStyleName("animate-off");
                newTitle.addStyleName("animate-on");


            }
        });

        inactiveBackButton = oldBackButton;
        activeBackButton = newBackButton;

        activeTitle = newTitle;
        inactiveTitle = oldTitle;

        inactiveForwardButton = oldForwardButton;
        activeForwardButton = newForwardButton;


        setUpEventListenerOnActiveButtons();


    }

    private boolean hasForwardButton;


    public void setHasForwardButton(boolean hasForwardButton) {
        activeForwardButton.removeStyleName("pos-right");
        activeForwardButton.removeStyleName("pos-left");

        if (!hasForwardButton) {
            activeForwardButton.addStyleName("pos-right");
        }
        this.hasForwardButton = hasForwardButton;
    }
}