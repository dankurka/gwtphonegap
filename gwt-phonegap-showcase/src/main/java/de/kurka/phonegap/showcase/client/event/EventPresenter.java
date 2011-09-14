package de.kurka.phonegap.showcase.client.event;

import java.util.Date;

import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.client.PhoneGap;
import de.kurka.phonegap.client.event.BackButtonPressedEvent;
import de.kurka.phonegap.client.event.BackButtonPressedHandler;
import de.kurka.phonegap.client.event.OffLineEvent;
import de.kurka.phonegap.client.event.OffLineHandler;
import de.kurka.phonegap.client.event.OnlineEvent;
import de.kurka.phonegap.client.event.OnlineHandler;
import de.kurka.phonegap.client.event.PauseEvent;
import de.kurka.phonegap.client.event.PauseHandler;
import de.kurka.phonegap.client.event.ResumeEvent;
import de.kurka.phonegap.client.event.ResumeHandler;
import de.kurka.phonegap.client.event.SearchButtonPressedEvent;
import de.kurka.phonegap.client.event.SearchButtonPressedHandler;

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
