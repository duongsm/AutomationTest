package alert_windows_iframe;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class WindowsPopup_ExplicitWait extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("https://demo.guru99.com/popup.php");
	}

	@Test
	public void TestPopupWindow() {
		click(By.xpath("//*[contains(@href,'popup.php')]"));
		// Lưu lại lớp Window đầu tiên
		String mainWindow = driver.getWindowHandle();
		// Lấy ra tất cả các tab windows đang open bằng hàm getwindowHandle
		// Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp
		Set<String> windows = driver.getWindowHandles();
		// Để duyệt từng phần tử không trùng lặp trong Collection (Set) ta dùng foreach
		for (String window : windows) {
			System.out.println(window);
			if (!mainWindow.equals(window)) {
				// So sánh nếu window nào khác window Chính (đầu tiên) thì chuyển qua để thao tác
				driver.switchTo().window(window);
				pause(2000);
				System.out.println("Đã chuyển đến window con");
				// Một số hàm hỗ trợ
				System.out.println("Title: " + driver.switchTo().window(window).getTitle());
				System.out.println("CurentTitle: " + driver.switchTo().window(window).getCurrentUrl());
				type(By.name("emailid"),"Testdemo@gmail.com");
				click(By.name("btnLogin"));
				// Get text sau khi Submit
				String text = driver.findElement(By.xpath("//table//td//h2")).getText();
				System.out.println(text);
				Assert.assertEquals(text, "Access details to demo site.");
				// Đóng window con
				driver.close();
			}
		}
		// Chuyển đến window chính(mainWindow)
		driver.switchTo().window(mainWindow);
		System.out.println("Đã chuyển về window chính" + driver.getCurrentUrl());
	}
}
