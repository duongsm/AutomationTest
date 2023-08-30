package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day14_EditProfilePageFactory {

	@FindBy(xpath = "//div[@class='avatar2']")
	private WebElement imgProfile;

	@FindBy(xpath = "//a[@class='fs14']")
	private WebElement linkEditProfile;

	@FindBy(xpath = "(//a[@href='https://alada.vn/tai-khoan/dang-xuat.html'])[1]")
	private WebElement btnLogout;

	@FindBy(id = "txtpassword")
	private WebElement txtPassword;

	@FindBy(id = "txtnewpass")
	private WebElement txtNewPassword;

	@FindBy(id = "txtrenewpass")
	private WebElement txtReNewPassword;

	@FindBy(xpath = "(//button[@class = 'btn_blue_sm marleft42per'])[2]")
	private WebElement btnSavePassword;

	private WebDriver driver;

	public Day14_EditProfilePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void EditPassword(String password, String newpassword) {
		imgProfile.click();
		linkEditProfile.click();
		txtPassword.sendKeys(password);
		txtNewPassword.sendKeys(newpassword);
		txtReNewPassword.sendKeys(newpassword);
		btnSavePassword.click();
		
	}

	public void Logout() {
		imgProfile.click();
		btnLogout.click();
	}


}
