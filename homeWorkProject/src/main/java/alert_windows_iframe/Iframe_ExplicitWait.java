package alert_windows_iframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.datatorrent.api.AffinityRule.Type;

import automation.common.CommonBase;

public class Iframe_ExplicitWait extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("https://codestar.vn/");
	}

	@Test
	public void handleIFrame() {
		System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
		scrollToElement(By.xpath("//h2[text() = 'Đội ngũ giảng viên']"));
		driver.switchTo().frame(3);
		type(By.id("account_phone"), "0967896789");
		click(By.xpath("//button[text() = 'Gửi ngay']"));
	}
	
	@Test
	public void findIFrame1() {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pause(10000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Số lượng frame: " + size);
		for( int i = 0; i < size ; i++) {
			driver.switchTo().frame(i);
			int numberOfFrame = driver.findElements(By.xpath("//button[text() = 'Gửi ngay']")).size();
			if(numberOfFrame != 0)// Có button Gửi ngay thì in ra vị trí của iframe hiện tại để dùng
			{
				System.out.println("Element cần tìm ở vị trí: " +i);
			}
			// Sau khi in ra element cần tìm phải trở về frame cha để tìm đến hết
			driver.switchTo().defaultContent();
		}
	}
}
