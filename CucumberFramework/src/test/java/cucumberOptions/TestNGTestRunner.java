package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
features="src/test/java/features", //So if you want to run only single feature file. you have to provide that that name "src/test/java/features/login.feature"
glue="stepDefinitions",
tags="@OffersPage",
plugin= {"html:target/cucumber.html", "json:target/cucumber.json", 
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
		"rerun:target/failed_scenarios.txt"},
monochrome = true

//dryRun = true //dryRun is only for compilation, not for actual run

)

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider (parallel=true) // pls refer to parallel mode deceleration 
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}


/*
 Notes for me
1.  
for extent report we need to add the 2 following dependencies in POM XML files
 a) <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
    <!-- https://mvnrepository.com/artifact/tech.grasshopper/extentreports-cucumber7-adapter -->
 b) and add the following syntax in the cucumberOption Plugin (com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:)
	if cucumber version is 7 the cucumber adapter in extension must be 7
 c) create properties file with name extent.porperties
 
 
 
2. Run TCs in parallel > https://cucumber.io/docs/guides/parallel-execution/?lang=java

3. rerun:target/failed_scenarios.txt > this code if very helpful in case that the TC is failed. it will automatically rerun the failed tc and create entry of the faild tc
   if that happened we can create another new TestNGRunner and adapt it as following 
   
   @CucumberOptions(
		
	features="@target/failed_scenarios.txt"
	glue="stepDefinitions",

	plugin= {"html:target/cucumber.html", "json:target/cucumber.json", 
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true)


 */


