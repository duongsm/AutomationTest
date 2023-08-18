package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pageLocator.DashBoardPage;
import automation.pageLocator.LoginPage;

public class Day13_LogoutTest extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest(AccountConstant.webURL);
	}

	@Test
	public void LogoutSuccessfully() {
		LoginPage page = new LoginPage(driver);
		DashBoardPage dashboard = new DashBoardPage();
		WebElement notLogin = driver.findElement(dashboard.logoutText);
		if (notLogin != null) {
			System.out.println("Chưa đăng nhập");
			page.LoginFunction("admin@demo.com", "riseDemo");
			page.LogoutFunction();
		} else {
			System.out.println("Đã đăng nhập");
			page.LogoutFunction();
			assertTrue(notLogin.isDisplayed());
		}
	}
	
	@AfterTest
	public void quitDriver() {
		driver.close();
	}
	
}
