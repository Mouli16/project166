package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	
	public WebDriver driver;
	
	/** accessing private variables through public methods; 
	locators are not accessible outside this class-->Encapsulation **/
	
	private By email=By.cssSelector("[id='user_email']");
	private By sendMeInstructions=By.cssSelector("[type='submit']");
	


/** @FindBy(id="email")
WebElement email;  **/
	
	
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}


	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement sendMeInstructions()
	{
		return driver.findElement(sendMeInstructions);
	}
	
	

	
	
}
