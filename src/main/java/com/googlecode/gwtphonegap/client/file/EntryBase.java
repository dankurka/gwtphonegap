package com.googlecode.gwtphonegap.client.file;

public interface EntryBase {
	public boolean isFile();

	public boolean isDirectory();

	public FileEntry getAsFileEntry();

	public DirectoryEntry getAsDirectoryEntry();
}
