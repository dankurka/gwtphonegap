package com.googlecode.gwtphonegap.client.event;

public interface EventMock {
	public void fireOfflineEvent();

	public void fireOnlineEvent();

	public void fireResumeEvent();

	public void firePauseEvent();

	public void fireBackEvent();

	public void fireSearchEvent();

	public void fireMenuEvent();
}
