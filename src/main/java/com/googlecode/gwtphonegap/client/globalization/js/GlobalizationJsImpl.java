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


import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsDate;

import com.googlecode.gwtphonegap.client.globalization.CLocale;
import com.googlecode.gwtphonegap.client.globalization.CNumberPattern;
import com.googlecode.gwtphonegap.client.globalization.DateNameOptions;
import com.googlecode.gwtphonegap.client.globalization.DateOptions;
import com.googlecode.gwtphonegap.client.globalization.DatePattern;
import com.googlecode.gwtphonegap.client.globalization.DateValue;
import com.googlecode.gwtphonegap.client.globalization.Globalization;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationCallback;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationError;
import com.googlecode.gwtphonegap.client.globalization.Language;
import com.googlecode.gwtphonegap.client.globalization.NumberOptions;
import com.googlecode.gwtphonegap.collection.client.JsLightArray;
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
    getDateNames(new DateNameOptions(DateNameOptions.TYPE_WIDE, DateNameOptions.ITEM_MONTHS),
        callback);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.googlecode.gwtphonegap.client.globalization.Globalization#getDateNames(com.googlecode.
   * gwtphonegap.client.globalization.js.DateNameOptions,
   * com.googlecode.gwtphonegap.client.globalization.GlobalizationCallback)
   */
  @Override
  public void getDateNames(DateNameOptions options,
      GlobalizationCallback<LightArray<String>, GlobalizationError> callback) {
    if (options == null)
      throw new IllegalArgumentException();

    getDateNames0(options.getType(), options.getItem(), callback);

  }

  private static void onGetDateNames(JsArrayString dateNames,
      GlobalizationCallback<LightArray<String>, GlobalizationError> callback) {

    callback.onSuccess(new JsLightArray<String>(dateNames));
  }

  private native void getDateNames0(String type, String item,
      GlobalizationCallback<LightArray<String>, GlobalizationError> callback) /*-{
		var win = function(names) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onGetDateNames(Lcom/google/gwt/core/client/JsArrayString;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(names, callback);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.getDateNames($entry(win), $entry(fail), {
			type : type,
			item : item
		});
  }-*/;

  @Override
  public void isDayLightSavingsTime(Date date,
      GlobalizationCallback<Boolean, GlobalizationError> callback) {
    JsDate jsDate = JsDate.create(date.getTime());
    isDayLightSavingsTime0(jsDate, callback);

  }

  private static void onIsDayLightSavingsTime(Boolean bool,
      GlobalizationCallback<Boolean, GlobalizationError> callback) {
    callback.onSuccess(bool);
  }

  private native void isDayLightSavingsTime0(JsDate jsDate,
      GlobalizationCallback<Boolean, GlobalizationError> callback) /*-{

		var win = function(is) {
			var bool = @java.lang.Boolean::valueOf(Z)(is);
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onIsDayLightSavingsTime(Ljava/lang/Boolean;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(bool, callback);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.isDayLightSavingsTime(jsDate, $entry(win),
				$entry(fail));
  }-*/;

  private static void onGetFirstDayOfWeek(Integer value,
      GlobalizationCallback<Integer, GlobalizationError> callback) {
    callback.onSuccess(value);
  }

  @Override
  public native void getFirstDayOfWeek(GlobalizationCallback<Integer, GlobalizationError> callback) /*-{
		var win = function(number) {
			var intValue = @java.lang.Integer::valueOf(I)(number);
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onGetFirstDayOfWeek(Ljava/lang/Integer;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(intValue, callback);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.getFirstDayOfWeek($entry(win),
				$entry(fail));

  }-*/;

  @Override
  public void numberToString(double number, NumberOptions options,
      GlobalizationCallback<String, GlobalizationError> callback) {
    if (options == null) {
      throw new IllegalArgumentException();
    }

    numberToString0(number, options.getType(), callback);

  }

  private static void onNumberToString(String formattedNumber,
      GlobalizationCallback<String, GlobalizationError> callback) {
    callback.onSuccess(formattedNumber);
  }

  private native void numberToString0(double number, String type,
      GlobalizationCallback<String, GlobalizationError> callback) /*-{

		var win = function(number) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onNumberToString(Ljava/lang/String;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(number.value, callback);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.numberToString(number, $entry(win),
				$entry(fail), {
					type : type
				});
  }-*/;

  @Override
  public void numberToString(double number,
      GlobalizationCallback<String, GlobalizationError> callback) {
    numberToString(number, new NumberOptions(NumberOptions.DECIMAL), callback);

  }

  @Override
  public void stringToNumber(String stringToFormat, NumberOptions options,
      GlobalizationCallback<Number, GlobalizationError> callback) {
    if (options == null) {
      throw new IllegalArgumentException();
    }

    stringToNumber0(stringToFormat, options.getType(), callback);

  }

  private static void onStringToNumber(Number number,
      GlobalizationCallback<Number, GlobalizationError> callback) {
    callback.onSuccess(number);
  }

  private native void stringToNumber0(String stringToFormat, String type,
      GlobalizationCallback<Number, GlobalizationError> callback) /*-{
		var win = function(number) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onStringToNumber(Ljava/lang/Number;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(number.value, callback);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.stringToNumber(stringToFormat,
				$entry(win), $entry(fail), {
					type : type
				});

  }-*/;

  @Override
  public void stringToNumber(String stringToFormat,
      GlobalizationCallback<Number, GlobalizationError> callback) {
    stringToNumber(stringToFormat, new NumberOptions(NumberOptions.DECIMAL), callback);

  }

  @Override
  public void getNumberPattern(NumberOptions options,
      GlobalizationCallback<CNumberPattern, GlobalizationError> callback) {
    if (options == null) {
      throw new IllegalArgumentException();
    }

    getNumberPattern(options.getType(), callback);

  }

  private static void onGetNumberPattern(CNumberPatternJsImpl numberPattern,
      GlobalizationCallback<CNumberPattern, GlobalizationError> callback) {
    callback.onSuccess(numberPattern);
  }

  private native void getNumberPattern(String type,
      GlobalizationCallback<CNumberPattern, GlobalizationError> callback) /*-{
		var win = function(pattern) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onGetNumberPattern(Lcom/googlecode/gwtphonegap/client/globalization/js/CNumberPatternJsImpl;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(pattern, callback);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.getNumberPattern($entry(win),
				$entry(fail), {
					type : type
				});

  }-*/;

  @Override
  public void getNumberPattern(GlobalizationCallback<CNumberPattern, GlobalizationError> callback) {
    getNumberPattern(new NumberOptions(NumberOptions.DECIMAL), callback);

  }

  @Override
  public native void getCurrencyPattern(String currencyCode,
      GlobalizationCallback<CNumberPattern, GlobalizationError> callback) /*-{

		var win = function(pattern) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onGetNumberPattern(Lcom/googlecode/gwtphonegap/client/globalization/js/CNumberPatternJsImpl;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(pattern, callback);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.getCurrencyPattern(currencyCode,
				$entry(win), $entry(fail));

  }-*/;

}
