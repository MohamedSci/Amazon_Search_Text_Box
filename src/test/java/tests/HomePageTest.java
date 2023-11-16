package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pages.HomePage;
import pages.ProductsPage;

public class HomePageTest extends BaseTest{
	HomePage home = new HomePage();
	ProductsPage products = new ProductsPage();
	
	@Test(enabled = false,priority=1)
  public void searchInputTapped() throws InterruptedException {
	  home.getSearchInput(driver).click();;
	  WebElement autocompleteContainer= home.getAutocompleteContainer(driver);
	  assertThat(autocompleteContainer.isEnabled(),is(true));
  }

	@Test(enabled = false,priority=3)
	public void inputAndSubmitSearch() throws InterruptedException {
		String searchTxt = "كاميرا";
		WebElement searchInput = home.getSearchInput(driver);
		searchInput.clear();
		searchInput.sendKeys(searchTxt);
		home.getSearchSubmitIcon(driver).click();
		Thread.sleep(4000);
		WebElement productTitleElemrnt =products.getProductsTitle(driver);
		assertThat(productTitleElemrnt.getText(),containsString(searchTxt.substring(1)));
	}
 
	@Test(enabled = false,priority=4)
	public void inputAndPressEnter() throws InterruptedException {
		String searchTxt = "عصير";
		WebElement searchInput = home.getSearchInput(driver);
		searchInput.clear();
		searchInput.sendKeys(searchTxt);
		searchInput.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		WebElement productTitleElemrnt =products.getProductsTitle(driver);
		assertThat(productTitleElemrnt.getText(),containsString(searchTxt.substring(1)));
	}
	
	@Test(priority=5,enabled = false,dependsOnMethods = {"searchInputTapped"})
	public void NavigationAfterSelectionOFASuggesstions() throws InterruptedException {
		  home.getSearchInput(driver).click();;
		  WebElement first_Suggestion= home.getFirst_Suggestions(driver);
		  first_Suggestion.click();
		  Thread.sleep(2000);
        WebElement productTitleElement = products.getProductResultTitle(driver);
        assertThat(productTitleElement.getText(), containsString(first_Suggestion.getText()));
	  }
	
    @Test(priority = 5)
    public void check_catagory_drop_down_Button() {
        WebElement searchInput = home.getSearchInput(driver);
    	Actions actions = new Actions(driver);

    	actions.moveToElement(driver.findElement(By.id("searchDropdownBox")))
    		.click().build().perform();
    	
    Select select = new Select(driver.findElement(By.id("searchDropdownBox")));	
    select.selectByIndex(3);
    
    List<WebElement> allOptions =select.getOptions();
    for(int i =0 ; i<allOptions.size(); i++) {
    	searchInput.clear();
    	searchInput.sendKeys("a");;
        WebElement productCategoryDropdown = allOptions.get(i);
        productCategoryDropdown.click();

            searchInput.sendKeys(Keys.ENTER);
//            Assert.assertTrue(driver.getCurrentUrl().contains(allOptions.get(i).getText().toLowerCase()));
    }
    }
	
	
}
