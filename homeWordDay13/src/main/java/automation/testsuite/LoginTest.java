package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.apache.zookeeper.Login;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pageLocator.DashBoardPage;
import automation.pageLocator.LoginPage;

public class LoginTest extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest(AccountConstant.webURL);
	}

	@Test
	public void LoginSuccessfully() {
		LoginPage page = new LoginPage(driver);
		page.LoginFunction("admin@demo.com", "riseDemo");

		// Kiem tra ket qua sau khi dang nhap thanh cong
		DashBoardPage dashboard = new DashBoardPage();
		WebElement expected = driver.findElement(dashboard.dashboardText);
		assertTrue(expected.isDisplayed());
	}

	@Test
	public void LoginFail_IncorrectEmail() {
		LoginPage page = new LoginPage(driver);
		page.LoginFunction("admin_invalid@demo.com", "riseDemo");

		// Kiem tra ket qua sau khi dang nhap that bai
		DashBoardPage dashboard = new DashBoardPage();
		WebElement expected = driver.findElement(page.authenFailText);
		assertTrue(expected.isDisplayed());
	}

	@Test
	public void LoginFail_IncorrectPassword() {
		LoginPage page = new LoginPage(driver);
		page.LoginFunction("admin@demo.com", "riseDemo_invalid");

		// Kiem tra ket qua sau khi dang nhap that bai
		DashBoardPage dashboard = new DashBoardPage();
		WebElement expected = driver.findElement(page.authenFailText);
		assertTrue(expected.isDisplayed());
	}
	
	@Test
	public void LoginFail_IncorrectPasswordEmail() {
		LoginPage page = new LoginPage(driver);
		page.LoginFunction("admin_invalid@demo.com", "riseDemo_invalid");

		// Kiem tra ket qua sau khi dang nhap that bai
		DashBoardPage dashboard = new DashBoardPage();
		WebElement expected = driver.findElement(page.authenFailText);
		assertTrue(expected.isDisplayed());
	}
	
	
}
