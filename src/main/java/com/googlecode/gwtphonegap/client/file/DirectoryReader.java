package com.googlecode.gwtphonegap.client.file;

import com.googlecode.gwtphonegap.collection.shared.LightArray;

public interface DirectoryReader {
	public void readEntries(FileCallback<LightArray<EntryBase>, FileError> callback);

}
