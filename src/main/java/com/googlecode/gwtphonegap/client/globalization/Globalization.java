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
   * Get the BCP 47 language tag for the client's current language. Returns the BCP-47 compliant language identifier tag 
   * to the successCB callback with a properties object as a parameter. If there
   * is an error getting the language, then the errorCB callback is invoked.The error's expected code is
   * GlobalizationError.UNKNOWN_ERROR.
   * 
   * @param callback the callback that is invoked after data is ready
   */
  public void getPreferredLanguage(GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback);

  /**
   * Returns the BCP 47 compliant tag for the client's current locale setting. Returns the BCP 47 compliant locale identifier string
   * to the successCB callback with a properties object as a parameter. The locale tag will consist of a two-letter lower case 
   * language code, two-letter upper case country code, and (unspecified) variant code, separated by a hyphen.If there
   * is an error getting the locale, then the errorCB callback is invoked.The error's expected code is GlobalizationError.UNKNOWN_ERROR.
   * 
   * @param callback the callback that is invoked after data is ready
   */
  public void getLocaleName(GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback);

  /**
   * @see #convertDateToString(Date, DateOptions, GlobalizationCallback)
   * @param date
   * @param callback
   */
  public void convertDateToString(Date date,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback);

  /**
   * Returns a date formatted as a string according to the client's user preferences and calendar
   * using the time zone of the client. It returns the formatted date string to the successCB
   * callback with a properties object as a parameter. If there is an error formatting the date,
   * then the errorCB callback is invoked.
   * 
   * The defaults are: formatLength="short" and selector="date and time"
   * 
   * @param date
   * @param options
   * @param callback
   */

  public void convertDateToString(Date date, DateOptions options,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback);

  /**
   * @param dateString
   * @param callback
   * @see #convertStringToDate(String, DateOptions, GlobalizationCallback)
   */
  public void convertStringToDate(String dateString,
      GlobalizationCallback<Date, GlobalizationError> callback);

  /**
   * Parses a date formatted as a string according to the client's user preferences and calendar
   * using the time zone of the client and returns the corresponding date object. It returns the
   * date to the successCB callback with a properties object as a parameter. If there is an error
   * parsing the date string, then the errorCB callback is invoked.The error's expected code 
   * is GlobalizationError.PARSING_ERROR.
   * 
   * The defaults are: formatLength="short" and selector="date and time"
   * @param dateString
   * @param options
   * @param callback
   *  
   */
  public void convertStringToDate(String dateString, DateOptions options,
      GlobalizationCallback<Date, GlobalizationError> callback);

  public void getDatePattern(GlobalizationCallback<DatePattern, GlobalizationError> callback);

  /**
   * Returns a pattern string for formatting and parsing dates according to the client's user
   * preferences. It returns the pattern to the successCB callback with a properties object as a
   * parameter. If there is an error obtaining the pattern, the errorCallback executes with a 
   * GlobalizationError object as a parameter. The error's expected code is GlobalizationError.PATTERN_ERROR.
   * The default date options are: formatLength="short" and selector="date and time"
   * 
   * 
   * @param options
   * @param callback
   * 
   */
  public void getDatePattern(DateOptions options,
      GlobalizationCallback<DatePattern, GlobalizationError> callback);

  /**
     * @param callback
   * @see #getDateNames( GlobalizationCallback)
   */
  public void getDateNames(GlobalizationCallback<GlobalizationArrayValue, GlobalizationError> callback);

  /**
   * Returns an array of either the names of the months or days of the week according to the
   * client's user preferences and calendar. It returns the array of names to the successCB callback
   * with a properties object as a parameter. If there is an error obtaining the names, then the
   * errorCB callback is invoked.
   * 
   * The defaults are: type="wide" and item="months"
   * 
   * @param options
   * @param callback
   */
  public void getDateNames(DateNameOptions options,
      GlobalizationCallback<GlobalizationArrayValue, GlobalizationError> callback);

  /**
   * Returns whether daylight savings time is in effect for a given date using the client's time
   * zone and calendar. It returns whether or not daylight savings time is in effect to the
   * successCB callback with a properties object as a parameter. If there is an error reading the
   * date, then the errorCB callback is invoked. The error's expected code is GlobalizationError.UNKNOWN_ERROR.
   * 
   * @param date
   * @param callback
   * 
   * @error GlobalizationError.UNKNOWN_ERROR
   */
  public void isDayLightSavingsTime(Date date,
      GlobalizationCallback<DayLightSavings, GlobalizationError> callback);

  /**
   * Returns the first day of the week according to the client's user preferences and calendar. The
   * days of the week are numbered starting from 1 where 1 is considered to be Sunday. It returns
   * the day to the successCB callback with a properties object as a parameter. If there is an error
   * obtaining the pattern, then the errorCB callback is invoked.The error's expected code is
   * GlobalizationError.UNKNOWN_ERROR.
   * 
   * 
   * @param callback
   */
  public void getFirstDayOfWeek(GlobalizationCallback<GlobalizationIntValue, GlobalizationError> callback);

  /**
   * Returns a number formatted as a string according to the client's user preferences. It returns
   * the formatted number string to the successCB callback with a properties object as a parameter.
   * If there is an error formatting the number, then the errorCB callback is invoked.The error's 
   * expected code is GlobalizationError.FORMATTING_ERROR.
   * 
   * The options parameter is optional, and its default values are: "decimal"
   * 
   * @param number
   * @param options
   * @param callback
   * 
   */
  public void numberToString(double number, NumberOptions options,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback);

  /**
     * @param number
     * @param callback
   * @see #numberToString(double, NumberOptions, GlobalizationCallback)
   */
  public void numberToString(double number,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback);

  /**
   * Parses a number formatted as a string according to the client's user preferences and returns
   * the corresponding number. It returns the number to the successCB callback with a properties
   * object as a parameter. If there is an error parsing the number string, then the errorCB
   * callback is invoked. The error's expected code is GlobalizationError.PARSING_ERROR.
   * 
   * The defaults are: type="decimal"
   * 
   * 
   * @param stringToFormat
   * @param options
   * @param callback
   */
  public void stringToNumber(String stringToFormat, NumberOptions options,
      GlobalizationCallback<GlobalizationDoubleValue, GlobalizationError> callback);

  /**
   * @param stringToFormat
   * @param callback
   * @see #stringToNumber(String, NumberOptions, GlobalizationCallback)
   */
  public void stringToNumber(String stringToFormat,
      GlobalizationCallback<GlobalizationDoubleValue, GlobalizationError> callback);

  /**
   * Returns a pattern string for formatting and parsing numbers according to the client's user
   * preferences. It returns the pattern to the successCB callback with a properties object as a
   * parameter. If there is an error obtaining the pattern, then the errorCB callback is invoked.
   * The error's expected code is GlobalizationError.PATTERN_ERROR.
   * The options parameter is optional, and default values are:decimal
   * 
   * 
   * @param options
   * @param callback
   * 
   */
  public void getNumberPattern(NumberOptions options,
      GlobalizationCallback<CNumberPattern, GlobalizationError> callback);

  /**
   * @see #getNumberPattern(NumberOptions, GlobalizationCallback)
   * @param callback
   */
  public void getNumberPattern(GlobalizationCallback<CNumberPattern, GlobalizationError> callback);

  /**
   * Returns a pattern string for formatting and parsing currency values according to the client's
   * user preferences and ISO 4217 currency code. It returns the pattern to the successCB callback
   * with a properties object as a parameter. If there is an error obtaining the pattern, then the
   * errorCB callback is invoked.
   * 
   * @param currencyCode
   * @param callback
   * 
   */
  public void getCurrencyPattern(String currencyCode,
      GlobalizationCallback<CurrencyPattern, GlobalizationError> callback);
}
