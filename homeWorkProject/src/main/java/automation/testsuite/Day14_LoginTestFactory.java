package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pageLocator.DashBoardPage;
import automation.pageLocator.LoginPageFactory;

public class Day14_LoginTestFactory extends CommonBase {

	@BeforeTest
	public void openApplication() {
		driver = initFirefoxDriverTest(AccountConstant.webURL);
	}

	@Test
	public void loginSuccessfully() {
		LoginPageFactory factory = new LoginPageFactory(driver);
		factory.LoginFunctionFactory("admin@demo.com", "riseDemo");

		DashBoardPage dashboard = new DashBoardPage();
		pause(4000);
		WebElement expected = driver.findElement(dashboard.dashboardText);
		assertTrue(expected.isDisplayed());
	}

	@AfterTest
	public void quitDriver() {
		driver.close();
	}
}
