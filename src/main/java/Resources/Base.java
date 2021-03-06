package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Base {
	public WebDriver driver;
	 public Properties prop;
	 protected String BrowserName, url;
		
	public WebDriver initializeDriver() throws IOException
	{
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		BrowserName= prop.getProperty("browser");
		 url= prop.getProperty("url");
		if(BrowserName.equals("chrome"))
		{
			//execute in chrome browser
			
			System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\src\\main\\java\\Resources\\chromedriver.exe");
			ChromeOptions options =  new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options); // Polymorphism (method overriding)
		}
		else if(BrowserName.equals("IE"))
		{
			//set IE properties to execute in IE browser
			
		} 
		  
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testCaseName+ ".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		
	}

}
