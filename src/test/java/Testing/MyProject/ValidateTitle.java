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

public class ValidateTitle extends Base {
	
	public WebDriver driver; 
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
	    l.getTitle().getText();
	    //compare the text with actual text from browser
	    Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
