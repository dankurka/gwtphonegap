package de.kurka.phonegap.client.compass.js;

import de.kurka.phonegap.client.compass.CompassWatcher;

public class CompassWatcherImpl implements CompassWatcher {
	private final String id;

	public CompassWatcherImpl(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
