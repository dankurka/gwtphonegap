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
import com.googlecode.gwtphonegap.client.file.DirectoryReader;
import com.googlecode.gwtphonegap.client.file.FileCallback;
import com.googlecode.gwtphonegap.client.file.FileEntry;
import com.googlecode.gwtphonegap.client.file.FileError;
import com.googlecode.gwtphonegap.client.file.Flags;
import com.googlecode.gwtphonegap.client.file.Metadata;

public class DirectoryEntryJsImpl implements DirectoryEntry {

	private final JavaScriptObject entry;

	public DirectoryEntryJsImpl(JavaScriptObject entry) {
		this.entry = entry;
	}

	public JavaScriptObject getEntry() {
		return entry;
	}

	@Override
	public native String getName() /*-{
		return (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry).name;
	}-*/;

	@Override
	public native String getFullPath() /*-{
		return (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry).fullPath;
	}-*/;

	@Override
	public native void getMetadata(FileCallback<Metadata, FileError> callback) /*-{
		var that = this;
		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onMetaDataFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/js/FileErrorJsImpl;)( callback, error);
		};

		var suc = function(meta) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onMetaDataSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/js/MetaDataJsImpl;)( callback, meta);
		};

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);
		entry.getMetadata($entry(suc), $entry(fail));

	}-*/;

	private void onMetaDataFailure(FileCallback<Metadata, FileError> callback, FileErrorJsImpl error) {
		callback.onFailure(error);
	}

	private void onMetaDataSuccess(FileCallback<Metadata, FileError> callback, MetaDataJsImpl meta) {
		callback.onSuccess(meta);
	}

	@Override
	public void moveTo(DirectoryEntry parent, String newName, FileCallback<DirectoryEntry, FileError> callback) {
		moveTo0(((DirectoryEntryJsImpl) parent).entry, newName, callback);
	}

	private native void moveTo0(JavaScriptObject parent, String newName, FileCallback<DirectoryEntry, FileError> callback) /*-{
		var that = this;
		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onMoveToFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onMoveToSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.moveTo(parent, newName, $entry(suc), $entry(fail));

	}-*/;

	private void onMoveToFailure(FileCallback<DirectoryEntry, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onMoveToSuccess(FileCallback<DirectoryEntry, FileError> callback, JavaScriptObject entry) {
		callback.onSuccess(new DirectoryEntryJsImpl(entry));
	}

	@Override
	public void copyTo(DirectoryEntry parent, String newName, FileCallback<DirectoryEntry, FileError> callback) {
		copyTo0(((DirectoryEntryJsImpl) parent).entry, newName, callback);

	}

	private native void copyTo0(JavaScriptObject parent, String newName, FileCallback<DirectoryEntry, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onCopyToFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onCopyToSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.copyTo(parent, newName, $entry(suc), $entry(fail));

	}-*/;

	private void onCopyToFailure(FileCallback<DirectoryEntry, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onCopyToSuccess(FileCallback<DirectoryEntry, FileError> callback, JavaScriptObject entry) {
		callback.onSuccess(new DirectoryEntryJsImpl(entry));
	}

	@Override
	public native String toURI() /*-{
		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);
		return entry.toURI();
	}-*/;

	@Override
	public native void remove(FileCallback<Boolean, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onRemoveFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function() {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onRemoveSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;)(callback);
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
	public native void getParent(FileCallback<DirectoryEntry, FileError> callback)/*-{
		var that = this;

		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onGetParentFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onGetParentSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
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
	public DirectoryReader createReader() {
		return new DirectoryReaderJsImpl(createReader0());
	}

	private native JavaScriptObject createReader0() /*-{
		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);
		return entry.createReader();
	}-*/;

	@Override
	public native void getDirectory(String path, Flags flags, FileCallback<DirectoryEntry, FileError> callback) /*-{

		var that = this;
		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onGetDirectoryFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onGetDirectorySuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var options = {};

		options.create = flags.@com.googlecode.gwtphonegap.client.file.Flags::isCreate()();
		options.exclusive = flags.@com.googlecode.gwtphonegap.client.file.Flags::isExclusive()();

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.getDirectory(path, options, $entry(suc), $entry(fail));
	}-*/;

	private void onGetDirectoryFailure(FileCallback<DirectoryEntry, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onGetDirectorySuccess(FileCallback<DirectoryEntry, FileError> callback, JavaScriptObject entry) {
		callback.onSuccess(new DirectoryEntryJsImpl(entry));
	}

	@Override
	public native void getFile(String path, Flags flags, FileCallback<FileEntry, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onGetFileFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onGetFileSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var options = {};

		options.create = flags.@com.googlecode.gwtphonegap.client.file.Flags::isCreate()();
		options.exclusive = flags.@com.googlecode.gwtphonegap.client.file.Flags::isExclusive()();

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.getFile(path, options, $entry(suc), $entry(fail));
	}-*/;

	private void onGetFileFailure(FileCallback<FileEntry, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onGetFileSuccess(FileCallback<FileEntry, FileError> callback, JavaScriptObject entry) {
		callback.onSuccess(new FileEntryJsImpl(entry));
	}

	@Override
	public native void removeRecursively(FileCallback<Boolean, FileError> callback)/*-{
		var that = this;

		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onRemoveRecursivelyFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::onRemoveRecursivelySuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;)(callback);

		};

		var entry = (this.@com.googlecode.gwtphonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.removeRecursively($entry(suc), $entry(fail));
	}-*/;

	private void onRemoveRecursivelyFailure(FileCallback<Boolean, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onRemoveRecursivelySuccess(FileCallback<Boolean, FileError> callback) {
		callback.onSuccess(Boolean.TRUE);
	}

}
