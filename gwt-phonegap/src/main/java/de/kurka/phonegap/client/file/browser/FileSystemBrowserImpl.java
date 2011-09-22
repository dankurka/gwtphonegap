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
import de.kurka.phonegap.client.file.FileSystem;
import de.kurka.phonegap.client.file.browser.dto.FileSystemDTO;
import de.kurka.phonegap.client.file.browser.service.FileSystemController;

public class FileSystemBrowserImpl implements FileSystem, Serializable {

	private static final long serialVersionUID = -7344553969341379456L;

	private DirectoryEntryBrowserImpl entry;

	private FileSystemDTO dto;

	public FileSystemBrowserImpl(FileSystemDTO dto, FileSystemController controller) {
		entry = new DirectoryEntryBrowserImpl(dto.getFileSystemEntry(), controller);
		this.dto = dto;
	}

	@Override
	public String getName() {
		return dto.getName();
	}

	@Override
	public DirectoryEntry getRoot() {
		return entry;
	}

	public DirectoryEntryBrowserImpl getEntry() {
		return entry;
	}

}
