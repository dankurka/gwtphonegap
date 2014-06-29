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


/**
 * Visual, audible, and tactile device notifications.
 * 
 * @author Daniel Kurka
 * 
 */
public class NotificationMobileImpl implements Notification {

	private static final AlertCallback emptyCallback = new AlertCallback() {

		@Override
		public void onOkButtonClicked() {

		}
	};
	private static final String[] defaultLabels = new String[] { "Ok", "Cancel" };

	public NotificationMobileImpl() {

	}

	@Override
	public native void beep(int count)/*-{
		$wnd.navigator.notification.beep(count);
	}-*/;

	@Override
	public native void vibrate(int milliseconds)/*-{
		$wnd.navigator.notification.vibrate(milliseconds);
	}-*/;
        
        @Override
        public void vibrateWithPattern(int[] pattern) {
            vibrateWithPattern(pattern, -1);
        }

        @Override
        public native void vibrateWithPattern(int[] pattern, int repeat) /*-{
		$wnd.navigator.notification.vibrateWithPattern(pattern,repeat);
	}-*/;

        @Override
        public native void cancelVibrate() /*-{
		$wnd.navigator.notification.cancelVibration();
	}-*/;
        
        @Override
        public void prompt(String message, PromptCallback callback) {
            prompt(message, callback, "Prompt");
        }

        @Override
        public void prompt(String message, PromptCallback callback, String title) {
            prompt(message, callback, title, "");
        }

        @Override
        public void prompt(String message, PromptCallback callback, String title, String defaultText) {
            prompt(message, callback, title, defaultText, defaultLabels);
        }

        @Override
        public void prompt(String message, PromptCallback callback, String title, String defaultText, String[] buttonLabels) {
            if (buttonLabels == null) {
                buttonLabels = defaultLabels;
            }
            prompt0(message, callback, title, buttonLabels, defaultText);
        }

        private native void prompt0(String message, PromptCallback callback, String title, String[] buttonLabels, String text)/*-{
         var cal = function(results){
         callback.@com.googlecode.gwtphonegap.client.notification.PromptCallback::onPrompt(Lcom/googlecode/gwtphonegap/client/notification/PromptResults;)(results);
         };
         $wnd.navigator.notification.prompt(message,$entry(cal),title,buttonLabels,text);
         }-*/;

        @Override
	public void alert(String message) {
		alert(message, emptyCallback);

	}

	@Override
	public void alert(String message, AlertCallback callback) {
		alert(message, callback, "Alert");

	}

	@Override
	public void alert(String message, AlertCallback callback, String title) {
		alert(message, callback, title, "Ok");

	}

	@Override
	public native void alert(String message, AlertCallback callback, String title, String buttonName) /*-{

		var cal = function() {
			callback.@com.googlecode.gwtphonegap.client.notification.AlertCallback::onOkButtonClicked()();
		};

		$wnd.navigator.notification.alert(message, $entry(cal), title,
				buttonName);

	}-*/;

	@Override
	public void confirm(String message, ConfirmCallback callback) {
		confirm(message, callback, "Confirm");

	}

	@Override
	public void confirm(String message, ConfirmCallback callback, String title) {

		confirm(message, callback, title, defaultLabels);

	}

	@Override
	public void confirm(String message, ConfirmCallback callback, String title, String[] buttonLabels) {
		if (buttonLabels == null)
			buttonLabels = defaultLabels;

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < buttonLabels.length; i++) {
			buffer.append(buttonLabels[i]);

			if (i != buttonLabels.length - 1) {
				buffer.append(",");
			}

		}

		String labels = buffer.toString();
		confirm0(message, callback, title, labels);

	}

	private native void confirm0(String message, ConfirmCallback callback, String title, String buttonLabels) /*-{

		var cal = function(button) {
			callback.@com.googlecode.gwtphonegap.client.notification.ConfirmCallback::onConfirm(I)(button);
		};

		$wnd.navigator.notification.confirm(message, $entry(cal), title,
				buttonLabels);
	}-*/;

}
