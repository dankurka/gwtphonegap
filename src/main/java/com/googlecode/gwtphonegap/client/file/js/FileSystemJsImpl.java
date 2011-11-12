package com.googlecode.gwtphonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.DirectoryEntry;
import com.googlecode.gwtphonegap.client.file.EntryBase;
import com.googlecode.gwtphonegap.client.file.FileSystem;


public class FileSystemJsImpl implements FileSystem {

	private final JavaScriptObject system;

	public FileSystemJsImpl(JavaScriptObject system) {
		this.system = system;
	}

	public JavaScriptObject getSystem() {
		return system;
	}

	@Override
	public native String getName() /*-{
		var system = this.@com.googlecode.gwtphonegap.client.file.js.FileSystemJsImpl::system;
		return system.name;
	}-*/;

	@Override
	public DirectoryEntry getRoot() {
		return getRoot0().getAsDirectoryEntry();
	}

	private native EntryBase getRoot0() /*-{
		var system = this.@com.googlecode.gwtphonegap.client.file.js.FileSystemJsImpl::system;
		return system.root;
	}-*/;

}
