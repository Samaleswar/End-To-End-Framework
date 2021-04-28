package Maven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Configuration.base;
import Resources.landingPage;
import Resources.loginPage;

public class HomepageTest extends base {
	public static Logger log = LogManager.getLogger(HomepageTest.class.getName());
	public WebDriver driver;

	@Test(dataProvider = "getData")
	public void basepagenavigation(String username, String password) throws IOException {

		driver.get(getUrl());

		landingPage po = new landingPage(driver);
		po.getLogin().click();

		loginPage lp = new loginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getSubmit().click();
		log.info("Test done with credential");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[2][2];

		obj[0][0] = "sam@pritam";
		obj[0][1] = "pritam";

		obj[1][0] = "sam@pritam";
		obj[1][1] = "sam@pritam";

		return obj;

	}

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

		log.info("Arrived at url for execution");
	}

	@AfterTest
	public void closetab() {
		driver.close();
		log.info("Browser closed.");

	}
}