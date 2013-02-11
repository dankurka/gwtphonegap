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

import com.googlecode.gwtphonegap.client.globalization.CLocale;
import com.googlecode.gwtphonegap.client.globalization.DateOptions;
import com.googlecode.gwtphonegap.client.globalization.DateValue;
import com.googlecode.gwtphonegap.client.globalization.Globalization;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationCallback;
import com.googlecode.gwtphonegap.client.globalization.GlobalizationError;
import com.googlecode.gwtphonegap.client.globalization.Language;

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

  @Override
  public native void getPreferedLanguage(
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

  @Override
  public void convertDateToString(Date date,
      GlobalizationCallback<DateValue, GlobalizationError> callback) {
    convertDateToString(date, new DateOptions(DateOptions.LENGTH_SHORT,
        DateOptions.SELECTOR_DATE_AND_TIME), callback);

  }

  @Override
  public void convertDateToString(Date date, DateOptions options,
      GlobalizationCallback<DateValue, GlobalizationError> callback) {
    // TODO Auto-generated method stub

  }

}
