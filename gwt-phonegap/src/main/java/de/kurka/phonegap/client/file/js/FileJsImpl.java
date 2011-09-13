package de.kurka.phonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.file.EntryBase;
import de.kurka.phonegap.client.file.File;
import de.kurka.phonegap.client.file.FileCallback;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.FileSystem;

public class FileJsImpl implements File {

	@Override
	public native void requestFileSystem(int fileSystemType, int size, FileCallback<FileSystem, FileError> callback) /*-{
		var that = this;
		var fail = function(error) {
			that.@de.kurka.phonegap.client.file.js.FileJsImpl::requestFileSystemOnFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(system) {
			that.@de.kurka.phonegap.client.file.js.FileJsImpl::requestFileSystemOnSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, system);
		};

		$wnd.requestFileSystem(fileSystemType, size, suc, fail);

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
			that.@de.kurka.phonegap.client.file.js.FileJsImpl::resolveLocalFileSystemURIOnFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@de.kurka.phonegap.client.file.js.FileJsImpl::resolveLocalFileSystemURIOnSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/js/EntryBaseJsImpl;)(callback, entry);
		};

		$wnd.resolveLocalFileSystemURI(url, suc, fail);

	}-*/;

	private void resolveLocalFileSystemURIOnFailure(FileCallback<EntryBase, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void resolveLocalFileSystemURIOnSuccess(FileCallback<EntryBase, FileError> callback, EntryBaseJsImpl system) {
		callback.onSuccess(system);
	}

}
