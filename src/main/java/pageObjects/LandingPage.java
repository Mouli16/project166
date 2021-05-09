package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
		public WebDriver driver;
		

		/** accessing private variables through public methods; 
		locators are not accessible outside this class-->Encapsulation **/
		
		private By signIn = By.cssSelector("a[href*='sign_in']");
		private By title = By.cssSelector(".text-center>h2");
		private By navBar = By.xpath("//a[@class='navbar-brand']");  //.nav-navbar-nav.navbar-right>li>a
		private By header=By.cssSelector("div[class*='video-banner'] h3");
		
		public LandingPage(WebDriver driver) 
		{
			this.driver= driver;
		}

		public LoginPage getLogin()
		{
			 driver.findElement(signIn).click();
			 LoginPage lp=new LoginPage(driver);
			 return lp;
		} 

		
		
		public WebElement getTitle()
		{
			return driver.findElement(title);
		}
		
		public WebElement getNavBar()
		{
			return driver.findElement(navBar);
		}
		
		public WebElement getHeader()
		{
			return driver.findElement(header);
		}
		
	}


