package de.kurka.phonegap.client.file;

/**
 * 
 * 
 * @author Daniel Kurka
 * 
 */
public class FileManager {

	public native boolean isAvailable() /*-{
		if(!(typeof($wnd.navigator.fileMgr) == "undefined"))
		{
		return true;
		}
		return false;
	}-*/;

	public native void deleteDirectory(String fileName, DirectoryDeleteCallback directoryDeleteCallback) /*-{
		var successCallback = function(data){
		directoryDeleteCallback.@de.kurka.phonegap.client.file.DirectoryDeleteCallback::onSuccess()();
		};

		var errorCallback = function(){
		directoryDeleteCallback.@de.kurka.phonegap.client.file.DirectoryDeleteCallback::onFailure()();
		};

		$wnd.navigator.fileMgr.deleteDirectory(fileName, successCallback, errorCallback);
	}-*/;

	public native void deleteFile(String fileName, FileDeleteCallback fileDeleteCallback) /*-{
		var successCallback = function(data){
		fileDeleteCallback.@de.kurka.phonegap.client.file.FileDeleteCallback::onSuccess()();
		};

		var errorCallback = function(){
		fileDeleteCallback.@de.kurka.phonegap.client.file.FileExistsCallback::onFailure()();
		};

		$wnd.navigator.fileMgr.deleteFile(fileName, successCallback, errorCallback);
	}-*/;

	public native void createDirectory(String fileName, DirectoryCreateCallback directoryCreateCallback) /*-{
		var successCallback = function(data){
		directoryCreateCallback.@de.kurka.phonegap.client.file.DirectoryCreateCallback::onSuccess()();
		};

		var errorCallback = function(){
		directoryCreateCallback.@de.kurka.phonegap.client.file.DirectoryCreateCallback::onFailure()();
		};

		$wnd.navigator.fileMgr.createDirectory(fileName, successCallback, errorCallback);
	}-*/;

	public native void testDirectoryExists(String fileName, DirectoryExistsCallback directoryExistsCallback) /*-{
		var successCallback = function(data){
		if(data == 1)
		{	
		directoryExistsCallback.@de.kurka.phonegap.client.file.DirectoryExistsCallback::onDirectoryExist()();
		}else{
		directoryExistsCallback.@de.kurka.phonegap.client.file.DirectoryExistsCallback::onDirectoryNotExist()();
		}
		};

		var errorCallback = function(){
		directoryExistsCallback.@de.kurka.phonegap.client.file.DirectoryExistsCallback::onFailure()();
		};

		$wnd.navigator.fileMgr.testDirectoryExists(fileName, successCallback, errorCallback);
	}-*/;

	public native void testFileExists(String fileName, FileExistsCallback fileExistsCallback) /*-{
		var successCallback = function(data){
		if(data == 1)
		{
		fileExistsCallback.@de.kurka.phonegap.client.file.FileExistsCallback::onFileExist()();
		}else{
		fileExistsCallback.@de.kurka.phonegap.client.file.FileExistsCallback::onFileNotExist()();
		}
		};

		var errorCallback = function(){
		fileExistsCallback.@de.kurka.phonegap.client.file.FileExistsCallback::onFailure()();
		};

		//workaround monitor fix in phonegap...
		$wnd.navigator.fileMgr.successCallback= successCallback;
		$wnd.navigator.fileMgr.errorCallback = errorCallback;
		$wnd.navigator.fileMgr.testFileExists(fileName, successCallback, errorCallback);
	}-*/;

	public native void readFile(String fileName, FileReadCallback fileReadCallback) /*-{
		var fr = new $wnd.FileReader();

		fr.onload = function (data) {
		console.log(data.target.result);
		fileReadCallback.@de.kurka.phonegap.client.file.FileReadCallback::onSuccess(Ljava/lang/String;)(data.target.result);
		};

		fr.onerror = function(stuff)
		{
		console.log(stuff.target.error.code);
		fileReadCallback.@de.kurka.phonegap.client.file.FileReadCallback::onFailure()();
		};

		fr.readAsText(fileName);
	}-*/;

	public native void writeFile(String fileName, String text, boolean append, FileWriterCallback fileWriterCallback) /*-{
		var fr = new $wnd.FileWriter();

		fr.oncomplete = function (data) {

		fileWriterCallback.@de.kurka.phonegap.client.file.FileWriterCallback::onSuccess(Ljava/lang/Integer;)(data);
		};

		fr.onerror = function(stuff)
		{

		fileWriterCallback.@de.kurka.phonegap.client.file.FileWriterCallback::onFailure()();
		};

		fr.writeAsText(fileName, text, append);
	}-*/;

}
