/*
 * Copyright 2010 Daniel Kurka
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.camera;

public class PictureOptions {

    /**
     * Return image as base64-encoded string
     */
    public static final int DESTINATION_TYPE_DATA_URL = 0;
    /**
     * Return image file URI
     */
    public static final int DESTINATION_TYPE_FILE_URI = 1;
    /**
     * Return image native URI (e.g., assets-library:// on iOS or content:// on Android)
     */
    public static final int DESTINATION_TYPE_NATIVE_URI = 2;
    /**
     * Use the front-facing camera
     */
    public static final int FRONT_CAMERA = 1;
    /**
     * Use the back-facing camera
     */
    public static final int BACK_CAMERA = 0;
    /**
     * Return JPEG encoded image
     */
    public static final int CAMERA_ENCODING_TYPE_JPEG = 0;
    /**
     * Return PNG encoded image
     */
    public static final int CAMERA_ENCODING_TYPE_PNG = 1;
    /**
     * allow selection of still pictures only. DEFAULT. Will return format specified via DestinationType
     */
    public static final int CAMERA_MEDIA_TYPE_PICTURE = 0;

    /**
     *allow selection of video only, WILL ALWAYS RETURN FILE_URI
     */
    public static final int CAMERA_MEDIA_TYPE_VIDEO = 1;

    /**
     * allow selection from all media types
     */
    public static final int CAMERA_MEDIA_TYPE_ALL = 2;

    /**
     * Choose image from picture library (same as SAVEDPHOTOALBUM for Android)
     */
    public static final int PICTURE_SOURCE_TYPE_PHOTO_LIBRARY = 0;

    /**
     * Take picture from camera
     */
    public static final int PICTURE_SOURCE_TYPE_CAMERA = 1;
    /**
     * Choose image from picture library (same as PHOTOLIBRARY for Android)
     */
    public static final int PICTURE_SOURCE_TYPE_SAVED_PHOTO_ALBUM = 2;

    /**
     * Quality of the saved image, expressed as a range of 0-100,
     * where 100 is typically full resolution with no loss from file compression. (Number)
     * (Note that information about the camera's resolution is unavailable.)
     */
  private int quality;

    /**
     * Choose the format of the return value. Defined in navigator.camera.DestinationType (Number)
     */
  private int destinationType;
    /**
     * Set the source of the picture. Defined in navigator.camera.PictureSourceType (Number)
     */
  private int sourceType;
    /**
     * Choose the returned image file's encoding. Defined in navigator.camera.EncodingType (Number)
     */
  private int encoding;
    /**
     * Height in pixels to scale image.
     * Must be used with targetWidth. Aspect ratio remains constant. (Number)
     */
  private int targetHeightInPx;
    /**
     * Width in pixels to scale image. Must be used with targetHeight.
     * Aspect ratio remains constant. (Number)
     */
  private int targetWidthInPx;
    /**
     * Set the type of media to select from.
     * Only works when PictureSourceType is PHOTOLIBRARY or SAVEDPHOTOALBUM.
     * Defined in nagivator.camera.MediaType (Number)
     */
  private int mediaType;
    /**
     * Choose the camera to use (front- or back-facing).
     * Defined in navigator.camera.Direction (Number)
     */
  private int direction;
    /**
     * Allow simple editing of image before selection. (Boolean)
     */
  private boolean allowEdit;
    /**
     * Save the image to the photo album on the device after capture. (Boolean)
     */
  private boolean saveToPhotoAlbum;
    /**
     * Rotate the image to correct for the orientation of the device during capture. (Boolean)
     */
  private boolean correctOrientation;
    /**
     * iOS-only options that specify popover location in iPad. Defined in CameraPopoverOptions.
     */
  private PopOverOptions popOverOptions;

  public PictureOptions() {
    quality = 75;
    destinationType = DESTINATION_TYPE_DATA_URL;
    sourceType = PICTURE_SOURCE_TYPE_CAMERA;
    encoding = CAMERA_ENCODING_TYPE_JPEG;

    // no sizing by default...
    targetHeightInPx = -1;
    targetWidthInPx = -1;

    mediaType = CAMERA_MEDIA_TYPE_PICTURE;

    allowEdit = true;

    correctOrientation = false;
    saveToPhotoAlbum = false;
  }

  public PictureOptions(int quality) {
    this();
    this.quality = quality;
  }

  public int getQuality() {
    return quality;
  }

  public void setQuality(int quality) {
    this.quality = quality;
  }

  public int getSourceType() {
    return sourceType;
  }

  public int getDestinationType() {
    return destinationType;
  }

  public void setDestinationType(int destinationType) {
    this.destinationType = destinationType;
  }

  public void setSourceType(int sourceType) {
    this.sourceType = sourceType;
  }

  public int getEncoding() {
    return encoding;
  }

  public void setEncoding(int encoding) {
    this.encoding = encoding;
  }

  public void setTargetHeightInPx(int targetHeightInPx) {
    this.targetHeightInPx = targetHeightInPx;
  }

  public int getTargetHeightInPx() {
    return targetHeightInPx;
  }

  public int getTargetWidthInPx() {
    return targetWidthInPx;
  }

  public void setTargetWidthInPx(int targetWidthInPx) {
    this.targetWidthInPx = targetWidthInPx;
  }

  public void setMediaType(int mediaType) {
    this.mediaType = mediaType;
  }

  public int getMediaType() {
    return mediaType;
  }

  public void setAllowEdit(boolean allowEdit) {
    this.allowEdit = allowEdit;
  }

  public boolean isAllowEdit() {
    return allowEdit;
  }

  public void setCorrectOrientation(boolean correctOrientation) {
    this.correctOrientation = correctOrientation;
  }

  public boolean isCorrectOrientation() {
    return correctOrientation;
  }

  public void setSaveToPhotoAlbum(boolean saveToPhotoAlbum) {
    this.saveToPhotoAlbum = saveToPhotoAlbum;
  }

  public boolean isSaveToPhotoAlbum() {
    return saveToPhotoAlbum;
  }

  public void setPopOverOptions(PopOverOptions popOverOptions) {
    this.popOverOptions = popOverOptions;
  }

  public PopOverOptions getPopOverOptions() {
    return popOverOptions;
  }

  public int getDirection() {
    return direction;
  }

  public void setDirection(int direction) {
    this.direction = direction;
  }

}
