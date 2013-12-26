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
package com.googlecode.gwtphonegap.client.notification;

import com.google.gwt.user.client.Window;

public class NotificationBrowserImpl implements Notification {

	@Override
	public void alert(String message) {
		Window.alert(message);

	}

	@Override
	public void beep(int count) {

	}

	@Override
	public void vibrate(int milliseconds) {

	}

    @Override
    public void prompt(String message, PromptCallback callback) {
        prompt(message,callback);
    }

    @Override
    public void prompt(String message, PromptCallback callback, String title) {
        prompt(message,callback);
    }

    @Override
    public void prompt(String message, PromptCallback callback, String title, String defaultText) {
        prompt(message,callback);
    }

    @Override
    public void prompt(String message, PromptCallback callback, String title, String defaultText, String[] buttonLabels) {
        String enteredValue =  Window.prompt(message, "OK");
        PromptResults results;
      if(enteredValue == null)
           results = new PromptResultsBrowserImpl(1,null);
        else
          results = new PromptResultsBrowserImpl(0,enteredValue);
        callback.onPrompt(results);
    }


    @Override
	public void alert(String message, AlertCallback callback) {
		Window.alert(message);
		callback.onOkButtonClicked();

	}

	@Override
	public void alert(String message, AlertCallback callback, String title) {
		alert(message, callback);

	}

	@Override
	public void alert(String message, AlertCallback callback, String title, String buttonName) {
		alert(message, callback);

	}

	@Override
	public void confirm(String message, ConfirmCallback callback) {
		boolean confirm = Window.confirm(message);
		//TODO is this correct?
		//take a look into at phonegap docs
		callback.onConfirm(confirm ? 0 : 1);

	}

	@Override
	public void confirm(String message, ConfirmCallback callback, String title) {
		confirm(message, callback);

	}

	@Override
	public void confirm(String message, ConfirmCallback callback, String title, String[] buttonLabels) {
		confirm(message, callback);

	}

}
