package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks { // the perpose of this hooks to imppöement precondition and postcondition and clean up for every TC
	WebDriver driver; 
	
	TestContextSetup testContextSetup; // local global variable 
    public Hooks(TestContextSetup testContextSetup) {
    	this.testContextSetup=testContextSetup;
    }
 
	@After // after each senario this step will be executed 
	public void AfterScenario() throws IOException {
		//To quit() the web browser we need to access the Webdriver, the Webdriver is located in TestBase Class to access it we need to create a new object
		// a new object is already created in Class TestContextSetup. So we write the code below
		testContextSetup.testBase.WebDriverManger().quit(); // is equal to driver.quit();
			
	}
	
	@AfterStep //  this methode will be executed after each and every step no matter what
	public void AddScreenshot(Scenario scenario) throws IOException { // this is the scenario i'm trying to execute. This holds all information about the scenario if it is passed or failed 
		WebDriver driver=testContextSetup.testBase.WebDriverManger();
		if (scenario.isFailed()) {
			
			File sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image"); // add this dependency to convert a file to a byte format <!-- https://mvnrepository.com/artifact/commons-io/commons-io --> and add line in extent.properties
			
		}
		
	}
	
	
}
