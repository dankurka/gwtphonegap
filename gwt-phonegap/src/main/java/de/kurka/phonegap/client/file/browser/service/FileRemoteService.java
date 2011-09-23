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
import de.kurka.phonegap.client.file.browser.dto.FileObjectDTO;
import de.kurka.phonegap.client.file.browser.dto.FileSystemDTO;
import de.kurka.phonegap.client.file.browser.dto.FileSystemEntryDTO;
import de.kurka.phonegap.client.file.browser.dto.FileWriterDTO;
import de.kurka.phonegap.client.file.browser.dto.FlagsDTO;
import de.kurka.phonegap.client.file.browser.dto.MetaDataDTO;

@RemoteServiceRelativePath("phonegapfileapi")
public interface FileRemoteService extends RemoteService {
	public FileSystemDTO requestFileSystem(int fileSystemType, int size) throws FileErrorException;

	ArrayList<FileSystemEntryDTO> readDirectory(String path) throws FileErrorException;

	FileSystemEntryDTO getParent(String fullPath) throws FileErrorException;

	String readAsText(String fullPath) throws FileErrorException;

	FileWriterDTO createWriter(String fullPath, String name) throws FileErrorException;

	FileWriterDTO writeFile(FileWriterDTO fileWriterDTO, String content) throws FileErrorException;

	MetaDataDTO getMetaData(String fullPath) throws FileErrorException;

	FileSystemEntryDTO getFile(String absPath, FlagsDTO flagsDTO) throws FileErrorException;

	Boolean removeDirectory(String fullPath) throws FileErrorException;

	Boolean removeFile(String fullPath) throws FileErrorException;

	FileSystemEntryDTO moveFile(String fileFullPath, String directoryFullPath, String newName) throws FileErrorException;

	FileSystemEntryDTO copyFile(String filePath, String dirPath, String newName) throws FileErrorException;

	FileObjectDTO getFileObject(String fullPath) throws FileErrorException;

	FileSystemEntryDTO getDirectory(String absPath, FlagsDTO flagsDTO) throws FileErrorException;

	Boolean removeRecursively(String fullPath) throws FileErrorException;

	FileSystemEntryDTO moveDirectory(String fullPath, String newParent, String newName) throws FileErrorException;

	FileSystemEntryDTO copyDiretory(String fullPath, String newDir, String newName) throws FileErrorException;

}
