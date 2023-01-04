package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	 public LandingPage landingPage;
	 public OffersPage offersPage;
	 public CheckoutPage checkoutPage;
	 public WebDriver driver;
	// this class is responsible to give the objects. In other words, in this class we create objects of all PageObject files. see below!
	//Get me landing pages when i call this method. this method should give me the object of this landing page
	
	public PageObjectManager (WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage() {
		
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage OffersPage () {
		offersPage = new OffersPage(driver);
		return offersPage;
		}
	
	public CheckoutPage getCheckoutPage() {
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
		
	}

}


/*

The PageObjectManager is a class that is used to manage the creation of Page Objects. 
It has a method for each Page Object that returns a new instance of that Page Object, or returns an existing instance if one has already been created. 
This helps to avoid creating multiple instances of the same Page Object, 
which can be resource-intensive and can lead to issues with test reliability.

Using a PageObjectManager can help to make your tests more efficient and easier to maintain. 
It can also make it easier to switch between different Page Objects during a test, 
as you can simply call the appropriate method on the PageObjectManager rather than having to create a new instance of the Page Object manually.

*/