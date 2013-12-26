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

import com.googlecode.gwtphonegap.collection.shared.LightArray;

import java.util.Date;

public interface Globalization {
  /**
   * Returns the string identifier for the client's current language. It returns the language
   * identifier string to the successCB callback with a properties object as a parameter. If there
   * is an error getting the language, then the errorCB callback is invoked.
   * 
   * @param callback the callback that is invoked after data is ready
   */
  public void getPreferredLanguage(GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback);

  /**
   * Returns the string identifier for the client's current locale setting. It returns the locale
   * identifier string to the successCB callback with a properties object as a parameter. If there
   * is an error getting the locale, then the errorCB callback is invoked.
   * 
   * @param callback the callback that is invoked after data is ready
   */
  public void getLocaleName(GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback);

  /**
   * @see #convertDateToString(Date, DateOptions, GlobalizationCallback)
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
   */

  public void convertDateToString(Date date, DateOptions options,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback);

  /**
   * @see #convertStringToDate(String, DateOptions, GlobalizationCallback)
   */
  public void convertStringToDate(String dateString,
      GlobalizationCallback<Date, GlobalizationError> callback);

  /**
   * Parses a date formatted as a string according to the client's user preferences and calendar
   * using the time zone of the client and returns the corresponding date object. It returns the
   * date to the successCB callback with a properties object as a parameter. If there is an error
   * parsing the date string, then the errorCB callback is invoked.
   * 
   * The defaults are: formatLength="short" and selector="date and time"
   * 
   * 
   * @error GlobalizationError.PARSING_ERROR
   * 
   */

  /**
   * @see #getDatePattern(DateOptions, GlobalizationCallback)
   */
  public void convertStringToDate(String dateString, DateOptions options,
      GlobalizationCallback<Date, GlobalizationError> callback);

  public void getDatePattern(GlobalizationCallback<DatePattern, GlobalizationError> callback);

  /**
   * Returns a pattern string for formatting and parsing dates according to the client's user
   * preferences. It returns the pattern to the successCB callback with a properties object as a
   * parameter. If there is an error obtaining the pattern, then the errorCB callback is invoked.
   * 
   * The defaults are: formatLength="short" and selector="date and time"
   * 
   * 
   * @return Object.pattern {String}: The date and time pattern for formatting and parsing dates.
   *         The patterns follow Unicode Technical Standard #35
   *         http://unicode.org/reports/tr35/tr35-4.html Object.timezone {String}: The abbreviated
   *         name of the time zone on the client Object.utc_offset {Number}: The current difference
   *         in seconds between the client's time zone and coordinated universal time.
   *         Object.dst_offset {Number}: The current daylight saving time offset in seconds between
   *         the client's non-daylight saving's time zone and the client's daylight saving's time
   *         zone.
   * 
   * @error GlobalizationError.PATTERN_ERROR
   */
  public void getDatePattern(DateOptions options,
      GlobalizationCallback<DatePattern, GlobalizationError> callback);

  /**
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
   * @return Object.value {Array{String}}: The array of names starting from either the first month
   *         in the year or the first day of the week.
   * @error GlobalizationError.UNKNOWN_ERROR
   */
  public void getDateNames(DateNameOptions options,
      GlobalizationCallback<GlobalizationArrayValue, GlobalizationError> callback);

  /**
   * Returns whether daylight savings time is in effect for a given date using the client's time
   * zone and calendar. It returns whether or not daylight savings time is in effect to the
   * successCB callback with a properties object as a parameter. If there is an error reading the
   * date, then the errorCB callback is invoked.
   * 
   * 
   * @return The value "true" indicates that daylight savings time is in effect for the given date
   *         and "false" indicate that it is not.
   * 
   * @error GlobalizationError.UNKNOWN_ERROR
   */
  public void isDayLightSavingsTime(Date date,
      GlobalizationCallback<DayLightSavings, GlobalizationError> callback);

  /**
   * Returns the first day of the week according to the client's user preferences and calendar. The
   * days of the week are numbered starting from 1 where 1 is considered to be Sunday. It returns
   * the day to the successCB callback with a properties object as a parameter. If there is an error
   * obtaining the pattern, then the errorCB callback is invoked.
   * 
   * 
   * @return The number of the first day of the week.
   */
  public void getFirstDayOfWeek(GlobalizationCallback<GlobalizationIntValue, GlobalizationError> callback);

  /**
   * Returns a number formatted as a string according to the client's user preferences. It returns
   * the formatted number string to the successCB callback with a properties object as a parameter.
   * If there is an error formatting the number, then the errorCB callback is invoked.
   * 
   * The defaults are: type="decimal"
   * 
   * @param {Number} number
   * @param {Function} successCB
   * @param {Function} errorCB
   * @param {Object} options {optional} type {String}: 'decimal', "percent", or 'currency'
   * 
   * @return Object.value {String}: The formatted number string.
   * 
   * @error GlobalizationError.FORMATTING_ERROR
   * 
   */
  public void numberToString(double number, NumberOptions options,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback);

  /**
   * @see #numberToString(double, NumberOptions, GlobalizationCallback)
   */
  public void numberToString(double number,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback);

  /**
   * Parses a number formatted as a string according to the client's user preferences and returns
   * the corresponding number. It returns the number to the successCB callback with a properties
   * object as a parameter. If there is an error parsing the number string, then the errorCB
   * callback is invoked.
   * 
   * The defaults are: type="decimal"
   * 
   * 
   * @return Object.value {Number}: The parsed number.
   * 
   * @error GlobalizationError.PARSING_ERROR
   * 
   *        Example globalization.stringToNumber('1234.56', function (number) {alert('Number:' +
   *        number.value + '\n');}, function () { alert('Error parsing number');});
   */
  public void stringToNumber(String stringToFormat, NumberOptions options,
      GlobalizationCallback<GlobalizationDoubleValue, GlobalizationError> callback);

  /**
   * @see #stringToNumber(String, NumberOptions, GlobalizationCallback)
   */
  public void stringToNumber(String stringToFormat,
      GlobalizationCallback<GlobalizationDoubleValue, GlobalizationError> callback);

  /**
   * Returns a pattern string for formatting and parsing numbers according to the client's user
   * preferences. It returns the pattern to the successCB callback with a properties object as a
   * parameter. If there is an error obtaining the pattern, then the errorCB callback is invoked.
   * 
   * The defaults are: type="decimal"
   * 
   * 
   * @return Object.pattern {String}: The number pattern for formatting and parsing numbers. The
   *         patterns follow Unicode Technical Standard #35.
   *         http://unicode.org/reports/tr35/tr35-4.html
   * 
   *         Object.symbol {String}: The symbol to be used when formatting and parsing e.g., percent
   *         or currency symbol. Object.fraction {Number}: The number of fractional digits to use
   *         when parsing and formatting numbers. Object.rounding {Number}: The rounding increment
   *         to use when parsing and formatting. Object.positive {String}: The symbol to use for
   *         positive numbers when parsing and formatting. Object.negative: {String}: The symbol to
   *         use for negative numbers when parsing and formatting. Object.decimal: {String}: The
   *         decimal symbol to use for parsing and formatting. Object.grouping: {String}: The
   *         grouping symbol to use for parsing and formatting.
   * 
   * @error GlobalizationError.PATTERN_ERROR
   * 
   */
  public void getNumberPattern(NumberOptions options,
      GlobalizationCallback<CNumberPattern, GlobalizationError> callback);

  /**
   * @see #getNumberPattern(NumberOptions, GlobalizationCallback)
   */
  public void getNumberPattern(GlobalizationCallback<CNumberPattern, GlobalizationError> callback);

  /**
   * Returns a pattern string for formatting and parsing currency values according to the client's
   * user preferences and ISO 4217 currency code. It returns the pattern to the successCB callback
   * with a properties object as a parameter. If there is an error obtaining the pattern, then the
   * errorCB callback is invoked.
   * 
   * @return Object.pattern {String}: The currency pattern for formatting and parsing currency
   *         values. The patterns follow Unicode Technical Standard #35
   *         http://unicode.org/reports/tr35/tr35-4.html Object.code {String}: The ISO 4217 currency
   *         code for the pattern. Object.fraction {Number}: The number of fractional digits to use
   *         when parsing and formatting currency. Object.rounding {Number}: The rounding increment
   *         to use when parsing and formatting. Object.decimal: {String}: The decimal symbol to use
   *         for parsing and formatting. Object.grouping: {String}: The grouping symbol to use for
   *         parsing and formatting.
   * 
   * @error GlobalizationError.FORMATTING_ERROR
   * 
   */
  public void getCurrencyPattern(String currencyCode,
      GlobalizationCallback<CurrencyPattern, GlobalizationError> callback);
}
