/*
 * Copyright 2012 Daniel Kurka
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
package com.googlecode.gwtphonegap.client.globalization.browser;

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
import com.googlecode.gwtphonegap.collection.shared.CollectionFactory;
import com.googlecode.gwtphonegap.collection.shared.LightArray;

import java.util.Date;

public class GlobalizationBrowserImpl implements Globalization {

  @Override
  public void getPreferredLanguage(GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback) {
    callback.onSuccess(new GlobalizationStringValue() {

      @Override
      public String getValue() {
        return "English";
      }
    });

  }

  @Override
  public void getLocaleName(GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback) {
    callback.onSuccess(new GlobalizationStringValue() {

      @Override
      public String getValue() {
        return "en_US";
      }
    });

  }

  @Override
  public void convertDateToString(Date date,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback) {
    convertDateToString(date, new DateOptions(DateOptions.LENGTH_SHORT,
        DateOptions.SELECTOR_DATE_AND_TIME), callback);

  }

  @Override
  public void convertDateToString(Date date, DateOptions options,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback) {

    callback.onFailure(new GlobalizationError() {

      @Override
      public String getMessage() {
        return "";
      }

      @Override
      public int getCode() {
        return GlobalizationError.FORMATTING_ERROR;
      }
    });

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
    callback.onFailure(new GlobalizationError() {

      @Override
      public String getMessage() {
        return "";
      }

      @Override
      public int getCode() {
        return GlobalizationError.FORMATTING_ERROR;
      }
    });

  }

  @Override
  public void getDatePattern(GlobalizationCallback<DatePattern, GlobalizationError> callback) {
    callback.onSuccess(new DatePattern() {

      @Override
      public String getPattern() {
        return "MM/dd/yyyy";
      }

        @Override
        public String getTimeZone() {
            return "";
        }

        @Override
        public int getUtc_offset() {
           Date d = new Date();
           return d.getTimezoneOffset();
        }

        @Override
        public int getDst_offset() {
            return 0;
        }
    });

  }

  @Override
  public void getDatePattern(DateOptions options,
      GlobalizationCallback<DatePattern, GlobalizationError> callback) {
    callback.onSuccess(new DatePattern() {

      @Override
      public String getPattern() {
        return "MM/dd/yyyy";
      }

        @Override
        public String getTimeZone() {
            return "";
        }

        @Override
        public int getUtc_offset() {
           Date d = new Date();
           return d.getTimezoneOffset();
        }

        @Override
        public int getDst_offset() {
            return 0;
        }
    });

  }

  @Override
  public void getDateNames(GlobalizationCallback<GlobalizationArrayValue, GlobalizationError> callback) {
    final LightArray<String> months = CollectionFactory.constructArray();
    months.push("Jan");
    months.push("Feb");
    months.push("Mar");
    months.push("Apr");
    months.push("May");
    months.push("Jun");
    months.push("Jul");
    months.push("Aug");
    months.push("Sep");
    months.push("Oct");
    months.push("Nov");
    months.push("Dec");

    callback.onSuccess(new GlobalizationArrayValue() {

         @Override
         public LightArray<String> getValue() {
             return months;
         }
     });

  }

  @Override
  public void getDateNames(DateNameOptions options,
      GlobalizationCallback<GlobalizationArrayValue, GlobalizationError> callback) {
    getDateNames(callback);

  }

  @Override
  public void isDayLightSavingsTime(Date date,
      GlobalizationCallback<DayLightSavings, GlobalizationError> callback) {
    callback.onSuccess(new DayLightSavings() {
        @Override
        public boolean getDst() {
            return false;
        }
    });

  }

  @Override
  public void getFirstDayOfWeek(GlobalizationCallback<GlobalizationIntValue, GlobalizationError> callback) {
    callback.onSuccess(new GlobalizationIntValue() {
        @Override
        public int getValue() {
            return 1;
        }
    });

  }

  @Override
  public void numberToString(final double number, NumberOptions options,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback) {
      callback.onSuccess(new GlobalizationStringValue() {
          @Override
          public String getValue() {
              return ""+number;
          }
      });
  }

  @Override
  public void numberToString(final double number,
      GlobalizationCallback<GlobalizationStringValue, GlobalizationError> callback) {
    callback.onSuccess(new GlobalizationStringValue() {
        @Override
        public String getValue() {
            return ""+number;
        }
    });

  }

  @Override
  public void stringToNumber(final String stringToFormat, NumberOptions options,
      GlobalizationCallback<GlobalizationDoubleValue, GlobalizationError> callback) {
    callback.onSuccess(new GlobalizationDoubleValue() {
        @Override
        public double getValue() {
            try{
            double curNumber = Double.parseDouble(stringToFormat);
            return curNumber;
            }catch (NumberFormatException e){
                return 0;
            }
        }
    });

  }

  @Override
  public void stringToNumber(final String stringToFormat,
      GlobalizationCallback<GlobalizationDoubleValue, GlobalizationError> callback) {
      callback.onSuccess(new GlobalizationDoubleValue() {
          @Override
          public double getValue() {
              try{
                  double curNumber = Double.parseDouble(stringToFormat);
                  return curNumber;
              }catch (Exception e){
                  return 0;
              }
          }
      });
  }

  @Override
  public void getNumberPattern(NumberOptions options,
      GlobalizationCallback<CNumberPattern, GlobalizationError> callback) {
    callback.onFailure(new GlobalizationError() {

      @Override
      public String getMessage() {
        return "";
      }

      @Override
      public int getCode() {
        return GlobalizationError.PATTERN_ERROR;
      }
    });

  }

  @Override
  public void getNumberPattern(GlobalizationCallback<CNumberPattern, GlobalizationError> callback) {
    callback.onFailure(new GlobalizationError() {

      @Override
      public String getMessage() {
        return "";
      }

      @Override
      public int getCode() {
        return GlobalizationError.PATTERN_ERROR;
      }
    });

  }

  @Override
  public void getCurrencyPattern(String currencyCode,
      GlobalizationCallback<CurrencyPattern, GlobalizationError> callback) {
    callback.onFailure(new GlobalizationError() {

      @Override
      public String getMessage() {
        return "";
      }

      @Override
      public int getCode() {
        return GlobalizationError.PATTERN_ERROR;
      }
    });

  }

}
