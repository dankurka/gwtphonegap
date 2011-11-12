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

		var status = function() {
			callback.@com.googlecode.gwtphonegap.client.media.MediaCallback::onStatusChange()();
		};

		return new $wnd.Media(src, $entry(suc), $entry(fail), $entry(status));
	}-*/;

}
