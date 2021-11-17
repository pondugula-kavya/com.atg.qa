package AtgTesting.com.atg.qa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./myFiles/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "./myDriver/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "./myDriver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		else if(browserName.equalsIgnoreCase("ie")){
	        System.setProperty("webdriver.ie.driver", "./myDriver/msedegedriver.exe");
	        driver = new InternetExplorerDriver();
	    }
		
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
	}
}