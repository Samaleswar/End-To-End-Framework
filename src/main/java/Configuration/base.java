package Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	
public WebDriver initializeDriver() throws IOException {
	prop=new Properties();
	String filePath = System.getProperty("user.dir")+"/src/main/resources/data.properties";
	FileInputStream fis=new FileInputStream(filePath);
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Working\\pritam_workspace\\Automation\\chromedriver.exe"); 
		driver = new ChromeDriver(); 		
	}
	else if(browserName.equals("firefox"))
	{

		System.setProperty("webdriver.gecko.driver", "D:\\pritam_workspace\\geckodriver.exe"); 
		driver = new FirefoxDriver();

	}
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
return driver;
}

public String getUrl() {
	String url=prop.getProperty("url");
	System.out.println(url);
	return url;
	
}

public String getScreenshot(String failedTestName,WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File ss=ts.getScreenshotAs(OutputType.FILE);
	String DestinationFile= System.getProperty("user.dir")+"\\reports\\"+failedTestName+".png";
	FileUtils.copyFile(ss, new File(DestinationFile));
	return DestinationFile;
	
	
}


}
