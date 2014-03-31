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

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;

public class CameraBrowserImpl implements CameraMock {

  public interface CameraBundle extends ClientBundle {

    @Source("resources/camera_success.jpg")
    public DataResource getSuccessPicture();
  }

  public CameraBrowserImpl() {
    setPictureUrl(GWT.getModuleBaseURL() + "resources/camera_success.jpg");
  }

  protected CameraBundle bundle;
  private String pictureUrl;

  protected CameraBundle getBundle() {
    if (bundle == null) {
      bundle = GWT.create(CameraBundle.class);
    }
    return bundle;
  }

  @Override
  public CameraPopoverHandle getPicture(PictureOptions options, PictureCallback callback) {
    if (shouldFail) {
      callback.onFailure("should fail");
      return null;
    }

    if (options.getDestinationType() == PictureOptions.DESTINATION_TYPE_DATA_URL) {
      callback.onSuccess(getBundle().getSuccessPicture().getSafeUri().asString().substring(
          "data:image/jpeg;base64,".length()));
    } else {
      if (options.getDestinationType() == PictureOptions.DESTINATION_TYPE_FILE_URI) {

        callback.onSuccess(this.pictureUrl);

      } else {
        callback.onFailure("wrong type");
      }

    }
   //TODO: Find a way to mock handle object and return it.
    return null;
  }

  @Override
  public void setCameraBundle(CameraBundle bundle) {
    this.bundle = bundle;
  }

  @Override
  public void setPictureUrl(String url) {
    this.pictureUrl = url;
  }

  private boolean shouldFail;

  @Override
  public void setShouldFail(boolean fail) {
    this.shouldFail = fail;

  }

  @Override
  public void cleanUp(CameraCallback callback) {
    callback.onSuccess();

  }

}
