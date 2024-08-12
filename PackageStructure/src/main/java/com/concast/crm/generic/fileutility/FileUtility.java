package com.concast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
public String getDataFromPropertiesFile(String key) throws Exception
{
	FileInputStream fis=new FileInputStream("./configAppData/vtige.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String data=pobj.getProperty(key);
	return data;
	
}
}
