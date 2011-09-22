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
package de.kurka.phonegap.client.file.browser.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.kurka.phonegap.client.file.browser.FileErrorException;
import de.kurka.phonegap.client.file.browser.dto.FileSystemDTO;
import de.kurka.phonegap.client.file.browser.dto.FileSystemEntryDTO;

@RemoteServiceRelativePath("phonegapfileapi")
public interface FileRemoteService extends RemoteService {
	public FileSystemDTO requestFileSystem(int fileSystemType, int size) throws FileErrorException;

	ArrayList<FileSystemEntryDTO> readDirectory(String path) throws FileErrorException;

	FileSystemEntryDTO getParent(String fullPath) throws FileErrorException;

	String readAsText(String fullPath) throws FileErrorException;

}
