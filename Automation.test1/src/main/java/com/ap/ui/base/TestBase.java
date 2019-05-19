package com.ap.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;//initiates the web driver

import com.ap.ui.util.TestUtil;
import com.ap.ui.util.WebEventListener;//captures the run-time status of an action

public class TestBase {
	
	public static WebDriver driver;//setting property values for the class
	public static Properties propt;
	public static EventFiringWebDriver en_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){//constructor; blueprint of a class; same name as main class
		try{//always use try-catch to access files; it captures an error that occurs, and avoiding errors when dealing with file
			propt = new Properties();
			FileInputStream ipa = new FileInputStream(System.getProperty("user.dir") + "/Automation.test1/src/main/java/com/ap/ui/config/config.properties");//new object ipa created to save info from properties file sheet
			propt.load(ipa);
			}catch (FileNotFoundException e){
				e.printStackTrace();
			}catch (IOException e){
				e.printStackTrace();
			}
	}
	public static void initialization(){//methods here to initiate appropriate browser
		String browserName = propt.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){//set properties of chrome browser
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver","");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("IE"));//Ignore Case ignores upper or lower case
		{
			System.setProperty("webdriver.ie.driver", "provide file path of driver");
			driver=new InternetExplorerDriver();
		}
		//new objects created to capture properties; reduces run-time
		en_driver = new EventFiringWebDriver(driver);
		//create object of WebEventListener to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		//event can be captured based on the method we create WebEventListener class
		en_driver.register(eventListener);
		//since web driver object is for browser en_driver is for event. we are declaring with 
		//equal to each when they are exchanging the info 
		
		driver = en_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);//extension of TestUtil
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_Load, TimeUnit.SECONDS);//extension of TestUtil
		
		driver.get(propt.getProperty("url"));
		
		}
	

}
