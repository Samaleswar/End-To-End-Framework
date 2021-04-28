package Resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	public WebDriver driver;
	
	By email=By.cssSelector("#user_email");
	By password=By.cssSelector("#user_password");
	By submit=By.cssSelector("input[class=\"btn btn-primary btn-md login-button\"]");
	
	public loginPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
		
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}

	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}

}
