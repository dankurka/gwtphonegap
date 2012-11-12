/*
 * Copyright 2011 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.file.browser;

import com.googlecode.gwtphonegap.client.file.DirectoryEntry;
import com.googlecode.gwtphonegap.client.file.EntryBase;
import com.googlecode.gwtphonegap.client.file.FileCallback;
import com.googlecode.gwtphonegap.client.file.FileEntry;
import com.googlecode.gwtphonegap.client.file.FileError;
import com.googlecode.gwtphonegap.client.file.FileObject;
import com.googlecode.gwtphonegap.client.file.FileWriter;
import com.googlecode.gwtphonegap.client.file.Metadata;
import com.googlecode.gwtphonegap.client.file.browser.dto.FileSystemEntryDTO;
import com.googlecode.gwtphonegap.client.file.browser.service.FileSystemController;

/**
 * @author Daniel Kurka
 * 
 */
public class FileEntryBrowserImpl implements FileEntry, EntryBase {

	private FileSystemEntryDTO dto;
	private final FileSystemController controller;

	public FileEntryBrowserImpl(FileSystemEntryDTO dto, FileSystemController controller) {
		this.dto = dto;
		this.controller = controller;
	}

	@Override
	public String getName() {
		return dto.getName();
	}

	@Override
	public String getFullPath() {
		return dto.getFullPath();
	}

	@Override
	public void getMetadata(FileCallback<Metadata, FileError> callback) {
		controller.getMetaData(getFullPath(), callback);
	}

	@Override
	public void moveTo(DirectoryEntry parent, String newName, FileCallback<FileEntry, FileError> callback) {
		controller.moveFile(getFullPath(), parent.getFullPath(), newName, callback);

	}

	@Override
	public void copyTo(DirectoryEntry parent, String newName, FileCallback<FileEntry, FileError> callback) {
		controller.copyFile(getFullPath(), parent.getFullPath(), newName, callback);

	}

	@Override
	@Deprecated
	public String toURI() {
	  return toURL();
	}
	
  @Override
  public String toURL() {
    return controller.toURI(getFullPath());
  }

	@Override
	public void remove(FileCallback<Boolean, FileError> callback) {
		controller.removeFile(getFullPath(), callback);

	}

	@Override
	public void getParent(FileCallback<DirectoryEntry, FileError> callback) {
		controller.readParent(getFullPath(), callback);

	}

	@Override
	public void createWriter(FileCallback<FileWriter, FileError> callback) {
		controller.createWriter(this, callback);

	}

	@Override
	public void getFile(FileCallback<FileObject, FileError> callback) {
		controller.getFileObject(getFullPath(), callback);

	}

	@Override
	public boolean isFile() {
		return true;
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	@Override
	public FileEntry getAsFileEntry() {
		return this;
	}

	@Override
	public DirectoryEntry getAsDirectoryEntry() {
		throw new RuntimeException();
	}

}
