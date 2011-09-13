package de.kurka.phonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.file.DirectoryEntry;
import de.kurka.phonegap.client.file.EntryBase;
import de.kurka.phonegap.client.file.FileSystem;

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
		var system = @de.kurka.phonegap.client.file.js.FileSystemJsImpl::system;
		return system.name;
	}-*/;

	@Override
	public DirectoryEntry getRoot() {
		return getRoot0().getAsDirectoryEntry();
	}

	private native EntryBase getRoot0() /*-{
		var system = @de.kurka.phonegap.client.file.js.FileSystemJsImpl::system;
		return system.root;
	}-*/;

}
