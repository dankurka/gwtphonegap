/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.geolocation.browser;

import com.google.gwt.core.client.Callback;
import com.google.gwt.geolocation.client.Geolocation.PositionOptions;
import com.google.gwt.user.client.Timer;
import com.googlecode.gwtphonegap.client.geolocation.Geolocation;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationCallback;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationOptions;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationWatcher;
import com.googlecode.gwtphonegap.client.geolocation.PositionError;

public class GeolocationBrowserEmptyImpl implements Geolocation {

	private com.google.gwt.geolocation.client.Geolocation gwtGeoLocation;

	public GeolocationBrowserEmptyImpl() {
		gwtGeoLocation = com.google.gwt.geolocation.client.Geolocation.getIfSupported();

	}

	@Override
	public void getCurrentPosition(GeolocationCallback callback) {
		getCurrentPosition(callback, null);
	}

	@Override
	public void getCurrentPosition(final GeolocationCallback callback, GeolocationOptions options) {
		if (gwtGeoLocation == null) {
			callback.onFailure(new PositionErrorJavaImpl(PositionError.PERMISSION_DENIED, ""));
		} else {
			gwtGeoLocation.getCurrentPosition(new Callback<com.google.gwt.geolocation.client.Position, com.google.gwt.geolocation.client.PositionError>() {

				@Override
				public void onSuccess(com.google.gwt.geolocation.client.Position result) {
					PositionBrowserImpl positionBrowserImpl = createPosition(result);
					callback.onSuccess(positionBrowserImpl);

				}

				@Override
				public void onFailure(com.google.gwt.geolocation.client.PositionError reason) {

					callback.onFailure(new PositionErrorJavaImpl(reason.getCode(), reason.getMessage()));

				}
			});
		}

	}

	@Override
	public GeolocationWatcher watchPosition(GeolocationOptions options, final GeolocationCallback callback) {
		if (gwtGeoLocation == null) {
			return new GeolocationWatcherGwtTimerImpl(options, callback);
		} else {

			com.google.gwt.geolocation.client.Geolocation.PositionOptions opt = new PositionOptions();
			opt.setHighAccuracyEnabled(true);
			opt.setMaximumAge(options.getMaximumAge());
			opt.setTimeout(options.getTimeout());

                        int watchPosition = gwtGeoLocation.watchPosition(new Callback<com.google.gwt.geolocation.client.Position, com.google.gwt.geolocation.client.PositionError>() {

                                @Override
                                public void onSuccess(com.google.gwt.geolocation.client.Position result) {
                                PositionBrowserImpl positionBrowserImpl = createPosition(result);
                                callback.onSuccess(positionBrowserImpl);

                                }

                                @Override
                                public void onFailure(com.google.gwt.geolocation.client.PositionError reason) {

                                callback.onFailure(new PositionErrorJavaImpl(reason.getCode(), reason.getMessage()));

                                }
                        },opt);
			return new GwtLocationWatcher(watchPosition);
		}

	}

	@Override
	public void clearWatch(GeolocationWatcher watcher) {
		if ((watcher instanceof GeolocationWatcherGwtTimerImpl)) {
			GeolocationWatcherGwtTimerImpl timerImpl = (GeolocationWatcherGwtTimerImpl) watcher;
			timerImpl.cancel();

		} else {
			if (watcher instanceof GwtLocationWatcher) {
				GwtLocationWatcher gwtLocationWatcher = (GwtLocationWatcher) watcher;
				gwtGeoLocation.clearWatch(gwtLocationWatcher.getId());

			} else {
				throw new IllegalArgumentException();
			}
		}

	}

	/**
	 * @param result
	 * @return
	 */
	private PositionBrowserImpl createPosition(com.google.gwt.geolocation.client.Position result) {
		CoordinatesBrowserImpl co = new CoordinatesBrowserImpl();
		co.setAltitude(result.getCoordinates().getAltitude() != null ? result.getCoordinates().getAltitude() : 0);
		co.setAltitudeAccuracy(result.getCoordinates().getAltitudeAccuracy() != null ? result.getCoordinates().getAltitudeAccuracy() : 0);
		co.setHeading(result.getCoordinates().getHeading() != null ? result.getCoordinates().getHeading() : 0);
		co.setAccuracy(result.getCoordinates().getAccuracy());
		co.setLatitude(result.getCoordinates().getLatitude());
		co.setLongitude(result.getCoordinates().getLongitude());
		co.setSpeed(result.getCoordinates().getSpeed() != null ? result.getCoordinates().getSpeed() : 0);
		PositionBrowserImpl positionBrowserImpl = new PositionBrowserImpl(co, Math.round(result.getTimestamp()));
		return positionBrowserImpl;
	}

	private class GwtLocationWatcher implements GeolocationWatcher {
		private final int id;

		public GwtLocationWatcher(int id) {
			this.id = id;

		}

		public int getId() {
			return id;
		}
	}

	private class GeolocationWatcherGwtTimerImpl extends Timer implements GeolocationWatcher {

		private final GeolocationCallback callback;
		private final GeolocationOptions options;

		public GeolocationWatcherGwtTimerImpl(GeolocationOptions options, GeolocationCallback callback) {

			this.callback = callback;
			this.options = options;
                        
		}

		@Override
		public void run() {
                    
			callback.onFailure(new PositionErrorJavaImpl(PositionError.PERMISSION_DENIED, ""));

		}

	}

}
