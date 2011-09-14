package de.kurka.phonegap.client.media;

public interface MediaError {

	public static final int MEDIA_ERR_ABORTED = 1;
	public static final int MEDIA_ERR_NETWORK = 2;
	public static final int MEDIA_ERR_DECODE = 3;
	public static final int MEDIA_ERR_NONE_SUPPORTED = 4;

	public int getErrorCode();

	public String getErrorMessage();

}
