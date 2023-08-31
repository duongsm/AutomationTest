package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pageLocator.Day15_ClientPageFactory;
import automation.pageLocator.LoginPageFactory;
import automation.pageLocator.DashBoardPage;
import automation.pageLocator.Day14_LoginPageFactory;
import automation.pageLocator.Day14_SignUpPageFactory;

public class Day15_ClientTestFactory extends CommonBase {
	
//	@BeforeTest
//	@Parameters("testNgBrowser")
//	public void openPage(String browser) {
//		setupDriver(browser);
//		driver.get(AccountConstant.webURL);
//	}
	
	@BeforeTest
	public void openApplication() {
		driver = initFirefoxDriverTest(AccountConstant.webURL);
	}

	@Test
	public void addClientSuccessfully() throws InterruptedException {
		LoginPageFactory factory = new LoginPageFactory(driver);
		factory.LoginFunctionFactory("admin@demo.com", "riseDemo");
		DashBoardPage dashboard = new DashBoardPage();
		pause(4000);
		WebElement expected = driver.findElement(dashboard.dashboardText);
		assertTrue(expected.isDisplayed());
		
		Day15_ClientPageFactory clientPage = new Day15_ClientPageFactory(driver);
		clientPage.AddClient("PersonDemo");
	}
}
