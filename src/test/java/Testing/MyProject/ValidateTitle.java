package Testing.MyProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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
	LandingPage l;
	
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
		
		
		 l = new LandingPage(driver);
	    l.getTitle().getText();
	    //compare the text with actual text from browser 
	    Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
	   log .info("Successfully validated Text message");
	   
	} 
		
@Test
	
	public void validateHeader() throws IOException
	{
		
System.out.println("am i going inside it");
Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		}

	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
