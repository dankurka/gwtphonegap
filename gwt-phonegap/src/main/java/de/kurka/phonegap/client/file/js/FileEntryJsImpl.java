package de.kurka.phonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.file.DirectoryEntry;
import de.kurka.phonegap.client.file.FileCallback;
import de.kurka.phonegap.client.file.FileEntry;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.FileObject;
import de.kurka.phonegap.client.file.FileWriter;
import de.kurka.phonegap.client.file.Metadata;

public class FileEntryJsImpl implements FileEntry {

	private final JavaScriptObject entry;

	public FileEntryJsImpl(JavaScriptObject entry) {
		this.entry = entry;
	}

	@Override
	public native String getName() /*-{
		return (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry).name;
	}-*/;

	@Override
	public native String getFullPath() /*-{
		return (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry).fullPath;
	}-*/;

	@Override
	public native void getMetadata(FileCallback<Metadata, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onGetMetaDataFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(meta) {
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onGetMetaDataSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/js/MetaDataJsImpl;)(callback, meta);
		};

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);
		entry.getMetadata(suc, fail);

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
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onMoveToFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onMoveToSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.moveTo(parent, newName, suc, fail);

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
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onCopyToFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onCopyToSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.copyTo(parent, newName, suc, fail);

	}-*/;

	private void onCopyToFailure(FileCallback<FileEntry, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onCopyToSuccess(FileCallback<FileEntry, FileError> callback, JavaScriptObject entry) {
		callback.onSuccess(new FileEntryJsImpl(entry));
	}

	@Override
	public native String toURI() /*-{
		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);
		return entry.toURI();
	}-*/;

	@Override
	public native void remove(FileCallback<Boolean, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onRemoveFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onRemoveSuccess(Lde/kurka/phonegap/client/file/FileCallback;)(callback);
		};

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.remove(suc, fail);

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
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onGetParentFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onGetParentSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.getParent(suc, fail);

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
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onCreateWriterFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(writer) {
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onCreateWriterSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, writer);

		};

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.createWriter(suc, fail);

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
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onGetFileFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(file) {
			that.@de.kurka.phonegap.client.file.js.FileEntryJsImpl::onGetFileSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/js/FileObjectJsImpl;)(callback, file);
		};

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.file(suc, fail);

	}-*/;

	private void onGetFileFailure(FileCallback<FileObject, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onGetFileSuccess(FileCallback<FileObject, FileError> callback, FileObjectJsImpl fileObject) {
		callback.onSuccess(fileObject);
	}

}
