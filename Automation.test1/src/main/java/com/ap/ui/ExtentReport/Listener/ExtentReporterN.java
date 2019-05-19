package com.ap.ui.ExtentReport.Listener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterN implements IReporter{//new class using built in TestNg interface
	private ExtentReports extent;//private constructor using object extent
	//we do not want to share results with any other project
	
public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>suites, 
		String outputDirectory){//creating a method that takes three arguments,
	//to generate a report, arguments list requirements, 
	//using a mechanism called List, which gets the array input
	//script will go back to xml suites, and look for "suites" which are the classes we created
	//we will create an xml file to contain all the classes within our test cases
	//PASS, FAIL, or SKIP will be string outputs; String outputDirectory
	//XML Suite: big time testing based on testing type
	//ISuite: pages we are working on; classes created to perform action; under test folder
	
	extent = new ExtentReports(outputDirectory + File.separator
			+ "Extent.html", true);
	//creating an object for extent report, creating a virtual object to save all output to save all results
	//as a string, file seperator is not needed, it doesn't matter how u received the result
	//seperate them and consolidate the results
	//telling you how to save the file name, html is easy to open on any device and lightweight
	//outputDirectory: SKIP, PASS, FAIL
	//the reason for boolean option: if yu receive results, generate report//if yu dont then dont generate
	for(ISuite suite : suites){//for loop is created
		//map obtains a key value, not duplicate, and then maps it to one location, which is the
		//extent report
		//an interface in java, between key value and location (between status and extent report)
		//will make sure how to map and seperate results under each class
		Map<String, ISuiteResult>result = suite.getResults();
	
	for(ISuiteResult r : result.values()){
		ITestContext context =r.getTestContext();//for each of the classes, create log status
		//test context: script that we are running, results from it
		//: is a conditional operator, which lists the conditions, which lists out the conditions
		//script should be able to run 
		//one suite, or multiple suites in one shot
		//making context
		
		
		buildTestNo(context.getPassedTests(), LogStatus.PASS);
		buildTestNo(context.getFailedTests(), LogStatus.FAIL);
		//retrieving status using results/context
		buildTestNo(context.getSkippedTests(), LogStatus.SKIP);
			
	}
}
extent.flush();//take results and place on html file
extent.close();

}

private void buildTestNo(IResultMap tests, LogStatus status){
	ExtentTest test;
	
	if(tests.size()>0){
		for (ITestResult result : tests.getAllResults()){
			test = extent.startTest(result.getMethod().getMethodName());//get method names for tests
			
			test.setStartedTime(getTime(result.getStartMillis()));//calculate duration of each test
			test.setEndedTime(getTime(result.getEndMillis()));
			
			for(String group : result.getMethod().getGroups())
				//categorize the results, organize them into groups
				
				test.assignCategory(group);
			
			if(result.getThrowable() !=null){//if there is an error, log it
				test.log(status, result.getThrowable());
			}else{
				test.log(status, "Test" + status.toString().toLowerCase() + "ed");
				//take the status and add ed to it
				
		}
			extent.endTest(test);//close off the test
			
	}
}
}
private Date getTime(long millis){//gets time of local machine's time
	Calendar calender = Calendar.getInstance();
	calender.setTimeInMillis(millis);
	return calender.getTime();
	
	
}
}











