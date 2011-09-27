package com.googlecode.gwtphonegap.showcase.client.event;

import java.util.Date;

import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.event.BackButtonPressedEvent;
import com.googlecode.gwtphonegap.client.event.BackButtonPressedHandler;
import com.googlecode.gwtphonegap.client.event.OffLineEvent;
import com.googlecode.gwtphonegap.client.event.OffLineHandler;
import com.googlecode.gwtphonegap.client.event.OnlineEvent;
import com.googlecode.gwtphonegap.client.event.OnlineHandler;
import com.googlecode.gwtphonegap.client.event.PauseEvent;
import com.googlecode.gwtphonegap.client.event.PauseHandler;
import com.googlecode.gwtphonegap.client.event.ResumeEvent;
import com.googlecode.gwtphonegap.client.event.ResumeHandler;
import com.googlecode.gwtphonegap.client.event.SearchButtonPressedEvent;
import com.googlecode.gwtphonegap.client.event.SearchButtonPressedHandler;


public class EventPresenter {

	private final PhoneGap phoneGap;
	private final Display display;

	public EventPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;
		bind();
	}

	private void bind() {
		phoneGap.getEvent().getBackButton().addBackButtonPressedHandler(new BackButtonPressedHandler() {

			@Override
			public void onBackButtonPressed(BackButtonPressedEvent event) {
				String res = "Back Button Pressed: " + new Date();
				addText(res);
			}
		});

		phoneGap.getEvent().getOffLineHandler().addOfflineHandler(new OffLineHandler() {

			@Override
			public void onOffLine(OffLineEvent event) {
				String res = "Offline Event: " + new Date();
				addText(res);

			}
		});

		phoneGap.getEvent().getOnlineHandler().addOnlineHandler(new OnlineHandler() {

			@Override
			public void onOnlineEvent(OnlineEvent event) {
				String res = "Online Event: " + new Date();
				addText(res);

			}
		});

		phoneGap.getEvent().getPauseHandler().addPauseHandler(new PauseHandler() {

			@Override
			public void onPause(PauseEvent event) {
				String res = "Pause Event: " + new Date();
				addText(res);

			}
		});

		phoneGap.getEvent().getResumeHandler().addResumeHandler(new ResumeHandler() {

			@Override
			public void onResumeEvent(ResumeEvent event) {
				String res = "Resume Event: " + new Date();
				addText(res);

			}
		});

		phoneGap.getEvent().getSearchButton().addSearchButtonHandler(new SearchButtonPressedHandler() {

			@Override
			public void onSearchButtonPressed(SearchButtonPressedEvent event) {
				String res = "Search Button Pressed Event: " + new Date();
				addText(res);

			}
		});

	}

	private void addText(String text) {
		display.getHTML().setHTML(display.getHTML() + " " + text + "<br/>");
	}

	public interface Display {
		public Widget asWidget();

		public HasHTML getHTML();

	}

	public Widget getDisplay() {
		return display.asWidget();
	}
}
