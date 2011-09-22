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
package de.kurka.phonegap.client.file.browser.service;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.kurka.gwt.collection.shared.GwtCollectionFactory;
import de.kurka.gwt.collection.shared.LightArray;
import de.kurka.phonegap.client.file.DirectoryEntry;
import de.kurka.phonegap.client.file.EntryBase;
import de.kurka.phonegap.client.file.FileCallback;
import de.kurka.phonegap.client.file.FileEntry;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.FileSystem;
import de.kurka.phonegap.client.file.FileWriter;
import de.kurka.phonegap.client.file.Metadata;
import de.kurka.phonegap.client.file.browser.DirectoryEntryBrowserImpl;
import de.kurka.phonegap.client.file.browser.FileEntryBrowserImpl;
import de.kurka.phonegap.client.file.browser.FileErrorException;
import de.kurka.phonegap.client.file.browser.FileSystemBrowserImpl;
import de.kurka.phonegap.client.file.browser.FileWriterBrowserImpl;
import de.kurka.phonegap.client.file.browser.MetaDataBrowserImpl;
import de.kurka.phonegap.client.file.browser.dto.FileSystemDTO;
import de.kurka.phonegap.client.file.browser.dto.FileSystemEntryDTO;
import de.kurka.phonegap.client.file.browser.dto.FileWriterDTO;
import de.kurka.phonegap.client.file.browser.dto.MetaDataDTO;

/**
 * @author Daniel Kurka
 * 
 */
public class FileSystemController {
	private static final FileRemoteServiceAsync service = GWT.create(FileRemoteService.class);

	/**
	 * @param fullPath
	 * @param callback
	 */
	public void readDirectory(String fullPath, final FileCallback<LightArray<EntryBase>, FileError> callback) {
		service.readDirectory(fullPath, new AsyncCallback<ArrayList<FileSystemEntryDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				if (caught instanceof FileErrorException) {
					FileErrorException fileErrorException = (FileErrorException) caught;
					callback.onFailure(fileErrorException);
				} else {
					callback.onFailure(new FileErrorException(FileError.INVALID_STATE_ERR));
				}

			}

			@Override
			public void onSuccess(ArrayList<FileSystemEntryDTO> result) {

				LightArray<EntryBase> entries = GwtCollectionFactory.constructArray();
				for (FileSystemEntryDTO entry : result) {

					EntryBase base;
					if (entry.isFile()) {
						base = new FileEntryBrowserImpl(entry, FileSystemController.this);
					} else {
						base = new DirectoryEntryBrowserImpl(entry, FileSystemController.this);
					}
					entries.push(base);
				}
				callback.onSuccess(entries);

			}
		});
	}

	/**
	 * @param fileSystemType
	 * @param size
	 * @param callback
	 */
	public void requestFileSystem(int fileSystemType, int size, final FileCallback<FileSystem, FileError> callback) {
		service.requestFileSystem(fileSystemType, size, new AsyncCallback<FileSystemDTO>() {

			@Override
			public void onSuccess(FileSystemDTO result) {
				FileSystemBrowserImpl fileSystemBrowserImpl = new FileSystemBrowserImpl(result, FileSystemController.this);
				callback.onSuccess(fileSystemBrowserImpl);

			}

			@Override
			public void onFailure(Throwable caught) {
				if (caught instanceof FileErrorException) {
					FileErrorException fileErrorException = (FileErrorException) caught;
					callback.onFailure(fileErrorException);
				} else {
					callback.onFailure(new FileErrorException(FileError.INVALID_STATE_ERR));
				}

			}
		});

	}

	/**
	 * @param fullPath
	 * @param callback
	 */
	public void readParent(String fullPath, final FileCallback<DirectoryEntry, FileError> callback) {
		service.getParent(fullPath, new AsyncCallback<FileSystemEntryDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				if (caught instanceof FileErrorException) {
					FileErrorException fileErrorException = (FileErrorException) caught;
					callback.onFailure(fileErrorException);
				} else {
					callback.onFailure(new FileErrorException(FileError.INVALID_STATE_ERR));
				}

			}

			@Override
			public void onSuccess(FileSystemEntryDTO result) {
				callback.onSuccess(new DirectoryEntryBrowserImpl(result, FileSystemController.this));

			}
		});

	}

	/**
	 * @param entry
	 * @param asyncCallback
	 */
	public void readAsText(FileEntry entry, AsyncCallback<String> callback) {
		service.readAsText(entry.getFullPath(), callback);

	}

	/**
	 * @param fileEntryBrowserImpl
	 * @param callback
	 */
	public void createWriter(FileEntryBrowserImpl fileEntryBrowserImpl, final FileCallback<FileWriter, FileError> callback) {
		service.createWriter(fileEntryBrowserImpl.getFullPath(), fileEntryBrowserImpl.getName(), new AsyncCallback<FileWriterDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				if (caught instanceof FileErrorException) {
					FileErrorException fileErrorException = (FileErrorException) caught;
					callback.onFailure(fileErrorException);
				} else {
					callback.onFailure(new FileErrorException(FileError.INVALID_STATE_ERR));
				}

			}

			@Override
			public void onSuccess(FileWriterDTO result) {
				FileWriterBrowserImpl fileWriterBrowserImpl = new FileWriterBrowserImpl(result, FileSystemController.this);
				callback.onSuccess(fileWriterBrowserImpl);

			}
		});
	}

	/**
	 * @param result
	 * @param text
	 * @param callback
	 */
	public void writeFile(FileWriterDTO result, String text, AsyncCallback<FileWriterDTO> callback) {
		service.writeFile(result, text, callback);

	}

	/**
	 * @param fullPath
	 * @param callback
	 */
	public void getMetaData(String fullPath, final FileCallback<Metadata, FileError> callback) {
		service.getMetaData(fullPath, new AsyncCallback<MetaDataDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				if (caught instanceof FileErrorException) {
					FileErrorException fileErrorException = (FileErrorException) caught;
					callback.onFailure(fileErrorException);
				} else {
					callback.onFailure(new FileErrorException(FileError.INVALID_STATE_ERR));
				}

			}

			@Override
			public void onSuccess(MetaDataDTO result) {

				callback.onSuccess(new MetaDataBrowserImpl(result));

			}
		});

	}
}
