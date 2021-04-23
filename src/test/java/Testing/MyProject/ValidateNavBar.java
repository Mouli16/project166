package Testing.MyProject;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import Resources.Base;

public class ValidateNavBar extends Base {
	
	public WebDriver driver; 
	public static Logger log =LogManager.getLogger(Base.class.getName());	
@BeforeTest
 public void initialStep() throws IOException
 {
	driver= initializeDriver();
	
	driver.get(url);
 }
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		
		LandingPage l = new LandingPage(driver);
	    l.getNavBar().isDisplayed();
	    //compare the text with actual text from browser
	    Assert.assertTrue(l.getNavBar().isDisplayed());
	    log.info("Navigation bar is displayed");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
