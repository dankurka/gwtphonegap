package com.googlecode.gwtphonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.*;

/**
 * Created by vkiran on 12/17/13.
 */
public class LocalFileSystemJsImpl implements LocalFileSystem {
    @Override
    public native void requestFileSystem(int type, long fileSize, FileCallback<FileSystem, FileError> callback) /*-{
        var fail = function(error) {
            that.@com.googlecode.gwtphonegap.client.file.js.LocalFileSystemJsImpl::requestFileSystemError(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/js/FileErrorJsImpl;)(callback,error);
        };

        var onFileSystemSuccess = function(fileSystem) {
            that.@com.googlecode.gwtphonegap.client.file.js.LocalFileSystemJsImpl::requestFileSystemSuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,fileSystem);
        };

        $wnd.requestFileSystem(type, fileSize, $entry(onFileSystemSuccess), $entry(fail));

    }-*/;

    @Override
    public native void resolveLocalFileSystemURI(String uri, FileCallback<EntryBase, FileError> callback) /*-{
        var fail = function(error) {
            that.@com.googlecode.gwtphonegap.client.file.js.LocalFileSystemJsImpl::resolveLocalFileSystemURIError(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/FileError;)(callback,error)
        };

        var onFileSystemSuccess = function(fileEntry) {
            that.@com.googlecode.gwtphonegap.client.file.js.LocalFileSystemJsImpl::resolveLocalFileSystemURISuccess(Lcom/googlecode/gwtphonegap/client/file/FileCallback;Lcom/googlecode/gwtphonegap/client/file/js/EntryBaseJsImpl;)(callback,fileEntry);
        };

        $wnd.resolveLocalFileSystemURI(uri, $entry(onFileSystemSuccess), $entry(fail));
    }-*/;

    private void requestFileSystemError(FileCallback<FileSystem, FileError> callback, FileErrorJsImpl error) {
        callback.onFailure(error);
    }

    private void requestFileSystemSuccess(FileCallback<FileSystem, FileError> callback, JavaScriptObject system) {
        callback.onSuccess(new FileSystemJsImpl(system));
    }

    private void resolveLocalFileSystemURIError(FileCallback<EntryBase, FileError> callback, FileError error) {
        callback.onFailure(error);
    }

    private void resolveLocalFileSystemURISuccess(FileCallback<EntryBase, FileError> callback, EntryBaseJsImpl entry) {
        callback.onSuccess(entry);
    }
}
