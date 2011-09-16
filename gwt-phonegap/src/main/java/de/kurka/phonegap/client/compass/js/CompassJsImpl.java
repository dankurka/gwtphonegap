/*
 * Copyright 2011 Daniel Kurka
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
package de.kurka.phonegap.client.compass.js;

import de.kurka.phonegap.client.compass.Compass;
import de.kurka.phonegap.client.compass.CompassCallback;
import de.kurka.phonegap.client.compass.CompassOptions;
import de.kurka.phonegap.client.compass.CompassWatcher;

public class CompassJsImpl implements Compass {

	@Override
	public native void getCurrentHeading(CompassOptions options, CompassCallback callback) /*-{

		var suc = function(heading) {
			callback.@de.kurka.phonegap.client.compass.CompassCallback::onSuccess(D)(heading);
		};

		var fail = function() {
			callback.@de.kurka.phonegap.client.compass.CompassCallback::onError()();
		};

		var gap_options = {};

		gap_options.frequency = options.@de.kurka.phonegap.client.compass.CompassOptions::getFrequency()();

		$wnd.navigator.compass.getCurrentHeading($entry(suc), $entry(fail),
				gap_options);

	}-*/;

	@Override
	public CompassWatcher watchHeading(CompassOptions options, CompassCallback callback) {
		String watchId = watchHeading0(options, callback);

		return new CompassWatcherImpl(watchId);
	}

	private native String watchHeading0(CompassOptions options, CompassCallback callback)/*-{

		var suc = function(heading) {
			callback.@de.kurka.phonegap.client.compass.CompassCallback::onSuccess(D)(heading);
		};

		var fail = function() {
			callback.@de.kurka.phonegap.client.compass.CompassCallback::onError()();
		};

		var gap_options = {};

		gap_options.frequency = options.@de.kurka.phonegap.client.compass.CompassOptions::getFrequency()();

		var id = $wnd.navigator.compass.watchHeading($entry(suc), $entry(fail),
				gap_options);

		return id;
	}-*/;

	@Override
	public void clearWatcher(CompassWatcher watcher) {
		if (!(watcher instanceof CompassWatcherImpl)) {
			throw new IllegalStateException("this should not happen - I can only cancel watchers you got from watchHeading");
		}
		CompassWatcherImpl compassWatcherImpl = (CompassWatcherImpl) watcher;

		String id = compassWatcherImpl.getId();
		clearWatcher0(id);

	}

	private native void clearWatcher0(String id)/*-{
		$wnd.navigator.compass.clearWatch(id);
	}-*/;

}
