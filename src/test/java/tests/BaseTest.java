package tests;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import Utilies.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class BaseTest extends AbstractTestNGCucumberTests{
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void inititialize() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.eg/");
	}
	
	@Test
	public void assertCurrebtURL() {
		String cURL = driver.getCurrentUrl();
		System.out.println("The Current URL "+ cURL);
		assertThat(cURL,containsString("amazon"));
	}
	
	@AfterMethod
	public void takeScreenOnFailor(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			Helper helper = new Helper();
			// Take A Screen Shot for Failed Element
			helper.takeElementsScreenshot(driver, result.getName());
			// Take Screen Shot to the Full page
			helper.captureFullPageScreenshot(driver, result.getName());
		}
	}
	
	@AfterSuite
	public void quiteAll(){
		driver.quit();
	}

}
