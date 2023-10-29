package steps;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Carts;
import pages.HomePage;
import pages.ProductsDetailsPage;
import pages.ProductsPage;
import tests.BaseTest;

public class E2ETests extends BaseTest {

	HomePage homePage = new HomePage();
	ProductsPage productsPage = new ProductsPage();
	ProductsDetailsPage productsDetailsPage;
	Carts carts;
	Actions actions ;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("www.amazon.eg"));
	}

	@When("^Customer inputs \"([^\"]*)\" in the SearchBox and Submit$")
	public void he_search_for(String productName) throws InterruptedException {
		WebElement SearchInput = homePage.getSearchInput(driver);
		SearchInput.clear();
		SearchInput.sendKeys(productName);
		Thread.sleep(300);
		SearchInput.sendKeys(Keys.ENTER);		
		Assert.assertTrue(driver.getCurrentUrl().contains(productName));
	}

	@When("^select a product$")
	public void select_a_product() throws InterruptedException {
		List<WebElement> allProducts = productsPage.getAllProducts(driver);
		WebElement tenthProduct = allProducts.get(9);
		actions.moveToElement(tenthProduct);
		tenthProduct.click();
		Assert.assertTrue(driver.getCurrentUrl().contains(tenthProduct.getText()));
	}

	@When("^moves to product details and click Add to Carts button$")
	public void moves_to_product_details_and_click_Add_to_Carts_button() {
	WebElement addToCartButton = productsDetailsPage.getAddToCartButton(driver);
	addToCartButton.click();
	WebElement addToCartSuccess =productsDetailsPage.getAddToCartSuccess(driver);
	Assert.assertTrue(addToCartSuccess.isDisplayed());;
	}

	@Then("^the product \"([^\"]*)\" is in the checklist$")
	public void the_product_is_in_the_checklist(String productName) {
		productsDetailsPage.getNavCartButtonIcon(driver).click();
		Assert.assertTrue(carts.getProductTitlesInCart(driver).getText().contains(productName));
	}
}
