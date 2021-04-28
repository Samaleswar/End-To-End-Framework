package Maven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Configuration.base;
import Resources.landingPage;

public class logovalidateTest extends base {
	public static Logger log = LogManager.getLogger(logovalidateTest.class.getName());
	public WebDriver driver;

	@Test
	public void logoValidation() throws IOException {

		landingPage po = new landingPage(driver);
		Assert.assertTrue(po.getLogo().isDisplayed());
		log.info("Logo is Displayed");

	}

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(getUrl());
		log.info("Logo validation Started.");

		

	}

	@AfterTest
	public void closetab() {
		driver.close();
		log.info("Logo validation Browser closed.");

	}

}
