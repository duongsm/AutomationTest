package alert_windows_iframe;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class AlertSendkeys extends CommonBase{
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("https://demo.automationtesting.in/Alerts.html");
	}
	
	@Test
	public void TestAlert02() {
		driver.findElement(By.xpath("//a[normalize-space()= 'Alert with Textbox']")).click();
		pause(2000);
		driver.findElement(By.xpath("//button[normalize-space()= 'click the button to demonstrate the prompt box']")).click();
		driver.switchTo().alert().sendKeys("DuongDB Automation Class");
		pause(2000);
		driver.switchTo().alert().accept();
//		pause(2000);
		WebElement element =  getElementPresentDOM(By.id("demo1"));
		String actualText = element.getText();
		assertEquals(actualText, "Hello DuongDB Automation Class How are you today");
//		WebElement actualMessage = driver.findElement(By.xpath("//p[@id='demo1']"));
//		assertTrue(actualMessage.isDisplayed());
	}
}
