package stepDefinitions;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	public WebDriver driver;  // declare the WedDriver GLOBALY to be accessible in the entire class
	public String landingPageProductName;
	public String offerPageProductName;


	public OfferPageStepDefinition (TestContextSetup testContextSetup){
		
		this.testContextSetup = testContextSetup;
	} 

	    @Then("^User searched for (.+) in offers page$")
	    public void user_searched_for_something_in_offers_page(String shortName) throws InterruptedException {
	    
	    switchToOffersPage(); 
	    OffersPage offersPage = testContextSetup.pageObjectManager.OffersPage();
	   
	    //testContextSetup.driver.findElement(By.cssSelector("#search-field")).sendKeys(shortName);
	    offersPage.searchIteam(shortName);
	    Thread.sleep(2000);
	    //offerPageProductName =testContextSetup.driver.findElement(By.cssSelector("tbody tr td:nth-child(1)")).getText();
	    offerPageProductName = offersPage.getProduchName();
	    Thread.sleep(2000);
	    }
	    
	    
	    public void switchToOffersPage() throws InterruptedException {
	    	// to ensure that this method does't called twice, whice happen in case that we have a lot of TCs , we can control this with if condition
	    	// if (testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
	    	
	    	// As this variable comes from landingPage, so we have to define it there
	    	//testContextSetup.driver.findElement(By.cssSelector(".cart-header-navlink[href='#/offers']")).click();
	    	
	    	//pageObjectManager = new PageObjectManager(testContextSetup.driver);
	    	LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
	    	//LandingPage landingPage = new LandingPage(testContextSetup.driver);
	    	landingPage.selectTopDeals();
	    	testContextSetup.genericUtils.SwitchWIndowToChild();
	    }
	    
	    @And("^Validate product name in offers page matches with landing page$")
	    public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    	
	    	Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	    
	        
	    }
	
	
}
