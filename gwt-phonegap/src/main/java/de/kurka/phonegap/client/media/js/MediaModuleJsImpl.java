package de.kurka.phonegap.client.media.js;

import de.kurka.phonegap.client.media.Media;
import de.kurka.phonegap.client.media.MediaCallback;
import de.kurka.phonegap.client.media.MediaModule;

public class MediaModuleJsImpl implements MediaModule {

	@Override
	public native Media create(String src, MediaCallback callback) /*-{
		var that = this;

		var suc = function() {
			callback.@de.kurka.phonegap.client.media.MediaCallback::onSuccess()();
		};

		var fail = function(error) {
			callback.@de.kurka.phonegap.client.media.MediaCallback::onError(Lde/kurka/phonegap/client/media/MediaError;)(error);
		};

		var status = function() {
			callback.@de.kurka.phonegap.client.media.MediaCallback::onStatusChange()();
		};

		return new $wnd.Media(src, $entry(suc), $entry(fail), $entry(status));
	}-*/;

}
