/*
 * Copyright 2013 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.globalization;

/**
 * An object representing a error from the Globalization API.
 * This object is created and populated by Cordova, and returned to a callback in the case of an error.
 */
public interface GlobalizationError {

  public static final int UNKNOWN_ERROR = 0;
  public static final int FORMATTING_ERROR = 1;
  public static final int PARSING_ERROR = 2;
  public static final int PATTERN_ERROR = 3;

    /**
     * One of the error codes representing the error type (Number)
     * @return
     */
  public int getCode();

    /**
     * A text message that includes the error's explanation and/or details (String)
     * @return
     */
  public String getMessage();
}
