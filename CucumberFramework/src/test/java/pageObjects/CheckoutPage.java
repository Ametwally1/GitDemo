package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By cartBag = By.xpath("//img[@alt='Cart']");
	By CheckoutButton = By.cssSelector("div[class='cart-preview active'] button[type='button']");
	By promoBtn = By.cssSelector("input[placeholder='Enter promo code']");
	By placeOrder = By.xpath("//button[normalize-space()='Place Order']"); 
	
	



	
	public void checkoutIteams() {
		driver.findElement(cartBag).click();
		driver.findElement(CheckoutButton).click();
	}
	
	public Boolean verifyPromoBtn () {
		return driver.findElement(promoBtn).isDisplayed();
	}
	

	public Boolean VerifyPlaceOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	

}
