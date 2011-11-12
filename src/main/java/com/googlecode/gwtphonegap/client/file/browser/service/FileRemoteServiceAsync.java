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
package com.googlecode.gwtphonegap.client.file.browser.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.googlecode.gwtphonegap.client.file.browser.dto.FileObjectDTO;
import com.googlecode.gwtphonegap.client.file.browser.dto.FileSystemDTO;
import com.googlecode.gwtphonegap.client.file.browser.dto.FileSystemEntryDTO;
import com.googlecode.gwtphonegap.client.file.browser.dto.FileWriterDTO;
import com.googlecode.gwtphonegap.client.file.browser.dto.FlagsDTO;
import com.googlecode.gwtphonegap.client.file.browser.dto.MetaDataDTO;


public interface FileRemoteServiceAsync {

	void requestFileSystem(int fileSystemType, int size, AsyncCallback<FileSystemDTO> callback);

	void readDirectory(String path, AsyncCallback<ArrayList<FileSystemEntryDTO>> callback);

	/**
	 * @param fullPath
	 */
	void getParent(String fullPath, AsyncCallback<FileSystemEntryDTO> callback);

	/**
	 * @param fullPath
	 * @param callback
	 */
	void readAsText(String fullPath, AsyncCallback<String> callback);

	void createWriter(String fullPath, String name, AsyncCallback<FileWriterDTO> asyncCallback);

	void writeFile(FileWriterDTO fileWriterDTO, String content, AsyncCallback<FileWriterDTO> callback);

	void getMetaData(String fullPath, AsyncCallback<MetaDataDTO> callback);

	/**
	 * @param absPath
	 * @param flagsDTO
	 * @param asyncCallback
	 */
	void getFile(String absPath, FlagsDTO flagsDTO, AsyncCallback<FileSystemEntryDTO> callback);

	void removeDirectory(String fullPath, AsyncCallback<Boolean> callback);

	/**
	 * @param fullPath
	 * @param asyncCallback
	 */
	void removeFile(String fullPath, AsyncCallback<Boolean> callback);

	/**
	 * @param fileFullPath
	 * @param directoryFullPath
	 * @param newName
	 * @param asyncCallback
	 */
	void moveFile(String fileFullPath, String directoryFullPath, String newName, AsyncCallback<FileSystemEntryDTO> callback);

	/**
	 * @param dirPath
	 * @param newName
	 * @param newName2
	 * @param asyncCallback
	 */
	void copyFile(String filePath, String dirPath, String newName, AsyncCallback<FileSystemEntryDTO> callback);

	/**
	 * @param fullPath
	 * @param asyncCallback
	 */
	void getFileObject(String fullPath, AsyncCallback<FileObjectDTO> callback);

	/**
	 * @param absPath
	 * @param flagsDTO
	 * @param asyncCallback
	 */
	void getDirectory(String absPath, FlagsDTO flagsDTO, AsyncCallback<FileSystemEntryDTO> callback);

	/**
	 * @param fullPath
	 * @param asyncCallback
	 */
	void removeRecursively(String fullPath, AsyncCallback<Boolean> callback);

	/**
	 * @param fullPath
	 * @param newParent
	 * @param newName
	 * @param callback
	 */
	void moveDirectory(String fullPath, String newParent, String newName, AsyncCallback<FileSystemEntryDTO> callback);

	/**
	 * @param fullPath
	 * @param newDir
	 * @param newName
	 * @param asyncCallback
	 */
	void copyDiretory(String fullPath, String newDir, String newName, AsyncCallback<FileSystemEntryDTO> callback);

	/**
	 * @param fullPath
	 * @param callback
	 */
	void readAsDataUrl(String fullPath, AsyncCallback<String> callback);

}
