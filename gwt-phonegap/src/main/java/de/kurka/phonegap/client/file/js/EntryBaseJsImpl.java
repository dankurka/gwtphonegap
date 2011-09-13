package de.kurka.phonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.file.DirectoryEntry;
import de.kurka.phonegap.client.file.EntryBase;
import de.kurka.phonegap.client.file.FileEntry;

public final class EntryBaseJsImpl extends JavaScriptObject implements EntryBase {

	@Override
	public native boolean isFile() /*-{
		return this.isFile;
	}-*/;

	@Override
	public native boolean isDirectory()/*-{
		return this.isDirectory;
	}-*/;

	@Override
	public FileEntry getAsFileEntry() {
		if (!isFile()) {
			throw new IllegalStateException("attempt to convert a EntryBase to FileEntry, but its not a FileEntry");
		}

		return new FileEntryJsImpl(this);
	}

	@Override
	public DirectoryEntry getAsDirectoryEntry() {
		if (!isDirectory()) {
			throw new IllegalStateException("attempt to convert a EntryBase to DirectoryEntry, but its not a DirectoryEntry");
		}

		return new DirectoryEntryJsImpl(this);
	}

}
