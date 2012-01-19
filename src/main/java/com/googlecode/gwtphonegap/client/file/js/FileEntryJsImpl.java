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
import com.googlecode.gwtphonegap.client.file.DirectoryEntry;
import com.googlecode.gwtphonegap.client.file.FileCallback;
import com.googlecode.gwtphonegap.client.file.FileEntry;
import com.googlecode.gwtphonegap.client.file.FileError;
import com.googlecode.gwtphonegap.client.file.FileObject;
import com.googlecode.gwtphonegap.client.file.FileWriter;
import com.googlecode.gwtphonegap.client.file.Metadata;

public class FileEntryJsImpl implements FileEntry {

	private final JavaScriptObject entry;

	public FileEntryJsImpl(JavaScriptObject entry) {
		this.entry = entry;
	}

	public JavaScriptObject getEntry() {
		return entry;
	}

	@Override
	public native String getName() /*-{
		return (this.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::entry).name;
	}-*/;

	@Override
	public native String getFullPath() /*-{
		return (this.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::entry).fullPath;
	}-*/;

	@Override
	public native void getMetadata(FileCallback<Metadata, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onGetMetaDataFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(meta) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onGetMetaDataSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/js/MetaDataJsImpl;)(callback, meta);
		};

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);
		entry.getMetadata($entry(suc), $entry(fail));

	}-*/;

	private void onGetMetaDataFailure(FileCallback<Metadata, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onGetMetaDataSuccess(FileCallback<Metadata, FileError> callback, MetaDataJsImpl meta) {
		callback.onSuccess(meta);
	}

	@Override
	public void moveTo(DirectoryEntry parent, String newName, FileCallback<FileEntry, FileError> callback) {
		moveTo0(((DirectoryEntryJsImpl) parent).getEntry(), newName, callback);

	}

	private native void moveTo0(JavaScriptObject parent, String newName, FileCallback<FileEntry, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onMoveToFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onMoveToSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.moveTo(parent, newName, $entry(suc), $entry(fail));

	}-*/;

	private void onMoveToFailure(FileCallback<FileEntry, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onMoveToSuccess(FileCallback<FileEntry, FileError> callback, JavaScriptObject entry) {
		callback.onSuccess(new FileEntryJsImpl(entry));
	}

	@Override
	public void copyTo(DirectoryEntry parent, String newName, FileCallback<FileEntry, FileError> callback) {
		copyTo0(((DirectoryEntryJsImpl) parent).getEntry(), newName, callback);
	}

	private native void copyTo0(JavaScriptObject parent, String newName, FileCallback<FileEntry, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onCopyToFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onCopyToSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.copyTo(parent, newName, $entry(suc), $entry(fail));

	}-*/;

	private void onCopyToFailure(FileCallback<FileEntry, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onCopyToSuccess(FileCallback<FileEntry, FileError> callback, JavaScriptObject entry) {
		callback.onSuccess(new FileEntryJsImpl(entry));
	}

	@Override
	public native String toURI() /*-{
		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::entry);
		return entry.toURI();
	}-*/;

	@Override
	public native void remove(FileCallback<Boolean, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onRemoveFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onRemoveSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;)(callback);
		};

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.remove($entry(suc), $entry(fail));

	}-*/;

	private void onRemoveFailure(FileCallback<Boolean, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onRemoveSuccess(FileCallback<Boolean, FileError> callback) {
		callback.onSuccess(Boolean.TRUE);
	}

	@Override
	public native void getParent(FileCallback<DirectoryEntry, FileError> callback) /*-{
		var that = this;
		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onGetParentFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onGetParentSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.getParent($entry(suc), $entry(fail));

	}-*/;

	private void onGetParentFailure(FileCallback<DirectoryEntry, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onGetParentSuccess(FileCallback<DirectoryEntry, FileError> callback, JavaScriptObject entry) {
		callback.onSuccess(new DirectoryEntryJsImpl(entry));
	}

	@Override
	public native void createWriter(FileCallback<FileWriter, FileError> callback) /*-{
		var that = this;
		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onCreateWriterFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(writer) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onCreateWriterSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, writer);

		};

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::entry);

		entry.createWriter($entry(suc), $entry(fail));

	}-*/;

	private void onCreateWriterFailure(FileCallback<FileWriter, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onCreateWriterSuccess(FileCallback<FileWriter, FileError> callback, JavaScriptObject entry) {
		callback.onSuccess(new FileWriterJsImpl(entry));
	}

	@Override
	public native void getFile(FileCallback<FileObject, FileError> callback) /*-{
		var that = this;
		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onGetFileFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(file) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::onGetFileSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/js/FileObjectJsImpl;)(callback, file);
		};

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::entry);

		entry.file($entry(suc), $entry(fail));

	}-*/;

	private void onGetFileFailure(FileCallback<FileObject, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onGetFileSuccess(FileCallback<FileObject, FileError> callback, FileObjectJsImpl fileObject) {
		callback.onSuccess(fileObject);
	}

}
