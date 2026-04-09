package com.Ninza.Hrm.api.File_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {
	
	public String getDataFromPropFile(String key) throws Exception {

		// Specify properties file path
		String path = "./Data Folder/Property.properties";

		// Open properties file
		FileInputStream fis = new FileInputStream(path);

		// Create Properties class object
		Properties properties = new Properties();

		// Load properties file into Properties object
		properties.load(fis);

		// Fetch value based on key
		String value = properties.getProperty(key);

		// Return value
		return value;
	}

}
