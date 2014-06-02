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

import com.googlecode.gwtphonegap.client.globalization.CNumberPattern;
import com.googlecode.gwtphonegap.client.globalization.CurrencyPattern;
import com.googlecode.gwtphonegap.client.globalization.DateNameOptions;
import com.googlecode.gwtphonegap.client.globalization.DateOptions;
import com.googlecode.gwtphonegap.client.globalization.DatePattern;
import com.googlecode.gwtphonegap.client.globalization.DayLightSavings;
import com.googlecode.gwtphonegap.client.globalization.Globalization;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationArrayValue;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationCallback;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationDoubleValue;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationError;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationIntValue;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationStringValue;
import com.googlecode.gwtphonegap.client.globalization.NumberOptions;

import java.util.Date;

public class GlobalizationJsImpl implements Globalization {


  /*
   * (non-Javadoc)
   *
   * @see
   * com.googlecode.gwtphonegap.client.globalization.Globalization#getPreferredLanguage(com.googlecode
   * .gwtphonegap.client.globalization.GlobalizationCallback)
   */

  @Override
  public native void getPreferredLanguage(
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback)/*-{

		var win = function(language) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::getGlobalizationStringSuccess(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationStringValueJsImpl;)(callback,language);
                };

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

                $wnd.navigator.globalization.getPreferredLanguage($entry(win),
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
  public native void getLocaleName(GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback) /*-{
		var win = function(locale) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::getGlobalizationStringSuccess(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationStringValueJsImpl;)(callback,locale);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

                $wnd.navigator.globalization.getLocaleName($entry(win), $entry(fail));

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
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback) {
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
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback) {
    if(options == null){
      throw new IllegalArgumentException("options can not be null");
    }
    JsDate jsDate = JsDate.create(date.getTime());

    convertDateToString0(jsDate, options.getFormatLength(), options.getSelector(), callback);
  }

  private native void convertDateToString0 (JsDate date, String formatLength, String selector,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback)/*-{

		var win = function(dateValue) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::getGlobalizationStringSuccess(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationStringValueJsImpl;)(callback,dateValue);
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

  private static void onConvertStringToDateSuccess(DateFieldsJsImpl jsDate,
      GlobalizationCallback<Date, GlobalizationError> callback) {
      @SuppressWarnings("deprecation")
      Date d = new Date(jsDate.getYear(), jsDate.getMonth(),jsDate.getDay(), jsDate.getHour(),jsDate.getMinute(), jsDate.getSecond());
      //TODO: Ideally the below lines should be uncommented to add the ms to
      //give the exact output. But these lines are throwing some errors.
      callback.onSuccess(d);
  }

  private native void convertStringToDate0(String dateString, String formatLength, String selector,
      GlobalizationCallback<Date, GlobalizationError> callback) /*-{

		var win = function(jsDate) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onConvertStringToDateSuccess(Lcom/googlecode/gwtphonegap/client/globalization/js/DateFieldsJsImpl;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(jsDate, callback);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.stringToDate(dateString, $entry(win),
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
  public void getDateNames(GlobalizationCallback<GlobalizationArrayValue, GlobalizationError> callback) {
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
      GlobalizationCallback<GlobalizationArrayValue, GlobalizationError> callback) {
    if (options == null)
      throw new IllegalArgumentException();

    getDateNames0(options.getType(), options.getItem(), callback);

  }

  private static void onGetDateNames(GlobalizationArrayValueJsImpl arrayJSImpl,
      GlobalizationCallback<GlobalizationArrayValue, GlobalizationError> callback) {
    callback.onSuccess(arrayJSImpl);
  }

  private native void getDateNames0(String type, String item,
      GlobalizationCallback<GlobalizationArrayValue, GlobalizationError> callback) /*-{
		var win = function(names) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onGetDateNames(Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationArrayValueJsImpl;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(names,callback);
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
      GlobalizationCallback<DayLightSavings, GlobalizationError> callback) {
    JsDate jsDate = JsDate.create(date.getTime());
    isDayLightSavingsTime0(jsDate, callback);

  }

  private static void onIsDayLightSavingsTime(DayLightSavingsJsImpl dayLightSavings,
      GlobalizationCallback<DayLightSavings, GlobalizationError> callback) {
    callback.onSuccess(dayLightSavings);
  }

  private native void isDayLightSavingsTime0(JsDate jsDate,
      GlobalizationCallback<DayLightSavings, GlobalizationError> callback) /*-{

		var win = function(is) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onIsDayLightSavingsTime(Lcom/googlecode/gwtphonegap/client/globalization/js/DayLightSavingsJsImpl;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(is,callback);
                };

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.isDayLightSavingsTime(jsDate, $entry(win),
				$entry(fail));
  }-*/;


  @Override
  public native void getFirstDayOfWeek(GlobalizationCallback<GlobalizationIntValue, GlobalizationError> callback) /*-{
		var win = function(success) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::getGlobalizationIntSuccess(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationIntValueJsImpl;)(callback,success);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.getFirstDayOfWeek($entry(win),
				$entry(fail));

  }-*/;

  @Override
  public void numberToString(double number, NumberOptions options,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback) {
    if (options == null) {
      throw new IllegalArgumentException();
    }

    numberToString0(number, options.getType(), callback);

  }


  private native void numberToString0(double number, String type,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback) /*-{

		var win = function(success) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::getGlobalizationStringSuccess(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationStringValueJsImpl;)(callback,success);
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
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback) {
    numberToString(number, new NumberOptions(NumberOptions.DECIMAL), callback);

  }

  @Override
  public void stringToNumber(String stringToFormat, NumberOptions options,
      GlobalizationCallback<GlobalizationDoubleValue, GlobalizationError> callback) {
    if (options == null) {
      throw new IllegalArgumentException();
    }

    stringToNumber0(stringToFormat, options.getType(), callback);

  }

  private native void stringToNumber0(String stringToFormat, String type,
      GlobalizationCallback<GlobalizationDoubleValue, GlobalizationError> callback) /*-{
		var win = function(success) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::getGlobalizationDoubleSuccess(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationDoubleValueJsImpl;)(callback,success);

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
      GlobalizationCallback<GlobalizationDoubleValue, GlobalizationError> callback) {
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
      GlobalizationCallback<CurrencyPattern, GlobalizationError> callback) /*-{

		var win = function(pattern) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::onGetCurrencyPattern(Lcom/googlecode/gwtphonegap/client/globalization/js/CurrencyPatternJsImpl;Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;)(pattern,callback);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.globalization.js.GlobalizationJsImpl::failureCallback(Lcom/googlecode/gwtphonegap/client/globalization/GlobalizationCallback;Lcom/googlecode/gwtphonegap/client/globalization/js/GlobalizationErrorJsImpl;)(callback, error);
		};

		$wnd.navigator.globalization.getCurrencyPattern(currencyCode,
				$entry(win), $entry(fail));

  }-*/;
    private static void onGetCurrencyPattern(CurrencyPatternJsImpl currencyPattern,
                                           GlobalizationCallback<CurrencyPattern, GlobalizationError> callback) {
        callback.onSuccess(currencyPattern);
    }


private static void getGlobalizationStringSuccess(
        GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback, GlobalizationStringValueJsImpl locale) {
    callback.onSuccess(locale);
}
private static void getGlobalizationIntSuccess(
        GlobalizationCallback<GlobalizationIntValue, GlobalizationError> callback, GlobalizationIntValueJsImpl locale) {
    callback.onSuccess(locale);
}
private static void getGlobalizationDoubleSuccess(
        GlobalizationCallback<GlobalizationDoubleValue, GlobalizationError> callback, GlobalizationDoubleValueJsImpl locale) {
    callback.onSuccess(locale);
}
private static void failureCallback(GlobalizationCallback<?, GlobalizationError> callback,
    GlobalizationErrorJsImpl error) {
  callback.onFailure(error);
}


}
