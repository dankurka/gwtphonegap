package de.kurka.phonegap.client.compass;

public interface Compass {
	public void getCurrentHeading(CompassOptions options, CompassCallback callback);

	public CompassWatcher watchHeading(CompassOptions options, CompassCallback callback);

	public void clearWatcher(CompassWatcher watcher);
}
