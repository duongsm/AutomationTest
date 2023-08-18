package automation.testsuite;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pageLocator.Day14_EditProfilePageFactory;

public class Day14_EditProfileTestFactory extends CommonBase{
	@BeforeTest
	public void openApplication() {
		driver = initFirefoxDriverTest(AccountConstant.webURL_1);
		Day14_SignUpTestFactory signup = new Day14_SignUpTestFactory();
		signup.signUpSuccessfully();
	}
	
	@Test
	public void editProfileSuccessfully() {
		Day14_EditProfilePageFactory editprf = new Day14_EditProfilePageFactory(driver);
		editprf.EditPassword("Password", "NewPassword");
		editprf.Logout();
	}
}
