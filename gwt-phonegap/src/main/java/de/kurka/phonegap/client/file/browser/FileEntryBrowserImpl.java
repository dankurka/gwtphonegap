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
package de.kurka.phonegap.client.file.browser;

import de.kurka.phonegap.client.file.DirectoryEntry;
import de.kurka.phonegap.client.file.EntryBase;
import de.kurka.phonegap.client.file.FileCallback;
import de.kurka.phonegap.client.file.FileEntry;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.FileObject;
import de.kurka.phonegap.client.file.FileWriter;
import de.kurka.phonegap.client.file.Metadata;
import de.kurka.phonegap.client.file.browser.dto.FileSystemEntryDTO;
import de.kurka.phonegap.client.file.browser.service.FileSystemController;

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

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.FileEntry#getMetadata(de.kurka.phonegap.client.file.FileCallback)
	 */
	@Override
	public void getMetadata(FileCallback<Metadata, FileError> callback) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.FileEntry#moveTo(de.kurka.phonegap.client.file.DirectoryEntry, java.lang.String, de.kurka.phonegap.client.file.FileCallback)
	 */
	@Override
	public void moveTo(DirectoryEntry parent, String newName, FileCallback<FileEntry, FileError> callback) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.FileEntry#copyTo(de.kurka.phonegap.client.file.DirectoryEntry, java.lang.String, de.kurka.phonegap.client.file.FileCallback)
	 */
	@Override
	public void copyTo(DirectoryEntry parent, String newName, FileCallback<FileEntry, FileError> callback) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.FileEntry#toURI()
	 */
	@Override
	public String toURI() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.FileEntry#remove(de.kurka.phonegap.client.file.FileCallback)
	 */
	@Override
	public void remove(FileCallback<Boolean, FileError> callback) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.FileEntry#getParent(de.kurka.phonegap.client.file.FileCallback)
	 */
	@Override
	public void getParent(FileCallback<DirectoryEntry, FileError> callback) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.FileEntry#createWriter(de.kurka.phonegap.client.file.FileCallback)
	 */
	@Override
	public void createWriter(FileCallback<FileWriter, FileError> callback) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.FileEntry#getFile(de.kurka.phonegap.client.file.FileCallback)
	 */
	@Override
	public void getFile(FileCallback<FileObject, FileError> callback) {
		// TODO Auto-generated method stub

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
