package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.contants.Env;

public class PropertiesUtil {

	public static String readProperty(Env env, String propertyNme)   {
		// TODO Auto-generated method stub
		
		
		System.out.println(System.getProperty("user.dir"));
		File myfile = new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");
		FileReader fileReader = null;
		Properties properties = new Properties();
		String value = null;
		try {
			fileReader = new FileReader(myfile);
			properties.load(fileReader);
		 value = properties.getProperty(propertyNme);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
		
	}

}
