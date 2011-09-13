package de.kurka.phonegap.client.file;

import de.kurka.gwt.collection.shared.LightArray;

public interface DirectoryReader {
	public void readEntries(FileCallback<LightArray<EntryBase>, FileError> callback);

}
