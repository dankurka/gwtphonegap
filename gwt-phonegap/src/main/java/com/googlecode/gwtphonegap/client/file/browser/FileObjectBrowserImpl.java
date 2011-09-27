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
package com.googlecode.gwtphonegap.client.file.browser;

import java.util.Date;

import com.googlecode.gwtphonegap.client.file.FileObject;
import com.googlecode.gwtphonegap.client.file.browser.dto.FileObjectDTO;


/**
 * @author Daniel Kurka
 * 
 */
public class FileObjectBrowserImpl implements FileObject {

	private final FileObjectDTO dto;

	public FileObjectBrowserImpl(FileObjectDTO dto) {
		this.dto = dto;

	}

	@Override
	public String getName() {
		return dto.getName();
	}

	@Override
	public String getFullPath() {
		return dto.getFullPath();
	}

	@Override
	public String getType() {
		return dto.getType();
	}

	@Override
	public Date getLastModifiedDate() {
		return dto.getLastModified();
	}

	@Override
	public long size() {
		return dto.getSize();
	}

}
