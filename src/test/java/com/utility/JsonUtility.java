package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JsonUtility {

	public static void main(String[] args) throws FileNotFoundException {
		Gson gson = new Gson();
		
	File jsonfile = new File(System.getProperty("user.dir")+"\\config\\config.json");
	FileReader filereader = new FileReader(jsonfile);
	Config config = gson.fromJson(filereader, Config.class);
	Environment env = config.getEnvironments().get("DEV");
	System.out.println(jsonfile);
	System.out.println(env);
	String  url = env.getUrl();
	System.out.println(url);
	}

}
