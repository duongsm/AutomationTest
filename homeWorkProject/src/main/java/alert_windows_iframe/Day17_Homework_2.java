package alert_windows_iframe;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day17_Homework_2 extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("https://codestar.vn/");
	}
	
	@Test
	public void homeWork() {
		System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
		scrollToElement(By.xpath("//h2[text() = 'Đăng ký nhận tài liệu:']"));
		driver.switchTo().frame(4);
		type(By.name("account_name"), "DuongDB");
		type(By.name("account_phone"), "0967896789");
		click(By.xpath("//button[text() = 'Đăng ký ngay']"));
	}
	@Test
	public void findIFrame1() {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pause(10000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Số lượng frame: " + size);
		for( int i = 0; i < size ; i++) {
			driver.switchTo().frame(i);
			int numberOfFrame = driver.findElements(By.xpath("//button[text() = 'Đăng ký ngay']")).size();
			if(numberOfFrame != 0)// Có button Gửi ngay thì in ra vị trí của iframe hiện tại để dùng
			{
				System.out.println("Element cần tìm ở vị trí: " +i);
			}
			// Sau khi in ra element cần tìm phải trở về frame cha để tìm đến hết
			driver.switchTo().defaultContent();
		}
	}
}
