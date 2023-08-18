package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pageLocator.DanhSachKhoaHoc;
import automation.pageLocator.DashBoardPage;
import automation.pageLocator.Day14_LoginWithNewPasswordPageFactory;

public class Day14_LoginWithNewPasswordTestFactory extends CommonBase{
	@BeforeTest
	public void openApplication() {
		driver = initFirefoxDriverTest(AccountConstant.webURL_2);
	}	
	@Test
	public void loginSuccessfullyWithNewPassword() {
		Day14_LoginWithNewPasswordPageFactory login = new Day14_LoginWithNewPasswordPageFactory(driver);
		login.LoginWithNewPassword("DuongDB5@gmail.com", "NewPassword");
		DanhSachKhoaHoc dskh = new DanhSachKhoaHoc();
		pause(4000);
		WebElement expected = driver.findElement(dskh.loginSuccess);
		assertTrue(expected.isDisplayed());
		
	}
}
