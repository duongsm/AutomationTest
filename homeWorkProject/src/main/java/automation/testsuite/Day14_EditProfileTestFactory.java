package automation.testsuite;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pageLocator.Day14_EditProfilePageFactory;
import automation.pageLocator.Day14_LoginPageFactory;

public class Day14_EditProfileTestFactory extends CommonBase{
	@BeforeTest
	public void openApplication() {
		driver = initFirefoxDriverTest(AccountConstant.webURL_1);
		Day14_LoginPageFactory login = new Day14_LoginPageFactory(driver);
		login.Login("DuongDB5@gmail.com", "Password");
	}
	
	@Test
	public void editProfileSuccessfully() {
		Day14_EditProfilePageFactory editprf = new Day14_EditProfilePageFactory(driver);
		editprf.EditPassword("Password", "NewPassword");
	}
}
