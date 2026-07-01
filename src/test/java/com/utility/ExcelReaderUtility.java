package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> main(String[] args) throws InvalidFormatException, IOException {
		
		File excelFile = new File(System.getProperty("user.dir")+"\\testData\\loginData.xlsx");
	
XSSFWorkbook xssfwork =new XSSFWorkbook(excelFile);
XSSFSheet xssfsheet = xssfwork.getSheet("loginData");
Iterator<Row> rowIterator = xssfsheet.iterator();
List<User> userList = new ArrayList<User>();
rowIterator.next();
while(rowIterator.hasNext()) {
	Row row =rowIterator.next();
	Cell firstCell = row.getCell(0);
	Cell secondCell = row.getCell(1);
	User user = new User(firstCell.toString(), secondCell.toString());
	userList.add(user);
}
System.out.println(userList);
return userList.iterator();


	}

}
