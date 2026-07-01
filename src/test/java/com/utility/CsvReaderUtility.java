package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CsvReaderUtility {

	public static Iterator<User> readCsvFile(String filenme) throws CsvValidationException, IOException {

	    File csvFile = new File(System.getProperty("user.dir") + "\\testData\\loginData.csv");

	    FileReader csvFileReader = null;
	    CSVReader csvReader = null;

	    List<User> userList = new ArrayList<>();

	    try {

	        csvFileReader = new FileReader(csvFile);
	        csvReader = new CSVReader(csvFileReader);

	        String[] line;

	        while ((line = csvReader.readNext()) != null) {

	            System.out.println(line[0] + " " + line[1]); // check CSV data

	            User user = new User(line[0], line[1]);
	            userList.add(user);
	        }
	        for(User user : userList) {
	 		   System.out.println(user);
	 	   }


	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }

	 

	    csvReader.close();
	    csvFileReader.close();
	    return userList.iterator();
	}
}
			
	

		
		 
		 

	


