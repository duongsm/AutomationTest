package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageFactory {
	@FindBy(xpath = "//input[@id = 'txtFirstname']")
	private WebElement txtUserName;

	@FindBy(xpath = "//input[@id = 'txtEmail']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id = 'txtCEmail']")
	private WebElement txtReEmail;

	@FindBy(xpath = "//input[@id = 'txtPassword']")
	private WebElement txtPassword;

	@FindBy(xpath = "//input[@id = 'txtCPassword']")
	private WebElement txtRePassword;

	@FindBy(xpath = "//input[@id = 'txtPhone']")
	private WebElement txtPhoneNumber;

	@FindBy(xpath = "//input[@id = 'chkRight']")
	private WebElement chkConfirm;

	@FindBy(xpath = "//div[@class = 'field_btn']//button[text() = 'ĐĂNG KÝ']")
	private WebElement btnSignUp;

	private WebDriver driver;

	public SignUpPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void SignUpFunction(String username, String email, String password, String phonenumber) {
		txtUserName.sendKeys(username);
		txtEmail.sendKeys(email);
		txtReEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		txtRePassword.sendKeys(password);
		txtPhoneNumber.sendKeys(phonenumber);
		boolean check = chkConfirm.isSelected();
		if (check == false)
			chkConfirm.click();
		btnSignUp.click();
	}
}
