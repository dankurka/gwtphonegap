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
package com.googlecode.gwtphonegap.client.file;

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

	public void getFile(String path, Flags flags, FileCallback<FileEntry, FileError> callback);

	public void removeRecursively(FileCallback<Boolean, FileError> callback);

}
