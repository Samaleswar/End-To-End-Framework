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

public class titlevalidateTest extends base {
	public static Logger log = LogManager.getLogger(titlevalidateTest.class.getName());
	public WebDriver driver;

	@Test
	public void titleValidation() throws IOException {

	
		landingPage po = new landingPage(driver);

		Assert.assertEquals(po.getTitle().getText(), "FEATURED COURSES");
		po.getTitle().getText();
		log.info("Title has been verified.");


	}
	
	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(getUrl());
		log.info("Title Varification start");
		;

	}
	
	
	@AfterTest
	public void closetab() {
		driver.close();
		log.info("Title Varification Browser closed.");

	}

}
