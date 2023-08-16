package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pageLocator.DashBoardPage;
import automation.pageLocator.LoginPage;

public class LogoutTest extends CommonBase{
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest(AccountConstant.webURL);
	}
	
	@Test
	public void LogoutSuccessfully() {
		LoginPage page = new LoginPage(driver);
		page.LoginFunction("admin@demo.com", "riseDemo");
		// Kiem tra ket qua sau khi dang nhap thanh cong
		DashBoardPage dashboard = new DashBoardPage();
		WebElement expected = driver.findElement(dashboard.dashboardText);
		assertTrue(expected.isDisplayed());
		
		page.LogoutFunction();
		WebElement expectedLogout = driver.findElement(dashboard.logoutText);
		assertTrue(expectedLogout.isDisplayed());
	}
}
