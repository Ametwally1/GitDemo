package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
	//By productName = By.cssSelector("h4.product-name");
	By productName = By.xpath("//h4[normalize-space()='Tomato - 1 Kg']");
	By topDeals = By.cssSelector(".cart-header-navlink[href='#/offers']");
	By increment = By.xpath("//a[@class='increment']");
	By addToCart = By.xpath("//button[normalize-space()='ADD TO CART']"); 



	// Build the action using methods. We build here user defined action method

	public void searchiteam(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText() {
		driver.findElement(search).getText();
	}
	
	// because we perform some action in this method, we need to retrun this method
	// in String
	public String getTheProductName() {
		return driver.findElement(productName).getText();
		
	}
	
	public void selectTopDeals() {
		driver.findElement(topDeals).click();
	}
	
	public String getTitleLandungPage() {
		return driver.getTitle();
	}
	
	public void incrementQuantity (int quantity) {
		int i= quantity-1;// Because on is already there 
		while (i>0) {
			driver.findElement(increment).click();
			i--;
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
		
	}

}
