package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

		public WebDriver driver;
		public String landingPageProductName;
		public String offerPageProductName;
		public CheckoutPage checkoutPage; 
		TestContextSetup testContextSetup;

		
		public CheckoutPageStepDefinition (TestContextSetup testContextSetup){
			this.testContextSetup = testContextSetup;
			this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
		} 
		


	   /* @And("^Added \"([^\"]*)\" iteam of the selected product to cart$")
	    public void added_something_iteam_of_the_selected_product_to_cart(String quantity) {
	    	
	        
	    }*/
	    

	    @Then("^Veify user has ability to enter promo code and place the order$")
	    public void veify_user_has_ability_to_enter_promo_code_and_place_the_order() {
	    	
	    	//checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	    	Assert.assertTrue(checkoutPage.verifyPromoBtn());
	    	Assert.assertTrue(checkoutPage.VerifyPlaceOrder()); 
	    }
	    

	    @Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	    public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException {
	    	//checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage(); // if i try to write this code, which means, it is duplicated to the step in above method
	    	//checkoutPage.checkoutIteams(); if i write this statement , which means it is dependent to the method above which is not wished. to overcome this problem i write 
	    	//the full statement in the constructor. 
	    	checkoutPage.checkoutIteams();
	    	Thread.sleep(2000);
	    }
}

