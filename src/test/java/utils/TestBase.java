package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManger() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resourcess//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		
		if (driver == null) {
			
		if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{	
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//src//test//resourcess//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver","src\\test\\resourcess\\chromedriver.exe"); 
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// we add wait 5 seconds until object is found. 5 Seconds is the default timeout i'm adding for this entire framework
		driver.get(url);
		driver.manage().window().maximize();
		} 
		  return driver;
		}
	}
	
