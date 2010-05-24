package org.dvelop.phonegap.iphone.client.widgets.page;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import org.dvelop.phonegap.iphone.client.widgets.event.transition.TransitionEndHandler;

import java.util.Iterator;

/**
 * User: daniel kurka
 * Date: 11.05.2010
 * Time: 15:38:58
 */
public class BasicPagePanel extends Composite implements HasMovingPanelAnimation {

    private MovingPanel active;
    private MovingPanel inactive;
    private FlowPanel main;
    private BasicPagePanelCssResource css;

    public BasicPagePanel() {
        main = new FlowPanel();
        initWidget(main);
        active = new MovingPanel();
        inactive = new MovingPanel();
        css = BasicPageResourceBundle.INSTANCE.css();
        css.ensureInjected();

        active.addStyleName(css.movingPanelNormal());
        inactive.addStyleName(css.movingPanelLeft());

        main.add(active);
        main.add(inactive);

        //active.addTransistionEndHandler(new TransEndHandler(active));
        //active.addTransistionEndHandler(new TransEndHandler(inactive));



    }

    private class TransEndHandler implements TransitionEndHandler{

        private MovingPanel panel;

        public TransEndHandler(MovingPanel panel) {
            this.panel = panel;
        }

        public void onWebKitTransitionEndHandler() {
            if(panel == inactive)
                panel.clear();
        }
    }

    public MovingPanel getActivePanel() {
        return active;
    }

    public MovingPanel getInactivePanel() {
        return inactive;
    }


    public void moveRight(Widget newWidget) {

        inactive.clear();
        inactive.removeStyleName(css.movingPanelAnimate());
        inactive.removeStyleName(css.movingPanelLeft());
        inactive.removeStyleName(css.movingPanelRight());
        inactive.removeStyleName(css.movingPanelNormal());

        inactive.addStyleName(css.movingPanelRight());
        inactive.add(newWidget);

        active.removeStyleName(css.movingPanelAnimate());
        active.removeStyleName(css.movingPanelLeft());
        active.removeStyleName(css.movingPanelRight());
        active.removeStyleName(css.movingPanelNormal());

        active.addStyleName(css.movingPanelNormal());


        DeferredCommand.addCommand(new Command() {
            public void execute() {

                inactive.removeStyleName(css.movingPanelRight());
                inactive.addStyleName(css.movingPanelNormal());
                inactive.addStyleName(css.movingPanelAnimate());

                active.removeStyleName(css.movingPanelNormal());
                active.addStyleName(css.movingPanelLeft());
                active.addStyleName(css.movingPanelAnimate());

                MovingPanel tmp = active;
                active = inactive;
                inactive = tmp;

            }
        });


    }

    public void moveLeft(Widget newWidget) {

        inactive.clear();
        inactive.removeStyleName(css.movingPanelAnimate());
        inactive.removeStyleName(css.movingPanelLeft());
        inactive.removeStyleName(css.movingPanelRight());
        inactive.removeStyleName(css.movingPanelNormal());

        inactive.addStyleName(css.movingPanelLeft());
        inactive.add(newWidget);

        active.removeStyleName(css.movingPanelAnimate());
        active.removeStyleName(css.movingPanelLeft());
        active.removeStyleName(css.movingPanelRight());
        active.removeStyleName(css.movingPanelNormal());

        active.addStyleName(css.movingPanelNormal());


        DeferredCommand.addCommand(new Command() {
            public void execute() {

                inactive.removeStyleName(css.movingPanelLeft());
                inactive.addStyleName(css.movingPanelNormal());
                inactive.addStyleName(css.movingPanelAnimate());

                active.removeStyleName(css.movingPanelNormal());
                active.addStyleName(css.movingPanelRight());
                active.addStyleName(css.movingPanelAnimate());

                MovingPanel tmp = active;
                active = inactive;
                inactive = tmp;

            }
        });


    }


}
