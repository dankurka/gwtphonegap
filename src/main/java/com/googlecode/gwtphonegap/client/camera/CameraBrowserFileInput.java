package com.googlecode.gwtphonegap.client.camera;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.googlecode.gwtphonegap.client.file.FileReader;
import com.googlecode.gwtphonegap.client.file.ReaderCallback;
import com.googlecode.gwtphonegap.client.file.js.FileObjectJsImpl;

public class CameraBrowserFileInput implements Camera {

	private final FileUpload input;
	private final CameraPopoverHandle popoverHandle;

	public CameraBrowserFileInput(){
		input = new FileUpload();
		input.getElement().setAttribute("accept", "image/*");
		input.getElement().setAttribute("capture", "camera");
		input.setVisible(false);
		RootPanel.get().add(input);
		
		popoverHandle = new CameraPopoverHandle() {
			
			@Override
			public void setPosition(PopOverOptions popOverOptions) {
				// not supported
			}
		};
	}
	
	@Override
	public CameraPopoverHandle getPicture(final PictureOptions options, final PictureCallback callback) {
		if(!input.isAttached()){
			callback.onFailure("after #cleanUp(), this instance is no longer useful");
			return popoverHandle;
		}
		
		
		@SuppressWarnings("unused")
		final ChangeHandler handler = new ChangeHandler() {
			
			private final HandlerRegistration reg = input.addChangeHandler(this);
			
			@Override
			public void onChange(ChangeEvent event) {
				reg.removeHandler();
				
				if(options.getDestinationType() == PictureOptions.DESTINATION_TYPE_DATA_URL){
					getBase64(new ReaderCallback<FileReader>(){

						@Override
						public void onCallback(FileReader result) {
							callback.onSuccess(result.getResult());
						}
					});
				}else{
					callback.onSuccess(getFileUri());
				}
			}
		};
		
		open(input.getElement());
		return popoverHandle;
	}

	private void getBase64(ReaderCallback<FileReader> callback){
		FileObjectJsImpl file = getFile(input.getElement());
		FileReader reader = createReader();
		reader.setOnLoadEndCallback(callback);
		reader.readAsDataUrl(file);
	}
	
	private String getFileUri(){
		return getFileUri0(input.getElement());
	}
	
	@Override
	public void cleanUp(CameraCallback callback) {
		input.removeFromParent();
		callback.onSuccess();
	}
	
	private native void open(Element element) /*-{
		element.click();
	}-*/;
	
	private native String getFileUri0(Element element)/*-{
		var URL = $wnd.URL || $wnd.webkitURL
	
		return URL.createObjectURL(element.files[0]);
	}-*/;
	
	private native FileReader createReader()/*-{
		return new $wnd.FileReader();
	}-*/;

	private native FileObjectJsImpl getFile(Element element)/*-{
		return element.files[0];
	}-*/;

}
