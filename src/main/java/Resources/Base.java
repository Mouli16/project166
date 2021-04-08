package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	 public Properties prop;
	 protected String BrowserName, url;
		
	public WebDriver initializeDriver() throws IOException
	{
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Mouli Sarkar\\eclipse-workspace1\\MyProject\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		BrowserName= prop.getProperty("browser");
		 url= prop.getProperty("url");
		if(BrowserName.equals("chrome"))
		{
			//execute in chrome browser
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Mouli Sarkar\\Documents\\Selenium\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(BrowserName.equals("IE"))
		{
			//set IE properties to execute in IE browser
			
		} 
		  
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
	}
		
	}


