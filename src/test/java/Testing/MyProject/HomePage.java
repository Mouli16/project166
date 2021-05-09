package Testing.MyProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import Resources.Base;

public class HomePage extends Base {  //Inheritance
	public WebDriver driver; 
	
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest
	 public void initialStep() throws IOException
	 {
		driver= initializeDriver();
		
		
	 }
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String text) throws IOException
	{
		driver.get(url);
		
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lo = new LoginPage(driver);
		lo.getEmail().sendKeys(username);
		lo.getPassword().sendKeys(password);
		log.info(text);
		
		System.out.println(text);
		lo.getLogin().click();
		
		
		
	}

	@DataProvider
	
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//column stands for the number of values per test
		
		Object[][] data = new Object[2][3];
		//0th Row
		data[0][0]= "abc@def.com";
		data[0][1]= "123";
		data[0][2]= "Restricted user";
		
		//1st Row
		data[1][0]= "pqr@ghi.com";
		data[1][1]= "1235";
		data[1][2]= "Non-Restricted user"; 
		
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	
}
