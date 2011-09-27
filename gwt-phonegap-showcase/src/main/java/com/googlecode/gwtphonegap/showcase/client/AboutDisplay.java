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
package com.googlecode.gwtphonegap.showcase.client;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.showcase.client.AboutPresenter.Display;


/**
 * @author Daniel Kurka
 *
 */
public class AboutDisplay implements Display {

	private DisclosurePanel main;

	/**
	 * 
	 */
	public AboutDisplay() {
		main = new DisclosurePanel("About");

		HTMLPanel htmlPanel = new HTMLPanel("<p>GWT-PhoneGap is a GWT wrapper for the PhoneGap Javascript API. It lets you write mobile applications in GWT</p> "
				+ "more infos see <a href='http://code.google.com/p/gwt-phonegap/'>http://code.google.com/p/gwt-phonegap/</a> <br />"
				+ "written by Daniel Kurka <a href='http://www.daniel-kurka.de'>www.daniel-kurka.de</a>");

		main.add(htmlPanel);

	}

	@Override
	public Widget asWidget() {
		return main;
	}

}
