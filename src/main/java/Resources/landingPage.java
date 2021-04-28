package Resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class landingPage {

	public WebDriver driver;

	By signin = By.xpath("//span[contains(text(),'Login')]");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By logo = By.cssSelector("img[class=\"img-responsive logo\"]");
	By footer=By.cssSelector(".tint");
	By subtext=By.xpath("//p[contains(text(),'Learn Hot tools like Selenium, Appium, JMeter, Soa')]");
	By navigationbar=By.cssSelector(".navbar.navbar-default.navbar-static-top");
	
	
	public landingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogin() {
		return driver.findElement(signin);

	}

	public WebElement getTitle() {
		return driver.findElement(title);

	}

	public WebElement getLogo() {
		return driver.findElement(logo);

	}
	public WebElement getsubtext() {
		return driver.findElement(subtext);
		}

	public WebElement getfooter() {
		// TODO Auto-generated method stub
		return driver.findElement(footer);
		}
	public WebElement getnavibar() {
		return driver.findElement(navigationbar);
		}

}
