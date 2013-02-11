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

import java.util.Date;

public interface Globalization {
  /**
   * Returns the string identifier for the client's current language. It returns the language
   * identifier string to the successCB callback with a properties object as a parameter. If there
   * is an error getting the language, then the errorCB callback is invoked.
   * 
   * @param callback the callback that is invoked after data is ready
   */
  public void getPreferedLanguage(GlobalizationCallback<Language, GlobalizationError> callback);

  /**
   * Returns the string identifier for the client's current locale setting. It returns the locale
   * identifier string to the successCB callback with a properties object as a parameter. If there
   * is an error getting the locale, then the errorCB callback is invoked.
   * 
   * @param callback the callback that is invoked after data is ready
   */
  public void getLocaleName(GlobalizationCallback<CLocale, GlobalizationError> callback);

  /**
   * @see #convertDateToString(Date, DateOptions, GlobalizationCallback)
   */
  public void convertDateToString(Date date,
      GlobalizationCallback<DateValue, GlobalizationError> callback);

  /**
   * Returns a date formatted as a string according to the client's user preferences and calendar
   * using the time zone of the client. It returns the formatted date string to the successCB
   * callback with a properties object as a parameter. If there is an error formatting the date,
   * then the errorCB callback is invoked.
   * 
   * The defaults are: formatLenght="short" and selector="date and time"
   * 
   */

  public void convertDateToString(Date date, DateOptions options,
      GlobalizationCallback<DateValue, GlobalizationError> callback);

}
