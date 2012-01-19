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
package com.googlecode.gwtphonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.DirectoryReader;
import com.googlecode.gwtphonegap.client.file.EntryBase;
import com.googlecode.gwtphonegap.client.file.FileCallback;
import com.googlecode.gwtphonegap.client.file.FileError;
import com.googlecode.gwtphonegap.collection.client.JsLightArray;
import com.googlecode.gwtphonegap.collection.shared.LightArray;

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
