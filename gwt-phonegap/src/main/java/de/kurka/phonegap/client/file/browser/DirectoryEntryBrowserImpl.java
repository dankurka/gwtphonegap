/*
 * Copyright 2010 Daniel Kurka
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

import de.kurka.gwt.collection.shared.LightArray;
import de.kurka.phonegap.client.file.DirectoryEntry;
import de.kurka.phonegap.client.file.DirectoryReader;
import de.kurka.phonegap.client.file.EntryBase;
import de.kurka.phonegap.client.file.FileCallback;
import de.kurka.phonegap.client.file.FileEntry;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.Flags;
import de.kurka.phonegap.client.file.Metadata;
import de.kurka.phonegap.client.file.browser.dto.FileSystemEntryDTO;
import de.kurka.phonegap.client.file.browser.service.FileSystemController;

public class DirectoryEntryBrowserImpl implements DirectoryEntry, EntryBase {

	private final FileSystemController controller;

	private FileSystemEntryDTO dto;

	public DirectoryEntryBrowserImpl(FileSystemEntryDTO dto, FileSystemController controller) {
		this.controller = controller;
		this.dto = dto;
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
	public void moveTo(DirectoryEntry parent, String newName, FileCallback<DirectoryEntry, FileError> callback) {
		controller.moveDirectory(getFullPath(), parent.getFullPath(), newName, callback);
	}

	@Override
	public void copyTo(DirectoryEntry parent, String newName, FileCallback<DirectoryEntry, FileError> callback) {
		controller.copyDirectory(getFullPath(), parent.getFullPath(), newName, callback);

	}

	@Override
	public String toURI() {
		return controller.toURI(getFullPath());
	}

	@Override
	public void remove(FileCallback<Boolean, FileError> callback) {
		controller.removeDirectory(getFullPath(), callback);

	}

	@Override
	public void getParent(FileCallback<DirectoryEntry, FileError> callback) {

		String fullPath = getFullPath();

		controller.readParent(fullPath, callback);

	}

	@Override
	public DirectoryReader createReader() {
		return new DirectoryReader() {

			@Override
			public void readEntries(final FileCallback<LightArray<EntryBase>, FileError> callback) {
				controller.readDirectory(dto.getFullPath(), callback);

			}
		};
	}

	@Override
	public void getDirectory(String path, Flags flags, FileCallback<DirectoryEntry, FileError> callback) {
		String absPath;
		if (path.startsWith("/")) {
			// absolute
			absPath = path;
		} else {
			absPath = getFullPath() + "/" + path;
		}
		controller.getDirectory(absPath, flags, callback);

	}

	@Override
	public void getFile(String path, Flags flags, FileCallback<FileEntry, FileError> callback) {
		String absPath;
		if (path.startsWith("/")) {
			// absolute
			absPath = path;
		} else {
			absPath = getFullPath() + "/" + path;
		}
		controller.getFile(absPath, flags, callback);

	}

	@Override
	public void removeRecursively(FileCallback<Boolean, FileError> callback) {
		controller.removeRecursively(getFullPath(), callback);

	}

	@Override
	public boolean isFile() {
		return false;
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	@Override
	public FileEntry getAsFileEntry() {
		throw new RuntimeException();
	}

	@Override
	public DirectoryEntry getAsDirectoryEntry() {
		return this;
	}

}
