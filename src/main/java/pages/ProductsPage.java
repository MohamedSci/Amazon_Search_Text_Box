package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends Base{
			
	/**
	 * @return the resultTitle
	 */
	public WebElement getResultTitle(WebDriver driver) {
		return findElementByXPath(driver,"//span[text()=\"Results\"]");
	}
	
	
	/**
	 * @return All Products
	 */
	public List<WebElement> getAllProducts(WebDriver driver) {
		return findManyElementsByXPath(driver,"//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]");
	}
	/**
	 * @return the productTitle
	 */
	public WebElement getProductTitle(WebDriver driver) {
		return findElementByCssSelector(driver,".a-size-base-plus");
	}

	/**
	 * @return the productsTitle
	 */
	public WebElement getProductsTitle(WebDriver driver) {
		return findElementByTagName(driver,"h2");
	}
	/**
	 * @return the productsCategory
	 */
	public WebElement getProductsCategory(WebDriver driver) {
		return findElementByTagName(driver,"h1");
	}
	
    /**
     * @return get Product Result Title
     */
    public WebElement getProductResultTitle(WebDriver driver) {
        return findElementByCssSelector(driver, ".a-color-state");
    }

}
