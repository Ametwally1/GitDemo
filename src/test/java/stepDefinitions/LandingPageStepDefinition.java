package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

		public WebDriver driver;  // declare the WedDriver GLOBALY to be accessible in the entire class
		public String landingPageProductName;
		public String offerPageProductName;
		TestContextSetup testContextSetup;
		LandingPage landingPage;
		
		// to make sure that this class TestContextSetup is shared in the whole class Step 1. create this variable as global variable. 
		// the global variable has no knowledge. The varibanle in (TestContextSetup testContextSetup) has the knowledge. Step 2. Assign
		// the one that have knowledge to the global variable (this.testContextSetup = testContextSetup;)
		// this. = this instance variable
		// single responsibility principle, see below
		// Loosely coupled = tightly coupled
		// Factory Design Pattern, see below
		public LandingPageStepDefinition (TestContextSetup testContextSetup){
			
			this.testContextSetup = testContextSetup;
			this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
		} 
		
		
	  @Given("^User is on GreenCart landing page$")
	    public void user_is_on_greencart_landing_page() { // the constractor here call the start of web browser 
		  //WebDriver driver= new ChromeDriver(); // The driver here is local for this method, which means that the driver cann't be accessed outside of this method. 
		  //To make it accessible to the entire class, make sure you declare this driver GLOBALY also outside of the method 
		  
		 /* testContextSetup.driver= new ChromeDriver();
		  testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		  testContextSetup.driver.manage().window().maximize(); */
		  
		  Assert.assertTrue(landingPage.getTitleLandungPage().contains("GreenKart"));

	    }

	    @When("^User searched with Shortname (.+) and extracted actual name of product$")
	    //as long as the stringname the same is, the value will be get from feature file, in this case "Tom"
	    public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(String shortName) throws InterruptedException  {
	    //LandingPage landingPage = new LandingPage(testContextSetup.driver);
	    	
	    //LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();// added in as constrctor like Class CheckOutLandingPage
	    	
	    //testContextSetup.driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")).sendKeys(shortName);  
	    landingPage.searchiteam(shortName);
	    //testContextSetup.landingPageProductName =testContextSetup.driver.findElement(By.xpath("//h4[normalize-space()='Tomato - 1 Kg']")).getText().split("-")[0].trim();
	    testContextSetup.landingPageProductName = landingPage.getTheProductName().split("-")[0].trim();
	    Thread.sleep(2000);
		System.out.println(testContextSetup.landingPageProductName + "is extracted from home page");   
	    }
	    
	    
	    @When("^Added (.+) iteam of the selected product to cart$")
	    public void added_something_iteam_of_the_selected_product_to_cart(int quantity) throws InterruptedException {
	    	
	    	Thread.sleep(2000);
	    	landingPage.incrementQuantity(quantity); 
	    	// the problem is here that quantity is integer in the methode but un StepDefi. is string. To lose this problem we use this methode to convert from int to string
	    	//landingPage.incrementQuantity(Integer.parseInt(quantity));
	    	landingPage.addToCart();
	    }

	    
}

/* Note for me
> These two variables are shared. In Order to be accessible in all classes we put them in UTIL Package  
 
> (SRP) The Single Responsibility Principle (SRP) is a principle of object-oriented programming that states that every class or module
 should have a single, well-defined responsibility. This means that a class or module should only have one reason to change, 
 and it should be responsible for only one part of the functionality of the system.
 
 > Factory Design Pattern . we create a new single Java class which is responsible for creating objects of all
 the objects hava basis  
 
 */
