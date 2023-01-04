package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
// the purpose of this class to share the variable between step definition files. in large projects we might see 20 step definition files 
	// and if we need the data exchanging between each and every file, we can apply this util calss
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup () throws IOException {
		
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManger());
		genericUtils = new GenericUtils(testBase.WebDriverManger());
		
	}

}
