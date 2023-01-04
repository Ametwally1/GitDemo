package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils { // it works as RTSB 
	
	 WebDriver driver;

	public GenericUtils (WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void SwitchWIndowToChild() throws InterruptedException {
		
		 Set<String> s1 =driver.getWindowHandles();
		    Iterator<String> i1 =s1.iterator ();
		    String parentWindow =i1.next();
		    String childtWindow =i1.next();
		    Thread.sleep(2000);
		    driver.switchTo().window(childtWindow);
		
	}

}
