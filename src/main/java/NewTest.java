import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {
 
	WebDriver driver;
	String excelPath= "C:\\Users\\mayank.vasani\\Desktop\\TC\\TC_BI-1562.xlsx";
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\ChromeDriver\\chromedriver.exe");
	  driver=new ChromeDriver();
  }
  
  @Test
  public void f() throws InvalidFormatException, IOException {
	  driver.manage().window().maximize();
	  driver.get("http://10.82.180.36/common/login.aspx");
	  
	 //	  Workbook workbook= WorkbookFactory.create(new File(excelPath));
//	  System.out.println("Workbook has : "+ workbook.getNumberOfSheets() + " Sheets");
	  
	  File src=new File(excelPath);
	  FileInputStream fis =new FileInputStream(src);
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	  XSSFSheet sheet1=wb.getSheetAt(0);
	  for(int i=0;i<4;i++){
		  String data1=sheet1.getRow(0).getCell(i).getStringCellValue();
		  System.out.println("Data Number:"+ i +": " + data1);
	  }
	  String data1=sheet1.getRow(0).getCell(0).getStringCellValue();
	  driver.findElement(By.xpath("//input[@name='ctl00$body$txtUserID']")).sendKeys(data1);
	  driver.findElement(By.xpath("//input[@name='ctl00$body$txtPassword']")).sendKeys(data1);
//	  fis.close();
//	  FileOutputStream fos=new FileOutputStream("C:\\Users\\mayank.vasani\\Desktop\\TC\\Test.xlsx");
//	  wb.write(fos);
//	  fos.close();
//	  System.out.println("End of writting data into excel");
	  
	  sheet1.getRow(2).createCell(0).setCellValue("Test Data");
	  FileOutputStream fout=new FileOutputStream(src);
	  wb.write(fout);
	 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
