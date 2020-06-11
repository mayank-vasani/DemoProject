import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ExcelReadWrite {
	WebDriver driver;
	String excelPath = "C:\\Users\\mayank.vasani\\Desktop\\TC\\Test.xlsx";
	String userNameTextBox = "//input[@name='ctl00$body$txtUserID']";
	String passwordTextBox = "//input[@name='ctl00$body$txtPassword']";
	String submit = "//input[@type='submit']";

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void f() throws IOException {
		driver.manage().window().maximize();
		driver.get("http://10.82.180.36/common/login.aspx");
		File src = new File(excelPath);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		fis.close();
		String userName1 = sheet1.getRow(0).getCell(0).getStringCellValue();
		String passWord1 = sheet1.getRow(0).getCell(1).getStringCellValue();
		String userName2 = sheet1.getRow(1).getCell(0).getStringCellValue();
		String passWord2 = sheet1.getRow(1).getCell(1).getStringCellValue();

		// First Attempt
		String beforeUrl1 = driver.getCurrentUrl();
		driver.findElement(By.xpath(userNameTextBox)).sendKeys(userName1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(passwordTextBox)).sendKeys(passWord1);
		driver.findElement(By.xpath(submit)).click();
		String afterUrl1 = driver.getCurrentUrl();
		
/*
		// Second Attempt
		String beforeUrl2 = driver.getCurrentUrl();
//		driver.findElement(By.xpath(userNameTextBox)).clear();
//		driver.findElement(By.xpath(passwordTextBox)).clear();
		driver.findElement(By.xpath(userNameTextBox)).sendKeys(userName2);
		driver.findElement(By.xpath(passwordTextBox)).sendKeys(passWord2);
		driver.findElement(By.xpath(submit)).click();
		String afterUrl2 = driver.getCurrentUrl(); */
		
		if (beforeUrl1.equals(afterUrl1)) {
			sheet1.getRow(0).createCell(2).setCellValue("Failed");
			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);
			System.out.println("Failed........");
		} else {
			System.out.println("Passed.......");
			sheet1.getRow(0).createCell(2).setCellValue("Passed");
			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);
		}

//		if (beforeUrl2.equals(afterUrl2)) {
//			sheet1.getRow(1).createCell(2).setCellValue("Failed");
//			FileOutputStream fout = new FileOutputStream(src);
//			wb.write(fout);
//			System.out.println("Failed........");
//		} else {
//			System.out.println("Passed.......");
//			sheet1.getRow(1).createCell(2).setCellValue("Passed");
//		}
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
