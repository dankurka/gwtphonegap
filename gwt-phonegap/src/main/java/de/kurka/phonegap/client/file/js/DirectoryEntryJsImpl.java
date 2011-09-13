package de.kurka.phonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.file.DirectoryEntry;
import de.kurka.phonegap.client.file.DirectoryReader;
import de.kurka.phonegap.client.file.FileCallback;
import de.kurka.phonegap.client.file.FileEntry;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.Flags;
import de.kurka.phonegap.client.file.Metadata;

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
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onMetaDataFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/js/FileErrorJsImpl;)( callback, error);
		};

		var suc = function(meta) {
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onMetaDataSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/js/MetaDataJsImpl;)( callback, meta);
		};

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);
		entry.getMetadata(suc, fail);

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
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onMoveToFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onMoveToSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.moveTo(parent, newName, suc, fail);

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
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onCopyToFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onCopyToSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.copyTo(parent, newName, suc, fail);

	}-*/;

	private void onCopyToFailure(FileCallback<DirectoryEntry, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onCopyToSuccess(FileCallback<DirectoryEntry, FileError> callback, JavaScriptObject entry) {
		callback.onSuccess(new DirectoryEntryJsImpl(entry));
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
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onRemoveFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function() {
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onRemoveSuccess(Lde/kurka/phonegap/client/file/FileCallback;)(callback);
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
	public native void getParent(FileCallback<DirectoryEntry, FileError> callback)/*-{
		var that = this;

		var fail = function(error) {
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onGetParentFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onGetParentSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
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
	public DirectoryReader createReader() {
		return new DirectoryReaderJsImpl(createReader0());
	}

	private native JavaScriptObject createReader0() /*-{
		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);
		return entry.createReader();
	}-*/;

	@Override
	public native void getDirectory(String path, Flags flags, FileCallback<DirectoryEntry, FileError> callback) /*-{

		var that = this;
		var fail = function(error) {
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onGetDirectoryFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onGetDirectorySuccess(Lde/kurka/phonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var options = {};

		options.create = flags.@de.kurka.phonegap.client.file.Flags::isCreate()();
		options.exclusive = flags.@de.kurka.phonegap.client.file.Flags::isExclusive()();

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.getDirectory(path, options, suc, fail);
	}-*/;

	private void onGetDirectoryFailure(FileCallback<DirectoryEntry, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onGetDirectorySuccess(FileCallback<DirectoryEntry, FileError> callback, JavaScriptObject entry) {
		callback.onSuccess(new DirectoryEntryJsImpl(entry));
	}

	@Override
	public native void getFile(String path, Flags flags, FileCallback<DirectoryEntry, FileError> callback) /*-{
		var that = this;

		var fail = function(error) {
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onGetFileFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onGetFileSuccess(Lde/kurka/phonegap/client/file/FileCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, entry);
		};

		var options = {};

		options.create = flags.@de.kurka.phonegap.client.file.Flags::isCreate()();
		options.exclusive = flags.@de.kurka.phonegap.client.file.Flags::isExclusive()();

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.getFile(path, options, suc, fail);
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
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onRemoveRecursivelyFailure(Lde/kurka/phonegap/client/file/FileCallback;Lde/kurka/phonegap/client/file/FileError;)(callback, error);
		};

		var suc = function(entry) {
			that.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::onRemoveRecursivelySuccess(Lde/kurka/phonegap/client/file/FileCallback;)(callback);

		};

		var entry = (this.@de.kurka.phonegap.client.file.js.DirectoryEntryJsImpl::entry);

		entry.removeRecursively(suc, fail);
	}-*/;

	private void onRemoveRecursivelyFailure(FileCallback<Boolean, FileError> callback, FileError error) {
		callback.onFailure(error);
	}

	private void onRemoveRecursivelySuccess(FileCallback<Boolean, FileError> callback) {
		callback.onSuccess(Boolean.TRUE);
	}

}
