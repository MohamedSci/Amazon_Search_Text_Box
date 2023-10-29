package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Base{
	
// The Search Text Inputed here
	public WebElement getSearchInput(WebDriver driver) {
		return findElementByXPath(driver,"//input[@id=\"twotabsearchtextbox\"]");
	}
//To Choose the Product Category	
	public WebElement getProductCategoryDropdownBox(WebDriver driver) {
		return findElementByXPath(driver,"//select[@id=\"searchDropdownBox\"]");
	}
	
	//To Choose the Product Category	
		public List<WebElement> getAllProductCategoryOptions(WebDriver driver) {
			return findManyElementsByXPath(driver,"//select[@id=\"searchDropdownBox\"]//child::option");
		}	
	
// The Search Submit Button Icon	
	public WebElement getSearchSubmitIcon(WebDriver driver) {
		return findElementById(driver,"nav-search-submit-button");
	}
// The Box in which the suggestions are displayed
	public WebElement getAutocompleteContainer(WebDriver driver) {
		return findElementByXPath(driver,"//div[@class=\"left-pane-results-container\"]");
	}

	// The Box in which the suggestions are displayed
		public WebElement getFirst_Suggestions(WebDriver driver) {
			return findElementByXPath(driver,"//div[@class=\"s-suggestion-trending-container\"]/child::div[1]");
		}
	
}
