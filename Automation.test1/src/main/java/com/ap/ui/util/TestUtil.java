package com.ap.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ap.ui.base.TestBase;

public class TestUtil extends TestBase {//allows us to read information on an excel sheet or the 
	//website we're interacting with
	//making connection with TestBase
	
	public static long Page_Load = 10;//landing on page, wait 10 seconds
	public static long Implicit_Wait = 10;
	
	public static String XL_SHEET_PATH = "path of the xl sheet";
	
	static Workbook book;//telling script to go to excel file 
	static Sheet sheet;//telling script to go to sheet on excel
	
	static JavascriptExecutor js;
	static JavascriptExecutor messageType;
	
	public static Object[][] getTestData(String sheetName){//created a method with String
		FileInputStream file = null;//return type, if cell is empty don't work with it
		//no data = no running method
		
		
		try{//try catch for excel...working with files need to be handles with IOException or try catch block
			file = new FileInputStream(XL_SHEET_PATH);
		}catch (FileNotFoundException e){
			e.printStackTrace();//file level error handling
		}
		
		try{
			book = WorkbookFactory.create(file);//try catch on the workbook level
		}catch (InvalidFormatException e){
			
		}catch (IOException e){
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);//written a method to go thru info on excel sheet
		//creating an array to hold info on sheet
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
		for(int i = 0; i<sheet.getLastRowNum();i++){
			for (int j = 0; j<sheet.getRow(0).getLastCellNum(); j++){
				data[i][j]=sheet.getRow(i + 1).getCell(j).toString();//treating everything as a string
				//pass it to the script
			}
		}
		return data;
	}
	public static void takeScreenshotAt() throws IOException{//taking a screenshot and saving it
		//using information from project directory
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDirect = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDirect + "/screenshot/" + 
		System.currentTimeMillis() + ".png"));
	
		
	}
	public static void runTimeInfo(String messageTpe, String message) throws IOException, InterruptedException{
		//capturing the console log during the execution of the script 
		js = (JavascriptExecutor) driver;
		
		js.executeScript("if (!window.JQuery){"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+"jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");//grabbing header info
		
	Thread.sleep(2000);//wait statement in place to handle dependencies
	//getting info from api
	
	js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
	//retrieving information onto selenium
	
	js.executeScript("$('head').append('<link rel=\"stylesheet\" "
			+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
	Thread.sleep(3000);

	js.executeScript("$ growl ({title: 'GET', message: '/'});");//setting logic to seperate information 
	//errors, warnings, and notices, making info seamless to read
	
	
	if(messageType.equals("error")){
		js.executeScript("$growl.error({title: 'ERROR' message: '" + message + "'});");
	}else if(messageType.equals("info")){
		js.executeScript("$growl.error({title: 'Notice' , message: 'notice message will appear here'});");
	}else if (messageType.equals("warning")){
		js.executeScript("$growl.error({title: 'Warning!!' , message: 'warning will appear here'});");
		
	}else
		System.out.println("Show NO Error Message");
	Thread.sleep(6000);
	}
	public static void takeScreenshotAtEndOftest() {
		// TODO Auto-generated method stub
		
	}
		
}
	
	
	
	
	
	
	
	
	
	
	



