package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.ContactsPage;
import com.ap.ui.pages.HomePage;

public class ContactsTest extends TestBase {//class created to test the contacts page
	ContactsPage contactspage;//created virtual object for contactspage
	HomePage homepage;//created virtual object for homepage
	
	public ContactsTest(){//constructor
		super();//keyword used to implement parent class methods
	}
	@BeforeMethod
	public void setUpdriver(){//calling initialization method from TestBase 
		//and setting up the proper driver
		initialization();
		contactspage = new ContactsPage();//creating objects for these two pages
		homepage = new HomePage();
	}
	@Test
	public void testContact(){
		homepage.clickOnContactLink();
		contactspage = contactspage.fillContactForm("Customer service","Random@test.com",
				"Testing","This is test purpose");
		contactspage.submitMessage();
		String successMsg = contactspage.getMessage();
		Assert.assertEquals(successMsg, "Your message has been successfully sent");
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	

}
}