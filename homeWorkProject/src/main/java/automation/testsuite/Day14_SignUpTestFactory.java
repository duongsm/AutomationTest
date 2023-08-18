package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pageLocator.DanhSachKhoaHoc;
import automation.pageLocator.DashBoardPage;
import automation.pageLocator.LoginPageFactory;
import automation.pageLocator.SignUpPageFactory;

public class Day14_SignUpTestFactory extends CommonBase {
	@BeforeTest
	public void openApplication() {
		driver = initFirefoxDriverTest(AccountConstant.webURL_1);
	}

	@Test
	public void signUpSuccessfully() {
		SignUpPageFactory signup = new SignUpPageFactory(driver);
		signup.SignUpFunction("DuongDB", "DuongDB5@gmail.com", "Password", "0967896789");

		DanhSachKhoaHoc dskh = new DanhSachKhoaHoc();
		pause(4000);
		WebElement expected = driver.findElement(dskh.signUpText);
		assertTrue(expected.isDisplayed());
	}

	@AfterTest
	public void quitDriver() {
		driver.close();
	}
}
