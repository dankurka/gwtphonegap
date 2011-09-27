package com.googlecode.gwtphonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.EntryBase;
import com.googlecode.gwtphonegap.client.file.File;
import com.googlecode.gwtphonegap.client.file.FileCallback;
import com.googlecode.gwtphonegap.client.file.FileError;
import com.googlecode.gwtphonegap.client.file.FileReader;
import com.googlecode.gwtphonegap.client.file.FileSystem;
import com.googlecode.gwtphonegap.client.file.FileTransfer;


public class FileJsImpl implements File {

	@Override
	public native void requestFileSystem(int fileSystemType, int size, FileCallback<FileSystem, FileError> callback) /*-{
		var that = this;
		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileJsImpl::requestFileSystemOnFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(system) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileJsImpl::requestFileSystemOnSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, system);
		};

		$wnd.requestFileSystem(fileSystemType, size, $entry(suc), $entry(fail));

	}-*/;

	private void requestFileSystemOnFailure(FileCallback<FileSystem, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void requestFileSystemOnSuccess(FileCallback<FileSystem, FileError> callback, JavaScriptObject system) {
		callback.onSuccess(new FileSystemJsImpl(system));
	}

	@Override
	public native void resolveLocalFileSystemURI(String url, FileCallback<EntryBase, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileJsImpl::resolveLocalFileSystemURIOnFailure(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@com.googlecode.gwtphonegap.client.file.js.FileJsImpl::resolveLocalFileSystemURIOnSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/js/EntryBaseJsImpl;)(callback, entry);
		};

		$wnd.resolveLocalFileSystemURI(url, $entry(suc), $entry(fail));

	}-*/;

	private void resolveLocalFileSystemURIOnFailure(FileCallback<EntryBase, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void resolveLocalFileSystemURIOnSuccess(FileCallback<EntryBase, FileError> callback, EntryBaseJsImpl system) {
		callback.onSuccess(system);
	}

	@Override
	public native FileTransfer createFileTransfer() /*-{
		return new $wnd.FileTransfer();
	}-*/;

	@Override
	public native FileReader createReader()/*-{
		return new $wnd.FileReader();
	}-*/;

	@Override
	public void setBasePath(String path) {
		//nothing to do here phonegap takes care of this

	}

}
