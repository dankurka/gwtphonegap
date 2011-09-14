package de.kurka.phonegap.client.event;


public interface Event {

	public HasBackButtonPressedHandlers getBackButton();

	public HasMenuButtonPressedHandlers getMenuButton();

	public HasSearchButtonHandlers getSearchButton();

	public HasPauseHandlers getPauseHandler();

	public HasResumeHandlers getResumeHandler();

	public HasOnlineHandler getOnlineHandler();

	public HasOfflineHandler getOffLineHandler();

}
