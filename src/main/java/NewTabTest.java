import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class NewTabTest {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void f() {
		  WebElement gmaillink = driver.findElement(By.linkText("Gmail"));  
          
	        Actions aa = new Actions(driver);  
	        aa.moveToElement(gmaillink).keyDown(Keys.CONTROL).click().perform();

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
