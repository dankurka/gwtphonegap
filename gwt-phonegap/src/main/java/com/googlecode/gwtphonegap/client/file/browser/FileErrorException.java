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
package com.googlecode.gwtphonegap.client.file.browser;

import com.googlecode.gwtphonegap.client.file.FileError;

public class FileErrorException extends Exception implements FileError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3551734285443778204L;
	private int errorCode;

	public FileErrorException() {

	}

	public FileErrorException(int errorCode) {
		this.errorCode = errorCode;

	}

	@Override
	public int getErrorCode() {
		return errorCode;
	}
}
