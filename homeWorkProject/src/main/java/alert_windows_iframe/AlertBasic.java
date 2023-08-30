package alert_windows_iframe;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class AlertBasic extends CommonBase{
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("https://demo.guru99.com/test/delete_customer.php");
	}
	
	@Test
	public void TestAlert01() {
		driver.findElement(By.name("cusid")).sendKeys("123456");;
		driver.findElement(By.name("submit")).submit();
		pause(2000);
		//Khai báo chuyển hướng đến Alert với đối tượng
		Alert alert = driver.switchTo().alert();
		//Get message trên alert
		String alertMessage = driver.switchTo().alert().getText();
		assertEquals(alertMessage, "Do you really want to delete this Customer?");	
		pause(2000);
		//accept() = Nhấn OK button
//		driver.switchTo().alert().accept();
		alert.accept();
//		pause(2000);
//		//driver.switchTo.alert().accept(); // Cách 1
//		String actualMessage = driver.switchTo().alert().getText();
//		assertEquals(actualMessage, "Customer Successfully Delete!");
//		alert.accept();
//		// Cách 2 Nhấn Cancel button
//		// alert.dismiss();
//		pause(2000);
	}
	
	@AfterTest
	public void closePage() {
		
	}
}
