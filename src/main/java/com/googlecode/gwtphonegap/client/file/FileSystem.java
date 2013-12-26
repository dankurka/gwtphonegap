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

/**
 * The FileSystem object represents information about the file system.
 * The name of the file system is unique across the list of exposed file systems.
 * The root property contains a DirectoryEntry object that represents the file system's root directory.
 */
public interface FileSystem {

	public static final int LocalFileSystem_TEMPORARY = 0;
	public static final int LocalFileSystem_PERSISTENT = 1;
	public static final int LocalFileSystem_RESOURCE = 2;
	public static final int LocalFileSystem_APPLICATION = 3;

    /**
     * The name of the file system. (DOMString)
     * @return
     */
	public String getName();

    /**
     * The root directory of the file system.
     * @return
     */
	public DirectoryEntry getRoot();
}
