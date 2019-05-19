package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;

public class LoginTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTest(){//constructor
		super();//constructor for parent class, TestBase; calls all methods one by one
		
	}
		@BeforeMethod
		public void setUpdriver(){//calling initialization method from TestBase 
			//and setting up the proper driver
			initialization();
			loginPage = new LoginPage();
			
		}
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.verifyPageTitle();//ensure the page title is correct
		Assert.assertEquals(title, " ");//built-in java concept to verify information
	}
	
	@Test(priority=2)
	public void apLogoTest(){//verifying company logo using true/false boolean method
		boolean value = loginPage.validateAPImage();
		Assert.assertTrue(value);
	}
	@Test(priority=3)
	public void loginTest(){//actual test being conducted on site using
		//info from properties file and using prpt object from TestBase to store values
		homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	}
	@AfterMethod//close browser after executing all methods
	public void closeBrowser(){
		driver.quit();
	}
}




















