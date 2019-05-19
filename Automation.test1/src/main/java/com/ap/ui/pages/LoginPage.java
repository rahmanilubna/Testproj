package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class LoginPage extends TestBase {
//Page Factory
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(xpath=".//[@id='SubmitLogin']")
	WebElement submitbutton;
	
	@FindBy(xpath="")
	WebElement apLogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		
		
		
		
	}



public String verifyPageTitle(){
	return driver.getTitle();
}
public boolean validateAPImage(){
	return apLogo.isDisplayed();
}
public HomePage login(String uname, String passw){
	username.sendKeys(uname);
	password.sendKeys(passw);
	submitbutton.click();
	return new HomePage();



}
	
	
	
	
	
	
	
	
	
	
	
	
}
