package com.googlecode.gwtphonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.DirectoryReader;
import com.googlecode.gwtphonegap.client.file.EntryBase;
import com.googlecode.gwtphonegap.client.file.FileCallback;
import com.googlecode.gwtphonegap.client.file.FileError;

import de.kurka.gwt.collection.client.JsLightArray;
import de.kurka.gwt.collection.shared.LightArray;

public class DirectoryReaderJsImpl implements DirectoryReader {

	private final JavaScriptObject reader;

	public DirectoryReaderJsImpl(JavaScriptObject reader) {
		this.reader = reader;
	}

	@Override
	public native void readEntries(FileCallback<LightArray<EntryBase>, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryReaderJsImpl::onReadEntriesFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);

		};

		var suc = function(entries) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryReaderJsImpl::onReadEntriesSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entries);
		};

		var reader = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryReaderJsImpl::reader);

		reader.readEntries($entry(suc), $entry(fail));

	}-*/;

	private void onReadEntriesFailure(FileCallback<LightArray<EntryBase>, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onReadEntriesSuccess(FileCallback<LightArray<EntryBase>, FileError> callback, JavaScriptObject entries) {
		callback.onSuccess(new JsLightArray<EntryBase>(entries));
	}

}
