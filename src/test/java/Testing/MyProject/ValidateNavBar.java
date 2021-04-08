package Testing.MyProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class ValidateNavBar extends Base {
	
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
	    
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
