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

import java.io.Serializable;

import de.kurka.phonegap.client.file.DirectoryEntry;
import de.kurka.phonegap.client.file.DirectoryReader;
import de.kurka.phonegap.client.file.FileCallback;
import de.kurka.phonegap.client.file.FileEntry;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.Flags;
import de.kurka.phonegap.client.file.Metadata;

public class DirectoryEntryBrowserImpl implements DirectoryEntry, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1991673954591763594L;

	private String name;
	private String fullPath;

	public DirectoryEntryBrowserImpl() {

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getFullPath() {
		return fullPath;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	@Override
	public void getMetadata(FileCallback<Metadata, FileError> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveTo(DirectoryEntry parent, String newName, FileCallback<DirectoryEntry, FileError> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void copyTo(DirectoryEntry parent, String newName, FileCallback<DirectoryEntry, FileError> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(FileCallback<Boolean, FileError> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getParent(FileCallback<DirectoryEntry, FileError> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public DirectoryReader createReader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getDirectory(String path, Flags flags, FileCallback<DirectoryEntry, FileError> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getFile(String path, Flags flags, FileCallback<FileEntry, FileError> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRecursively(FileCallback<Boolean, FileError> callback) {
		// TODO Auto-generated method stub

	}

}
