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
package com.googlecode.gwtphonegap.client.globalization.js;


import com.google.gwt.core.client.JsDate;

import com.googlecode.gwtphonegap.client.globalization.CLocale;
import com.googlecode.gwtphonegap.client.globalization.CNumberPattern;
import com.googlecode.gwtphonegap.client.globalization.DateOptions;
import com.googlecode.gwtphonegap.client.globalization.DatePattern;
import com.googlecode.gwtphonegap.client.globalization.DateValue;
import com.googlecode.gwtphonegap.client.globalization.Globalization;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationCallback;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationError;
import com.googlecode.gwtphonegap.client.globalization.Language;
import com.googlecode.gwtphonegap.client.globalization.NumberOptions;
import com.googlecode.gwtphonegap.collection.shared.LightArray;

import java.util.Date;

public class GlobalizationJsImpl implements Globalization {

  private static void getPreferredLanguageSuccess(
      GlobalizationCallback<Language, GlobalizationError> callback, LanguageJsImpl language) {
    callback.onSuccess(language);
  }

  private static void getLocalNameSuccess(
      GlobalizationCallback<CLocale, GlobalizationError> callback, CLocaleJsImpl language) {
    callback.onSuccess(language);
  }

  private static void failureCallback(GlobalizationCallback<?, GlobalizationError> callback,
      GlobalizationErrorJsImpl error) {
    callback.onFailure(error);
  }


  /*
   * (non-Javadoc)
   * 
   * @see
   * com.googlecode.gwtphonegap.client.globalization.Globalization#getPreferredLanguage(com.googlecode
   * .gwtphonegap.client.globalization.GlobalizationCallback)
   */

  @Override
  public native void getPreferredLanguage(
      GlobalizationCallback<Language, GlobalizationError> callback)/*-{

		var win = function(language) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::getPreferredLanguageSuccess(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/LanguageJsImpl;)(callback, language);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$doc.navigator.globalization.getPreferredLanguage($entry(win),
				$entry(fail));
  }-*/;


  /*
   * (non-Javadoc)
   * 
   * @see
   * com.googlecode.gwtphonegap.client.globalization.Globalization#getLocaleName(com.googlecode.
   * gwtphonegap.client.globalization.GlobalizationCallback)
   */
  @Override
  public native void getLocaleName(GlobalizationCallback<CLocale, GlobalizationError> callback) /*-{
		var win = function(locale) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::getLocalNameSuccess(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/CLocaleJsImpl;)(callback, locale);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$doc.navigator.globalization.getLocaleName($entry(win), $entry(fail));

  }-*/;


  /*
   * (non-Javadoc)
   * 
   * @see
   * com.googlecode.gwtphonegap.client.globalization.Globalization#convertDateToString(java.util
   * .Date, com.googlecode.gwtphonegap.client.globalization.GlobalizationCallback)
   */

  @Override
  public void convertDateToString(Date date,
      GlobalizationCallback<DateValue, GlobalizationError> callback) {
    convertDateToString(date, new DateOptions(DateOptions.LENGTH_SHORT,
        DateOptions.SELECTOR_DATE_AND_TIME), callback);

  }


  /*
   * (non-Javadoc)
   * 
   * @see
   * com.googlecode.gwtphonegap.client.globalization.Globalization#convertDateToString(java.util
   * .Date, com.googlecode.gwtphonegap.client.globalization.DateOptions,
   * com.googlecode.gwtphonegap.client.globalization.GlobalizationCallback)
   */
  @Override
  public void convertDateToString(Date date, DateOptions options,
      GlobalizationCallback<DateValue, GlobalizationError> callback) {
    if(options == null){
      throw new IllegalArgumentException("options can not be null");
    }
    JsDate jsDate = JsDate.create(date.getTime());
    
    convertDateToString0(jsDate, options.getFormatLength(), options.getSelector(), callback);
  }

  private native void convertDateToString0 (JsDate date, String formatLength, String selector,
      GlobalizationCallback<DateValue, GlobalizationError> callback)/*-{

		var win = function(dateValue) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onConvertDateToStringSuccess(Lcom/googlecode/gwtphonegap/client/globalization/js/DateValueJsImpl;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(dateValue, callback);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.dateToString(date, $entry(win),
				$entry(fail), {
					formatLength : formatLength,
					selector : selector
				});
  }-*/;

  private static void onConvertDateToStringSuccess(DateValueJsImpl dateValue,
      GlobalizationCallback<DateValue, GlobalizationError> callback) {
    callback.onSuccess(dateValue);
  }

  @Override
  public void convertStringToDate(String dateString,
      GlobalizationCallback<Date, GlobalizationError> callback) {
    convertStringToDate(dateString, new DateOptions(DateOptions.LENGTH_SHORT,
        DateOptions.SELECTOR_DATE_AND_TIME), callback);

  }

  @Override
  public void convertStringToDate(String dateString, DateOptions options,
      GlobalizationCallback<Date, GlobalizationError> callback) {
    if (options == null) {
      throw new IllegalArgumentException("options can not be null");
    }
    
    convertStringToDate0(dateString, options.getFormatLength(), options.getSelector(), callback);

  }



  private static void onConvertStringToDateSuccess(JsDate date,
      GlobalizationCallback<Date, GlobalizationError> callback) {
    long time = Math.round(date.getTime());
    Date d = new Date(time);
    callback.onSuccess(d);
  }

  private native void convertStringToDate0(String dateString, String formatLength, String selector,
      GlobalizationCallback<Date, GlobalizationError> callback) /*-{

		var win = function(jsDate) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onConvertStringToDateSuccess(Lcom/google/gwt/core/client/JsDate;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(jsDate, callback);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.stringToDate(date, $entry(win),
				$entry(fail), {
					formatLength : formatLength,
					selector : selector
				});
  }-*/;

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.googlecode.gwtphonegap.client.globalization.Globalization#getDatePattern(com.googlecode
   * .gwtphonegap.client.globalization.GlobalizationCallback)
   */
  @Override
  public void getDatePattern(GlobalizationCallback<DatePattern, GlobalizationError> callback) {
    getDatePattern(new DateOptions(DateOptions.LENGTH_SHORT, DateOptions.SELECTOR_DATE_AND_TIME),
        callback);

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.googlecode.gwtphonegap.client.globalization.Globalization#getDatePattern(com.googlecode
   * .gwtphonegap.client.globalization.DateOptions,
   * com.googlecode.gwtphonegap.client.globalization.GlobalizationCallback)
   */
  @Override
  public void getDatePattern(DateOptions options,
      GlobalizationCallback<DatePattern, GlobalizationError> callback) {
    if (options == null)
      throw new IllegalArgumentException();
    getDatePattern0(options.getFormatLength(), options.getSelector(), callback);
  }

  private static void onGetDatePatternSuccess(DatePatternJsImpl datePattern,
      GlobalizationCallback<DatePattern, ?> callback) {
    callback.onSuccess(datePattern);
  }

  private native void getDatePattern0(String formatLength, String selector,
      GlobalizationCallback<DatePattern, GlobalizationError> callback) /*-{

		var win = function(date) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onGetDatePatternSuccess(Lcom/googlecode/gwtphonegap/client/globalization/js/DatePatternJsImpl;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(date, callback);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.getDatePattern($entry(win), $entry(fail),
				{
					formatLength : formatLength,
					selector : selector
				});

  }-*/;

  /*
   * (non-Javadoc)
   * 
   * @see com.googlecode.gwtphonegap.client.globalization.Globalization#getDateNames(com.googlecode.
   * gwtphonegap.client.globalization.GlobalizationCallback)
   */
  @Override
  public void getDateNames(GlobalizationCallback<LightArray<String>, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public void getDateNames(DateOptions options,
      GlobalizationCallback<LightArray<String>, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public void isDayLightSavingsTime(Date date,
      GlobalizationCallback<Boolean, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public void getFirstDayOfWeek(GlobalizationCallback<Integer, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public void numberToString(double number, NumberOptions options,
      GlobalizationCallback<String, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public void numberToString(double number,
      GlobalizationCallback<String, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public void numberToString(int number, GlobalizationCallback<String, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public void numberToString(int number, NumberOptions options,
      GlobalizationCallback<String, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public void stringToNumber(String stringToFormat, NumberOptions options,
      GlobalizationCallback<Number, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public void stringToNumber(String stringToFormat,
      GlobalizationCallback<Number, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public void getNumberPattern(NumberOptions options,
      GlobalizationCallback<CNumberPattern, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public void getNumberPattern(GlobalizationCallback<CNumberPattern, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public void getCurrencyPattern(String currencyCode,
      GlobalizationCallback<CNumberPattern, GlobalizationError> callback) {

    // TODO Auto-generated method stub

  }

}
