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
package de.kurka.phonegap.client.plugins.childbrowser;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author Christian KŸtbach
 * 
 */
public class ChildBrowserBrowserImpl implements ChildBrowser {

	private Browser browser;

	private EventBus handlerManager = new SimpleEventBus();

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.plugins.PhoneGapPlugin#initialize()
	 */
	@Override
	public void initialize() {
		// nothin to do here

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.plugins.childbrowser.ChildBrowser#showWebPage(java.lang.String)
	 */
	@Override
	public void showWebPage(String url) {
		removePanel();

		if (browser == null) {
			browser = new Browser();

		}

		if (!browser.isAttached()) {
			RootPanel.get().add(browser);
		}

		browser.navigate(url);


	}

	private class Browser extends Composite {
		private Frame frame;

		private Button button;
		private Panel container;

		/**
		 * 
		 */
		public Browser() {
			container = new FlowPanel();
			container.setSize("100%", "100%");
			container.getElement().getStyle().setPosition(Position.ABSOLUTE);
			container.getElement().getStyle().setZIndex(1000);

			FlowPanel frameStupidPanel = new FlowPanel();
			frameStupidPanel.getElement().getStyle().setPosition(Position.ABSOLUTE);
			frameStupidPanel.getElement().getStyle().setTop(0, Unit.PX);
			frameStupidPanel.getElement().getStyle().setLeft(0, Unit.PX);
			frameStupidPanel.getElement().getStyle().setRight(0, Unit.PX);
			frameStupidPanel.getElement().getStyle().setBottom(32, Unit.PX);

			frame = new Frame();

			frame.setSize("100%", "100%");

			frame.addDomHandler(new LoadHandler() {

				@Override
				public void onLoad(LoadEvent event) {
					onLocationChange(getUrlFromFrame(frame.getElement()));

				}
			}, LoadEvent.getType());

			frame.getElement().getStyle().setBackgroundColor("white");
			frame.getElement().getStyle().setOverflow(Overflow.AUTO);

			container.add(frame);

			FlowPanel flowPanel = new FlowPanel();
			flowPanel.getElement().getStyle().setPosition(Position.ABSOLUTE);
			
			flowPanel.getElement().getStyle().setLeft(0, Unit.PX);
			flowPanel.getElement().getStyle().setRight(0, Unit.PX);
			flowPanel.getElement().getStyle().setBottom(0, Unit.PX);
			flowPanel.getElement().getStyle().setHeight(32, Unit.PX);
			button = new Button("close");
			button.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					onClose();

				}
			});
			flowPanel.add(button);

			container.add(flowPanel);

			initWidget(container);
		}

		private void navigate(String url){
			frame.setUrl(url);
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.user.client.ui.Composite#onAttach()
		 */
		@Override
		protected void onAttach() {
			super.onAttach();
			container.getElement().getStyle().setPosition(Position.ABSOLUTE);
		}
	}



	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.plugins.childbrowser.ChildBrowser#close()
	 */
	@Override
	public void close() {
		removePanel();


	}

	private native String getUrlFromFrame(Element element)/*-{
		return element.contentWindow.location.href;
	}-*/;

	private void removePanel() {
		if (browser != null) {
			if (browser.isAttached()) {
				RootPanel.get().remove(browser);
			}

		}
	}

	@Override
	public HandlerRegistration addLocationChangeHandler(ChildBrowserLocationChangedHandler handler) {
		return handlerManager.addHandler(ChildBrowserLocationChangedEvent.getType(), handler);
	}

	@Override
	public HandlerRegistration addCloseHandler(ChildBrowserCloseHandler handler) {
		return handlerManager.addHandler(ChildBrowserCloseEvent.getType(), handler);
	}

	@Override
	public HandlerRegistration addOpenExternalHandler(ChildBrowserOpenExternalHandler handler) {
		return handlerManager.addHandler(ChildBrowserOpenExternalEvent.getType(), handler);
	}

	private void onClose() {
		handlerManager.fireEvent(new ChildBrowserCloseEvent());
	}



	private void onLocationChange(String url) {
		handlerManager.fireEvent(new ChildBrowserLocationChangedEvent(url));
	}

}
