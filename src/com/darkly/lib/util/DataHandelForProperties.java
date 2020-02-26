package com.darkly.lib.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;


public class DataHandelForProperties {
	public static String getDataFromProperties(String fileName, String key) {
		String data=null;
		try {
			File file= new File("./test-data/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);
			data = prop.get(key).toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public static void setDataToProperties(String fileName, String key, String value, String commentMsg) {
		try {
			File file = new File("./test-data/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(file);
			Properties prop  = new Properties();
			prop.load(fis);
			prop.setProperty(key,value);
			FileOutputStream fos = new FileOutputStream(file);
			prop.store(fos,commentMsg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String data = DataHandelForProperties.getDataFromProperties("dataFile","phone");
		System.out.println(data);
		DataHandelForProperties.setDataToProperties("dataFile","population","2 Billion","population added");
	}
}


