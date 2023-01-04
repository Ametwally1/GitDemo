package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	WebDriver driver;

	public OffersPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	//private By search = By.cssSelector("#search-field"); when declares a variable to private, no other classes can modify this locators
	// also they are not seen outside the class > Encapsulation 
	By search = By.cssSelector("#search-field");
	By produchName = By.cssSelector("tr td:nth-child(1)");

	
	
	public void searchIteam (String name) {
		
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText() {
		
	 driver.findElement(search).getText();
		}
	
	public String getProduchName() {
	
	return driver.findElement(produchName).getText();
	}
}
