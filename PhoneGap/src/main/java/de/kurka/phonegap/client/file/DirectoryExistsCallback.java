package de.kurka.phonegap.client.file;

public interface DirectoryExistsCallback {
	public void onDirectoryExist();

	public void onDirectoryNotExist();

	public void onFailure();
}
