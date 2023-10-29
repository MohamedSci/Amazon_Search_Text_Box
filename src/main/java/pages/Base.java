package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
//WebDriver driver ;
public  FluentWait<WebDriver> waitForElement(WebDriver driver) {
    FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class);
return wait;
}

public WebElement findElementByXPath(WebDriver driver, String xPath) {
	FluentWait<WebDriver> wait =waitForElement(driver);
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xPath)));
	WebElement element  = driver.findElement(By.xpath(xPath));
	System.out.println(element.isDisplayed()+"//////////// findElementByXPath **************/// "+xPath);
	return element ;
}
public List<WebElement> findManyElementsByXPath(WebDriver driver, String xPath) {
	FluentWait<WebDriver> wait =waitForElement(driver);
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xPath)));
	List<WebElement> elementsList  = driver.findElements(By.xpath(xPath));
	System.out.println(elementsList.get(1).isDisplayed()+"////////////findManyElementsByXPath**************/// "+xPath);
	return elementsList ;
}
public WebElement findElementById(WebDriver driver,String id) {
	FluentWait<WebDriver> wait =waitForElement(driver);
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(id)));
	WebElement element =driver.findElement(By.id(id));
	System.out.println(element.isDisplayed()+"////////////findElementById**************/// "+id);
	return element;
}

public WebElement findElementByCssSelector(WebDriver driver,String cssSelector) {
	FluentWait<WebDriver> wait =waitForElement(driver);
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
	WebElement element =driver.findElement(By.cssSelector(cssSelector));
	System.out.println(element.isDisplayed()+"//////////// findElementByCssSelector **************/// "+cssSelector);
	return element;
}

public WebElement findElementByTagName(WebDriver driver,String tagName) {
	FluentWait<WebDriver> wait =waitForElement(driver);
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName(tagName)));
	WebElement element =driver.findElement(By.tagName(tagName));
	System.out.println(element.isDisplayed()+"//////////// findElementByTagName **************/// "+tagName);
	return element;
}

}
