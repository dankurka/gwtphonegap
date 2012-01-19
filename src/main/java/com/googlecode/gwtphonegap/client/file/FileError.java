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

public interface FileError {

	public static final int NOT_FOUND_ERR = 1;
	public static final int SECURITY_ERR = 2;
	public static final int ABORT_ERR = 3;
	public static final int NOT_READABLE_ERR = 4;
	public static final int ENCODING_ERR = 5;
	public static final int NO_MODIFICATION_ALLOWED_ERR = 6;
	public static final int INVALID_STATE_ERR = 7;
	public static final int SYNTAX_ERR = 8;
	public static final int INVALID_MODIFICATION_ERR = 9;
	public static final int QUOTA_EXCEEDED_ERR = 10;
	public static final int TYPE_MISMATCH_ERR = 11;
	public static final int PATH_EXISTS_ERR = 12;

	public int getErrorCode();
}
