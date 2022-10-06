package org.makeMyTrip.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.makeMyTrip.constants.FrameworkConstants;
import org.makeMyTrip.enums.PropertyEnums;

public class ReadProperties {

	private ReadProperties() {

	}

	private static Properties prop = new Properties();
	private static Map<String , String> CONFIGMAP = new HashMap<>();
	static {
		try {
			/*REading opening of file*/
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
			prop.load(fis);
			
//			for(Object key : prop.keySet()) {//<---prop.keySet() it will return the set of "keys" from properties file
//				CONFIGMAP.put(String.valueOf(key), String.valueOf(prop.get(key)));
//			}/*String.valueOf(key):--- it will convert any i/p parameter to String*/

			for(Map.Entry<Object,Object> entry: prop.entrySet()) {
				/**/
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());

			}

		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException ie) {
			ie.printStackTrace();
		}
	}

	public static String get(PropertyEnums key) throws Exception {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property with the name "+key+" is not found. Please check config.prperties" );
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
