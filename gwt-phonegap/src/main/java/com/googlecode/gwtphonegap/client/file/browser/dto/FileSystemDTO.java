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
package com.googlecode.gwtphonegap.client.file.browser.dto;

import java.io.Serializable;

/**
 * @author Daniel Kurka
 * 
 */
public class FileSystemDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6950468582951428273L;
	private FileSystemEntryDTO fileSystemEntry;
	private String name;

	//GWT
	@SuppressWarnings("unused")
	private FileSystemDTO() {

	}

	public FileSystemDTO(FileSystemEntryDTO fileSystemEntry, String name) {
		this.fileSystemEntry = fileSystemEntry;
		this.name = name;
	}

	/**
	 * @return the fileSystemEntry
	 */
	public FileSystemEntryDTO getFileSystemEntry() {
		return fileSystemEntry;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
