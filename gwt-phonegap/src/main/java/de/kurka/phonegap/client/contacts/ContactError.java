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
package de.kurka.phonegap.client.contacts;

public interface ContactError {
	public static final int UNKNOWN_ERROR = 0;
	public static final int INVALID_ARGUMENT_ERROR = 1;
	public static final int NOT_FOUND_ERROR = 2;
	public static final int TIMEOUT_ERROR = 3;
	public static final int PENDING_OPERATION_ERROR = 4;
	public static final int IO_ERROR = 5;
	public static final int NOT_SUPPORTED_ERROR = 6;
	public static final int PERMISSION_DENIED_ERROR = 7;

	public int getCode();
}
