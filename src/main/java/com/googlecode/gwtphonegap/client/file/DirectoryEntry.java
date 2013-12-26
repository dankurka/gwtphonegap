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

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * This object represents a directory on a file system, as defined by the W3C Directories and Systems specification.
 */
public interface DirectoryEntry {

    /**
     *  The name of the DirectoryEntry, excluding the path leading to it. (DOMString)
     * @return
     */
	public String getName();

    /**
     *  The full absolute path from the root to the DirectoryEntry. (DOMString)
     * @return
     */
	public String getFullPath();

    /**
     * Look up metadata about a directory.
     * @param callback
     */
	public void getMetadata(FileCallback<Metadata, FileError> callback);

    /**
     *  Move a directory to a different location on the file system.
     * @param parent
     * @param newName
     * @param callback
     */
	public void moveTo(DirectoryEntry parent, String newName, FileCallback<DirectoryEntry, FileError> callback);

    /**
     * Copy a directory to a different location on the file system.
     * @param parent
     * @param newName
     * @param callback
     */
	public void copyTo(DirectoryEntry parent, String newName, FileCallback<DirectoryEntry, FileError> callback);

    /**
     * Return a URL to help locate a directory.
     * @return
     */
	public String toURL();

    /**
     * Delete a directory. The directory must be empty.
     * @param callback
     */
	public void remove(FileCallback<Boolean, FileError> callback);

    /**
     * Look up the parent directory.
     * @param callback
     */
	public void getParent(FileCallback<DirectoryEntry, FileError> callback);

    /**
     * Create a new DirectoryReader that can read entries from a directory.
     * @return
     */
	public DirectoryReader createReader();

    /**
     * Create or look up a directory.
     * @param path
     * @param flags
     * @param callback
     */
	public void getDirectory(String path, Flags flags, FileCallback<DirectoryEntry, FileError> callback);

    /**
     * Create or look up a file.
     * @param path
     * @param flags
     * @param callback
     */
	public void getFile(String path, Flags flags, FileCallback<FileEntry, FileError> callback);

    /**
     * Delete a directory and all of its contents.
     * @param callback
     */
	public void removeRecursively(FileCallback<Boolean, FileError> callback);

    /**
     * Sets a directory's extended attributes, or metadata. Currently works only on iOS.
     * Only the com.apple.MobileBackup extended attribute is supported.
     * Set the value to 1 to prevent the directory from being backed up to iCloud.
     * Set the value to 0 to re-enable the directory to be backed up to iCloud.
     * Set the attributes and the values of the metadata as string separated by :
     */
    public void setMetadata(MetaDataCallback callback,Map<String,String> mapMetaInfo);

    /**
     * The file system on which the DirectoryEntry resides. (FileSystem)
     * This attribute is defined by the W3C specification, but is not supported.
     */
    public FileSystem filesystem();

    /**
     * Always false. (boolean)
     * @return
     */
    public boolean isFile();

    /**
     * Always true. (boolean)
     * @return
     */
     public boolean isDirectory();

}
