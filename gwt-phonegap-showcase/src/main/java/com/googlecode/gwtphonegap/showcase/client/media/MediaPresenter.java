package com.googlecode.gwtphonegap.showcase.client.media;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.media.Media;
import com.googlecode.gwtphonegap.client.media.MediaCallback;
import com.googlecode.gwtphonegap.client.media.MediaError;
import com.googlecode.gwtphonegap.client.media.MediaPositionCallback;


public class MediaPresenter {
	private final Display display;
	private final PhoneGap phoneGap;

	public interface Display {

		public Widget asWidget();

		public HasHTML getPosition();

		public HasClickHandlers getPlayPauseButton();

		public HasText getPlayPauseButtonText();

	}

	public MediaPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		bind();
	}

	private boolean state = false;

	private void bind() {

		display.getPosition().setText("0 / 0");
		display.getPlayPauseButtonText().setText("play");

		final Media media = phoneGap.getMedia().create("http://audio.ibeat.org/content/p1rj1s/p1rj1s_-_rockGuitar.mp3", new MediaCallback() {

			@Override
			public void onSuccess() {

			}

			@Override
			public void onStatusChange() {

			}

			@Override
			public void onError(MediaError error) {
				Window.alert("error: " + error.getErrorCode() + " " + error.getErrorMessage());
			}
		});

		display.getPlayPauseButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				state = !state;
				if (state) {
					display.getPlayPauseButtonText().setText("pause");
					media.play();
				} else {
					display.getPlayPauseButtonText().setText("play");
					media.pause();
				}

			}
		});

		new Timer() {

			@Override
			public void run() {
				media.getCurrentPosition(new MediaPositionCallback() {

					@Override
					public void onSuccess(long position) {
						display.getPosition().setHTML(position + " / " + media.getDuration());

					}

					@Override
					public void onFailure(MediaError error) {

					}
				});

			}

		}.scheduleRepeating(200);

	}

	public Widget getDisplay() {
		return display.asWidget();
	}
}
