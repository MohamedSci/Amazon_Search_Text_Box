package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsDetailsPage extends Base{

	/**
	 * @return the resultTitle
	 */
	public WebElement getAddToCartButton(WebDriver driver) {
		return findElementById(driver,"add-to-cart-button");
	}
	
	
	/**
	 * @return the Successful Message Add To Cart Button
	 */
	public WebElement getAddToCartSuccess(WebDriver driver) {
		return findElementByXPath(driver,"//span[@class=\"a-size-medium-plus a-color-base sw-atc-text a-text-bold\"]");
	}
	

	/**
	 * @return Nav Cart Button Icon
	 */
	public WebElement getNavCartButtonIcon(WebDriver driver) {
		return findElementByXPath(driver,"//span[@class=\"nav-cart-icon nav-sprite\"]");
	}
	
	
	
	/**
	 * @return get Product Titles In Cart
	 */
	public WebElement getProductTitlesInCart(WebDriver driver) {
		return findElementByXPath(driver,"//span[@class=\"a-truncate sc-grid-item-product-title a-size-base-plus\"]");
	}
	
}
