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
public class FileWriterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5078811059645414100L;
	private String fullPath;
	private long position;
	private long size;
	private String name;

	@SuppressWarnings("unused")
	private FileWriterDTO() {
	}

	public FileWriterDTO(String fullPath, String name, long size, long position) {
		this.fullPath = fullPath;
		this.name = name;
		this.size = size;
		this.position = position;

	}

	/**
	 * @return the fullPath
	 */
	public String getFullPath() {
		return fullPath;
	}

	/**
	 * @return the position
	 */
	public long getPosition() {
		return position;
	}

	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param position2
	 */
	public void setPosition(long position) {
		this.position = position;

	}

	/**
	 * @param length
	 */
	public void setSize(long length) {
		this.size = length;

	}
}
