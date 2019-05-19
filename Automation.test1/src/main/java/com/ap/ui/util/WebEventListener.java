//We have created this class WebDriverEventListener in order to implement interface 
//to override all the methods and define certain helpful log actions which would
//be displayed/logged as the app under test is being executed. These methods will be invoked by itself automatically,
//when certain actions are performed. Ex: click, submit, screenshot, findby, etc.
//all statuses of action are printed in the console area
package com.ap.ui.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ap.ui.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
	//creating a class WebEventListeneer and making a connection with the TestBase file, which has object
	//repository, browser invoking, and properties, so that is the super/parent class
	//extends: for inheritance from TestBase super class
	//implements: for interface with WebDriverEventListener, which is a built in function from selenium webdriver

	public void beforeNavigate(String url, WebDriver driver){
		//before going to the website, perform this action
		System.out.println("Before navi to: '" + url + "'");
		}
	public void afterNavigate(String url, WebDriver driver){
		//after going onto the website, perform this action
		System.out.println("Navigate to: '" + url + "'");
	}
	public void beforeChangeValueof(WebElement element, WebDriver driver){
		//change the value of
		System.out.println("Value of: " + element.toString() + " before making any change");
	}
	public void afterChangeValueof(WebElement element, WebDriver driver){
		System.out.println("Element Value changed to: " + element.toString());
	}
	public void beforeClickingOn(WebElement element, WebDriver driver){
		System.out.println("Attempting to Click on: " + element.toString());
}
	public void afterClickingOn(WebElement element, WebDriver driver){
		System.out.println("Successfully Clicked on: " + element.toString());
	}
	public void beforNavigatingback(WebDriver driver){
		System.out.println("Navigating back to previous page");
}
	public void afterNavigatingback(WebDriver driver){
		System.out.println("Navigating to current page");
	}
	public void beforeNavigatingforward(WebDriver driver){
		System.out.println("Attempting Navigating forward to next page");
	}
	public void afterNavigatingforward(WebDriver driver){
		System.out.println("Successfully Navigating forward to next page");
	}
	public void dueToException(Throwable error, WebDriver driver) throws IOException{
		System.out.println("Exception occured: " + error);
		TestUtil.takeScreenshotAtEndOftest();
	}
	public void beforeFindBy(By by, WebElement element, WebDriver driver){
		System.out.println("Attempting Find the element: " + by.toString());
	}
	public void afterFindBy(By by, WebElement element, WebDriver driver){
		System.out.println("Successfully Found the element: " + by.toString());
	}
	//These are non-over-ridden methods of the WebListener class
	//script runs one time
	//utilized only one when running the script
	public void beforeScript(String script, WebDriver driver){
		
	}
	public void afterScript(String script, WebDriver driver){
		
	}
	public void beforeAcceptingAlert(WebDriver driver){
		
	}
	public void afterAcceptingAlert(WebDriver driver){
		
	}
	public void beforeDismissingAlert(WebDriver driver){
		
	}
	public void afterDismissingAlert(WebDriver driver){
}
	public void beforeNavigateRefresh(WebDriver driver){
		
	}
	public void afterNavigateRefresh(WebDriver driver){
}
	public void beforeChangeValueof(WebElement element, WebDriver driver, CharSequence [] keysToSend){
		
	}
	public void afterChangeValueof(WebElement element, WebDriver driver, CharSequence [] keysToSend){
}
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0){// X is any random string
		
	}
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1){
		
	}
	public void beforeGetText(WebElement arg0, WebDriver arg1){
	}
	public void afterGetText(WebElement arg0, WebDriver arg1, String agr2){
}
	public void beforeSwitchToWindow(String arg0, WebDriver arg1){
	}
	public void afterSwitchToWindow(String arg0, WebDriver arg1){
}
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	