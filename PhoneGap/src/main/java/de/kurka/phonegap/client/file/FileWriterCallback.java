/**
 * 
 */
package de.kurka.phonegap.client.file;

/**
 * @author mchrist
 * 
 */
public interface FileWriterCallback {

	public void onSuccess(Integer len);

	public void onFailure();

}
