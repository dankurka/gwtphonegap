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
package com.googlecode.gwtphonegap.client.media.js;

import com.googlecode.gwtphonegap.client.media.Media;
import com.googlecode.gwtphonegap.client.media.MediaCallback;
import com.googlecode.gwtphonegap.client.media.MediaModule;

public class MediaModuleJsImpl implements MediaModule {

	@Override
	public native Media create(String src, MediaCallback callback) /*-{
		var that = this;

		var suc = function() {
			callback.@com.googlecode.gwtphonegap.client.media.MediaCallback::onSuccess()();
		};

		var fail = function(error) {
			callback.@com.googlecode.gwtphonegap.client.media.MediaCallback::onError(Lcom/googlecode/gwtphonegap/client/media/MediaError;)(error);
		};

		var status = function(mediaStatus) {
			callback.@com.googlecode.gwtphonegap.client.media.MediaCallback::onStatusChange(I)(mediaStatus);
		};

		return new $wnd.Media(src, $entry(suc), $entry(fail), $entry(status));
	}-*/;

}
