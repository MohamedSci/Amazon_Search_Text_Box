package tests;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.HomePage;
import pages.ProductsPage;

public class HomePageTest extends BaseTest{
	HomePage home = new HomePage();
	ProductsPage products = new ProductsPage();
	
	@Test(priority=1)
  public void searchInputTapped() throws InterruptedException {
	  home.getSearchInput(driver).click();;
	  WebElement autocompleteContainer= home.getAutocompleteContainer(driver);
	  assertThat(autocompleteContainer.isEnabled(),is(true));
  }

	@Test(priority=3)
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
 
	@Test(priority=4)
	public void inputAndPressEnter() throws InterruptedException {
		String searchTxt = "قميص";
		WebElement searchInput = home.getSearchInput(driver);
		searchInput.clear();
		searchInput.sendKeys(searchTxt);
		searchInput.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		WebElement productTitleElemrnt =products.getProductsTitle(driver);
		assertThat(productTitleElemrnt.getText(),containsString(searchTxt.substring(1)));
	}
	
	@Test(priority=2)
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
        WebElement productCategoryDropdown = home.getProductCategoryDropdownBox(driver);
        productCategoryDropdown.click();
        List<WebElement> allProductCategoryOptions = home.getAllProductCategoryOptions(driver);
        WebElement searchInput = home.getSearchInput(driver);

        for (int i = 0; i < allProductCategoryOptions.size(); i++) {
            searchInput.clear();
            String selectedOptionText = allProductCategoryOptions.get(i).getText();
            allProductCategoryOptions.get(i).click();
            searchInput.sendKeys(Keys.ENTER);
            String ProductsCategoryHeader = products.getProductsCategory(driver).getText();
            assertThat(ProductsCategoryHeader, containsString(selectedOptionText));
        }

    }
	
	
}
