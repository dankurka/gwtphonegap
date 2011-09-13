package de.kurka.phonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.gwt.collection.client.JsLightArray;
import de.kurka.gwt.collection.shared.LightArray;
import de.kurka.phonegap.client.file.DirectoryReader;
import de.kurka.phonegap.client.file.EntryBase;
import de.kurka.phonegap.client.file.FileCallback;
import de.kurka.phonegap.client.file.FileError;

public class DirectoryReaderJsImpl implements DirectoryReader {

	private final JavaScriptObject reader;

	public DirectoryReaderJsImpl(JavaScriptObject reader) {
		this.reader = reader;
	}

	@Override
	public native void readEntries(FileCallback<LightArray<EntryBase>, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@de.kurka.phonegap.client.file.js.DirectoryReaderJsImpl::onReadEntriesFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);

		};

		var suc = function(entries) {
			that.@de.kurka.phonegap.client.file.js.DirectoryReaderJsImpl::onReadEntriesSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entries);
		};

		var reader = (this.@de.kurka.phonegap.client.file.js.DirectoryReaderJsImpl::reader);

		reader.readEntries($entry(suc), $entry(fail));

	}-*/;

	private void onReadEntriesFailure(FileCallback<LightArray<EntryBase>, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onReadEntriesSuccess(FileCallback<LightArray<EntryBase>, FileError> callback, JavaScriptObject entries) {
		callback.onSuccess(new JsLightArray<EntryBase>(entries));
	}

}
