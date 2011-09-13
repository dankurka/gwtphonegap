package de.kurka.phonegap.client.file;

public interface DirectoryEntry {

	public String getName();

	public String getFullPath();

	public void getMetadata(FileCallback<Metadata, FileError> callback);

	public void moveTo(DirectoryEntry parent, String newName, FileCallback<DirectoryEntry, FileError> callback);

	public void copyTo(DirectoryEntry parent, String newName, FileCallback<DirectoryEntry, FileError> callback);

	public String toURI();

	public void remove(FileCallback<Boolean, FileError> callback);

	public void getParent(FileCallback<DirectoryEntry, FileError> callback);

	public DirectoryReader createReader();

	public void getDirectory(String path, Flags flags, FileCallback<DirectoryEntry, FileError> callback);

	public void getFile(String path, Flags flags, FileCallback<DirectoryEntry, FileError> callback);

	public void removeRecursively(FileCallback<Boolean, FileError> callback);

}
