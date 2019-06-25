package Framework;

import org.testng.annotations.BeforeTest;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class InitialDriverConfiguration {

	private WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "drivers" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	@AfterTest
	public void afterTest() {
		if(driver != null)
			driver.quit();
	}

}
