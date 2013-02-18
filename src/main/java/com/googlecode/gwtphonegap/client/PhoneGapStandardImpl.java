/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.google.web.bindery.event.shared.SimpleEventBus;

import com.googlecode.gwtphonegap.client.accelerometer.Accelerometer;
import com.googlecode.gwtphonegap.client.camera.Camera;
import com.googlecode.gwtphonegap.client.capture.Capture;
import com.googlecode.gwtphonegap.client.compass.Compass;
import com.googlecode.gwtphonegap.client.connection.Connection;
import com.googlecode.gwtphonegap.client.contacts.Contacts;
import com.googlecode.gwtphonegap.client.device.Device;
import com.googlecode.gwtphonegap.client.event.Event;
import com.googlecode.gwtphonegap.client.file.File;
import com.googlecode.gwtphonegap.client.geolocation.Geolocation;
import com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowser;
import com.googlecode.gwtphonegap.client.log.PhoneGapLog;
import com.googlecode.gwtphonegap.client.log.PhoneGapLogStandardImpl;
import com.googlecode.gwtphonegap.client.media.MediaModule;
import com.googlecode.gwtphonegap.client.notification.Notification;
import com.googlecode.gwtphonegap.client.plugins.PhoneGapPlugin;
import com.googlecode.gwtphonegap.client.splashscreen.SplashScreen;

import java.util.HashMap;
import java.util.Map;

public class PhoneGapStandardImpl implements PhoneGap {

  private static final int INIT_TICK = 10;

  private Device device;

  private Accelerometer accelerometer;
  private Camera camera;
  private Geolocation geolocation;
  private Notification notification;
  private Contacts contacts;
  private File file;
  private Connection connection;
  private Event event;
  private MediaModule mediaModule;
  private Compass compass;
  private Capture capture;
  private SplashScreen splashScreen;
  private InAppBrowser inAppBrowser;

  private Map<String, PhoneGapPlugin> plugins = new HashMap<String, PhoneGapPlugin>();

  private boolean hasHandlers = false;
  private EventBus handlerManager = new SimpleEventBus();

  private PhoneGapLogStandardImpl phoneGapLog;

  private boolean deviceReady;

  public PhoneGapStandardImpl() {
    // log configures it self
    getLog();

    setupReadyHook();
  }

  public PhoneGapLog getLog() {
    if (phoneGapLog == null) {
      phoneGapLog = new PhoneGapLogStandardImpl();
    }
    return phoneGapLog;
  }

  @Override
  public boolean isPhoneGapInitialized() {
    return deviceReady;
  }

  @Override
  public void initializePhoneGap() {
    initializePhoneGap(10000);
  }

  @Override
  public void initializePhoneGap(final int timeoutInMs) {

    final long end = System.currentTimeMillis() + timeoutInMs;
    if (isPhoneGapInitialized()) {

      firePhoneGapAvailable();

    } else {
      Timer timer = new Timer() {

        @Override
        public void run() {
          if (isPhoneGapInitialized()) {
            firePhoneGapAvailable();
            return;
          }

          if (System.currentTimeMillis() - end > 0) {
            handlerManager.fireEvent(new PhoneGapTimeoutEvent());
          } else {
            schedule(INIT_TICK);
          }

        }
      };

      timer.schedule(INIT_TICK);
    }
  }

  @Override
  public HandlerRegistration addHandler(PhoneGapAvailableHandler handler) {
    hasHandlers = true;
    return handlerManager.addHandler(PhoneGapAvailableEvent.TYPE, handler);
  }

  @Override
  public HandlerRegistration addHandler(PhoneGapTimeoutHandler handler) {
    hasHandlers = true;
    return handlerManager.addHandler(PhoneGapTimeoutEvent.TYPE, handler);
  }

  @Override
  public Device getDevice() {
    if (device == null) {
      device = constructDevice();
    }
    return device;
  }

  @Override
  public Accelerometer getAccelerometer() {
    if (accelerometer == null) {
      accelerometer = constructAccelerometer();
    }
    return accelerometer;
  }

  @Override
  public Camera getCamera() {
    if (camera == null) {
      camera = constructCamera();
    }
    return camera;
  }

  @Override
  public Geolocation getGeolocation() {
    if (geolocation == null) {
      geolocation = constructGeolocation();
    }
    return geolocation;
  }

  @Override
  public Notification getNotification() {
    if (notification == null) {
      notification = constructNotification();
    }
    return notification;
  }

  private void firePhoneGapAvailable() {
    phoneGapLog.setClientId(getDevice().getUuid());

    handlerManager.fireEvent(new PhoneGapAvailableEvent());
  }

  @Override
  public Contacts getContacts() {
    if (contacts == null) {
      contacts = constructContacts();
    }
    return contacts;
  }

  @Override
  public PhoneGapPlugin getPluginById(String id) {
    return plugins.get(id);
  }

  @Override
  public void loadPlugin(String id, PhoneGapPlugin instance) {
    if (plugins.containsKey(id)) {
      throw new IllegalStateException("id is already in use");
    }

    plugins.put(id, instance);
  }

  @Override
  public File getFile() {
    if (file == null) {
      file = constructFile();
    }
    return file;
  }

  @Override
  public Connection getConnection() {
    if (connection == null) {
      connection = constructConnection();
    }
    return connection;
  }

  @Override
  public Event getEvent() {
    hasHandlers = true;
    if (event == null) {
      event = constructEvent();
    }
    return event;
  }

  @Override
  public native boolean exitApp() /*-{
		if ($wnd.navigator.app != null) {
			if ($wnd.navigator.app.exitApp != null) {
				$wnd.navigator.app.exitApp();
				return true;
			}
		}
		return false;

  }-*/;

  @Override
  public MediaModule getMedia() {
    if (mediaModule == null) {
      mediaModule = constructMediaModule();
    }
    return mediaModule;
  }

  @Override
  public Compass getCompass() {
    if (compass == null) {
      compass = constructCompass();
    }
    return compass;
  }

  @Override
  public Capture getCapture() {
    if (capture == null) {
      capture = constructCapture();
    }
    return capture;
  }

  @Override
  public SplashScreen getSplashScreen() {
    if (splashScreen == null) {
      splashScreen = constructSplashscreen();
    }
    return splashScreen;
  }

  @Override
  public boolean isPhoneGapDevice() {
    return true;
  }

  protected Device constructDevice() {
    return GWT.create(Device.class);
  }

  protected Accelerometer constructAccelerometer() {
    return GWT.create(Accelerometer.class);
  }

  protected Camera constructCamera() {
    return GWT.create(Camera.class);
  }

  protected Geolocation constructGeolocation() {
    return GWT.create(Geolocation.class);
  }

  protected Notification constructNotification() {
    return GWT.create(Notification.class);
  }

  protected Capture constructCapture() {
    return GWT.create(Capture.class);
  }

  protected SplashScreen constructSplashscreen() {
    return GWT.create(SplashScreen.class);
  }

  protected Compass constructCompass() {
    return GWT.create(Compass.class);
  }

  protected MediaModule constructMediaModule() {
    return GWT.create(MediaModule.class);
  }

  protected Event constructEvent() {
    Event event = GWT.create(Event.class);
    event.setEventBus(handlerManager);
    return event;
  }

  protected Connection constructConnection() {
    return GWT.create(Connection.class);
  }

  protected File constructFile() {
    return GWT.create(File.class);
  }

  protected Contacts constructContacts() {
    return GWT.create(Contacts.class);
  }

  protected void nativeDeviceReady() {
    deviceReady = true;
  }

  private native void setupReadyHook() /*-{
		var that = this;
		var f = function() {
			that.@com.googlecode.gwtphonegap.client.PhoneGapStandardImpl::nativeDeviceReady()();
		};
		$doc.addEventListener("deviceready", $entry(f), false);

  }-*/;

  @Override
  public void setEventBus(EventBus eventBus) {
    assert !hasHandlers : "The handlerManager can not be replaced because it has got handlers";
    handlerManager = eventBus;
    // We force the event construction so as the app can add events directly
    // to the eventBus instead of through the phoneGap.getEvent() method;
    event = constructEvent();
  }

  @Override
  public InAppBrowser getInAppBrowser() {
    if (inAppBrowser == null) {
      inAppBrowser = constructInAppBrowser();
    }
    return inAppBrowser;
  }

  protected InAppBrowser constructInAppBrowser() {
    return GWT.create(InAppBrowser.class);
  }

}
