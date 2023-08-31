package alert_windows_iframe;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day17_Homework_1 extends CommonBase{
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("https://codestar.vn/");
	}
	
	@Test
	public void homeWork() {
		System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
		pause(10000);
		driver.switchTo().frame(5);
		clickJavaScript(By.xpath("//span[text() = 'Bắt đầu chat']"));
		WebElement element =  driver.findElement(By.xpath("//span[text() = 'Sử dụng Messenger']"));
		String actualText = element.getText();
		assertEquals(actualText, "Sử dụng Messenger");
	}
	@Test
	public void findIFrame1() {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pause(10000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Số lượng frame: " + size);
		for( int i = 0; i < size ; i++) {
			driver.switchTo().frame(i);
			int numberOfFrame = driver.findElements(By.xpath("//span[text() = 'Bắt đầu chat']")).size();
			if(numberOfFrame != 0)// Có button Bắt đầu chat thì in ra vị trí của iframe hiện tại để dùng
			{
				System.out.println("Element cần tìm ở vị trí: " +i);
			}
			// Sau khi in ra element cần tìm phải trở về frame cha để tìm đến hết
			driver.switchTo().defaultContent();
		}
	}
}
