package com.googlecode.gwtphonegap.client.file;

public interface FileEntry {

	/**
	 *  The name of the FileEntry, excluding the path leading to it. (DOMString)
	 * @return
	 */
	public String getName();

	/**
	 * The full absolute path from the root to the FileEntry. (DOMString)
	 * @return
	 */
	public String getFullPath();

	/**
	 * Look up metadata about a file.
	 * @param callback
	 */
	public void getMetadata(FileCallback<Metadata, FileError> callback);

	/**
	 * Move a file to a different location on the file system.
	 * @param parent
	 * @param newName
	 * @param callback
	 */
	public void moveTo(DirectoryEntry parent, String newName, FileCallback<FileEntry, FileError> callback);

	/**
	 * Copy a file to a different location on the file system.
	 * @param parent
	 * @param newName
	 * @param callback
	 */
	public void copyTo(DirectoryEntry parent, String newName, FileCallback<FileEntry, FileError> callback);

	/**
	 * Return a URI that can be used to locate a file.
	 * @return
	 */
	public String toURI();

	public void remove(FileCallback<Boolean, FileError> callback);

	public void getParent(FileCallback<DirectoryEntry, FileError> callback);

	public void createWriter(FileCallback<FileWriter, FileError> callback);

	public void getFile(FileCallback<FileObject, FileError> callback);

}
