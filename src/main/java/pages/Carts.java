package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Carts extends Base{

	/**
	 * @return get Product Titles In Cart
	 */
	public WebElement getProductTitlesInCart(WebDriver driver) {
		return findElementByXPath(driver,"//span[@class=\"a-truncate sc-grid-item-product-title a-size-base-plus\"]");
	}
	
}
