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
package com.googlecode.gwtphonegap.client.file;

/**
 * Supplies arguments to the DirectoryEntry object's getFile() and getDirectory() methods,
 * which look up or create files and directories, respectively.
 */
public class Flags {

    /**
     * Indicates that the file or directory should be created if it does not already exist. (boolean)
     */
	private boolean create;

    /**
     * Has has no effect by itself, but when used with create causes the file or directory creation
     * to fail if the target path already exists. (boolean)
     */
	private boolean exclusive;

	public Flags() {

	}

	public Flags(boolean create, boolean exclusive) {
		this.create = create;
		this.exclusive = exclusive;

	}

	public void setCreate(boolean create) {
		this.create = create;
	}

	public void setExclusive(boolean exclusive) {
		this.exclusive = exclusive;
	}

	public boolean isCreate() {
		return create;
	}

	public boolean isExclusive() {
		return exclusive;
	}

}
