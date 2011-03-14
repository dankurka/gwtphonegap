package de.kurka.phonegap.client.camera;

public interface Camera {

	public abstract boolean isAvailable() ;

	/**
	 * Takes a photo and returns the image as a base64 encoded String.
	 * 
	 * opens the device's default camera application so that the user to take a photo. Once the photo is taken, the camera application closes and your application is restored.
	 * 
	 * The image is base64 encoded and returned as a String in the cameraSuccess function. Since the data is a String, you can do whatever you want with it, for example:
	 * 
	 * Render the image in an <img> tag (see example below)
	 * Save the data locally (LocalStorage, Lawnchair, etc)
	 * Post the data to a remote server
	 * 
	 * @param options
	 * @param callback
	 */
	public abstract void getPicture(PictureOptions options, PictureCallback callback);

}