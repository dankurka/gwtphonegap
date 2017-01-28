/*
 * Copyright 2013 Ronny Bubke
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.util;

import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Ronny Bubke
 * 
 */
public class JSNIHelper {

	private final static String PATH_SEPARATOR = "[.]";

	/**
	 * Convenient method to easily get a value from a javascript object.
	 * 
	 * @param object
	 *            the javascript object you want to get the property value from.
	 * @param propertyPath
	 *            is the dotted path to the object ( for instance "data.url" or
	 *            just "id").
	 * @return
	 */
	public static <T> T getPropertyValue(JavaScriptObject object,
			String propertyPath) {
		String[] pathArray = propertyPath.split(PATH_SEPARATOR);
		JavaScriptObject pathObject = object;
		for (int i = 0; i < pathArray.length - 1; i++) {
			if (pathObject == null) {
				return null;
			}
			pathObject = getPropertyValueNative(pathObject, pathArray[i]);
		}
		return getPropertyValueNative(pathObject,
				pathArray[pathArray.length - 1]);

	}

	private native static <T> T getPropertyValueNative(JavaScriptObject object,
			String propertyName)
	/*-{
	 	if(object) {
			return object[propertyName];
		}
		return null;
	}-*/;

	/**
	 * Convinient method to map from a map to a javascript object
	 * 
	 * <br>
	 * <code>
	 * Example:<br>
	 * map.put("id", "1234");<br>
	 * map.put("name", "Ronny Bubke");<br>
	 * becomes:<br>
	 * { id : "1234", name : "Ronny Bubke" }<br>
	 * </code>
	 * 
	 * @param map
	 * @return
	 */
	public static JavaScriptObject createObject(Map<String, ?> map) {
		String[] keys = null;
		Object[] values = null;
		if (map != null) {
			keys = map.keySet().toArray(new String[0]);
			values = map.values().toArray(new Object[0]);
		}
		return createObjectNative(keys, values);
	}

	private static native JavaScriptObject createObjectNative(String[] keys,
			Object[] values)
	/*-{
	 	var object = {};
	 	if(keys && values) {
		 	for (var i=0;i<keys.length;i++) {
		 		object[keys[i]] = values[i];
		 	}
	 	}
	 	return object;
	}-*/;

}
