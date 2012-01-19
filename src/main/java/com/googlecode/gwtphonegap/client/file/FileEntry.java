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

public interface FileEntry {

	/**
	 * The name of the FileEntry, excluding the path leading to it. (DOMString)
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * The full absolute path from the root to the FileEntry. (DOMString)
	 * 
	 * @return
	 */
	public String getFullPath();

	/**
	 * Look up metadata about a file.
	 * 
	 * @param callback
	 */
	public void getMetadata(FileCallback<Metadata, FileError> callback);

	/**
	 * Move a file to a different location on the file system.
	 * 
	 * @param parent
	 * @param newName
	 * @param callback
	 */
	public void moveTo(DirectoryEntry parent, String newName, FileCallback<FileEntry, FileError> callback);

	/**
	 * Copy a file to a different location on the file system.
	 * 
	 * @param parent
	 * @param newName
	 * @param callback
	 */
	public void copyTo(DirectoryEntry parent, String newName, FileCallback<FileEntry, FileError> callback);

	/**
	 * Return a URI that can be used to locate a file.
	 * 
	 * @return
	 */
	public String toURI();

	public void remove(FileCallback<Boolean, FileError> callback);

	public void getParent(FileCallback<DirectoryEntry, FileError> callback);

	public void createWriter(FileCallback<FileWriter, FileError> callback);

	public void getFile(FileCallback<FileObject, FileError> callback);

}
