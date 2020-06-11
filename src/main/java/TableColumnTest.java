import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TableColumnTest {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		 driver.get("http://10.82.180.36/common/login.aspx"); 
	}

	@Test
	public void f() {
		driver.findElement(By.xpath("//*[@id=\"body_txtUserID\"]")).sendKeys("donhere"); 
        
        driver.findElement(By.id("body_txtPassword")).sendKeys("don@123"); 
          
        driver.findElement(By.name("ctl00$body$btnLogin")).click(); 
         
        WebElement table1=driver.findElement(By.id("body_cph_MyAccount_gvAccountDetails")); 
         
        List<WebElement> row1=table1.findElements(By.tagName("tr")); 
         
        System.out.println("The number of rows in webtablen :"+row1.size()); 
         
        for(int n=1;n<row1.size();n++) 
        { 
            List<WebElement> cols=row1.get(n).findElements(By.tagName("td")); 
             
            System.out.println("The number of rows in webtablen :"+cols.size()); 
             
             
            for(int m=0;m<cols.size();m++) 
            { 
                System.out.println("The data in the rows and columns are:"+cols.get(m).getText()); 
            } 
        } 
		
		
//		driver.switchTo().frame("center");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
