package com.googlecode.gwtphonegap.showcase.client.plugin;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.plugins.childbrowser.ChildBrowser;

public class ChildBrowserPresenter {
	public interface Display {
		public Widget asWidget();

		public HasClickHandlers getShowButton();

	}

	private Display display;
	private PhoneGap phoneGap;
	private ChildBrowser childBrowser;

	public ChildBrowserPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		childBrowser = (ChildBrowser) this.phoneGap.getPluginById("childBrowser");

		bind();
	}

	private void bind() {
		display.getShowButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				childBrowser.showWebPage("http://www.google.de");

			}
		});
	}

	public Widget getDisplay() {
		return display.asWidget();
	}
}
