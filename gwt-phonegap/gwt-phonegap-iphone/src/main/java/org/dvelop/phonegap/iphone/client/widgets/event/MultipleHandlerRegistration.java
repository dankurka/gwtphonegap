package org.dvelop.phonegap.iphone.client.widgets.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * User: martin christ
 * Date: 16.05.2010
 * Time: 01:50:13
 */
public class MultipleHandlerRegistration implements HandlerRegistration {
    private Map<GwtEvent.Type<?>, HandlerRegistration> registrationMap;

    public MultipleHandlerRegistration() {
        registrationMap = new HashMap<GwtEvent.Type<?>, HandlerRegistration>();
    }

    protected void putHandlerRegistration(GwtEvent.Type<?> type, HandlerRegistration registration) {
        assert registrationMap != null : "registration map must not be null - removeHandler() has already been called";
        assert !registrationMap.containsKey(type) : "type can only be put once (" + type + ")";
        registrationMap.put(type, registration);
    }

    protected HandlerRegistration getHandlerRegistration(GwtEvent.Type<?> type){
        assert registrationMap != null : "registration map must not be null - removeHandler() has already been called";
        return registrationMap.get(type);
    }

    public void removeHandler() {
        assert registrationMap != null : "registration map must not be null - removeHandler() has already been called";
        Collection<HandlerRegistration> registrations = registrationMap.values();
        for (HandlerRegistration registration : registrations) {
            registration.removeHandler();
        }
        registrationMap.clear();
        registrationMap = null;
    }
}