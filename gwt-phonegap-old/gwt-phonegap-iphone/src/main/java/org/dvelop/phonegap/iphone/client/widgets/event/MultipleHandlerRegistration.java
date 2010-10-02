package org.dvelop.phonegap.iphone.client.widgets.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

import java.util.*;

/**
 * User: martin christ
 * Date: 16.05.2010
 * Time: 01:50:13
 */
public class MultipleHandlerRegistration implements HandlerRegistration {
    private List<HandlerRegistration> registrationList;

    public MultipleHandlerRegistration() {
        registrationList = new ArrayList<HandlerRegistration>();
    }

    public void addHandlerRegistration(HandlerRegistration registration) {
        assert registrationList != null : "registration map must not be null - removeHandler() has already been called";
        registrationList.add(registration);
    }


    public void removeHandler() {
        assert registrationList != null : "registration map must not be null - removeHandler() has already been called";

        for (HandlerRegistration registration : registrationList) {
            registration.removeHandler();
        }
        registrationList.clear();
        registrationList = null;
    }
}