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

import de.kurka.phonegap.client.file.FileEntry;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.FileReader;
import de.kurka.phonegap.client.file.ReaderCallback;

public class FileReaderBrowserImpl implements FileReader {

	@Override
	public int getReadyState() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileError getError() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOnLoadStartCallback(ReaderCallback<FileReader> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOnProgressCallback(ReaderCallback<FileReader> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOnloadCallback(ReaderCallback<FileReader> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOnAbortCallback(ReaderCallback<FileReader> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOnErrorCallback(ReaderCallback<FileReader> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOnLoadEndCallback(ReaderCallback<FileReader> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void abort() {
		// TODO Auto-generated method stub

	}

	@Override
	public void readAsDataUrl(FileEntry entry) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readAsText(FileEntry entry) {
		// TODO Auto-generated method stub

	}

}
