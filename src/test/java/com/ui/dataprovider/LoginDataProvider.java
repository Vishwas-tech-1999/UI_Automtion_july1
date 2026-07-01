package com.ui.dataprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.Data;
import com.ui.pojo.User;
import com.utility.CsvReaderUtility;

public class LoginDataProvider {
	
	
	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		
		Gson gson  = new Gson();
		File myfile=new File(System.getProperty("user.dir")+ "\\testData\\loginData.json");
		FileReader fileReader = new FileReader(myfile);
		Data data = gson.fromJson(fileReader, Data.class);
	List<Object[]> dataToReturn = 	new ArrayList<Object[]>();
	
	for(User user : data.getData())
	{
		dataToReturn.add(new Object[] {user});
	}
	
	return dataToReturn.iterator();
		
	}
	@DataProvider(name = "CsvLoginTestDataProvider")
	public Iterator<User> loginCsvDataProvider() throws CsvValidationException, IOException {
		return CsvReaderUtility.readCsvFile("loginData.csv");
	}

}
