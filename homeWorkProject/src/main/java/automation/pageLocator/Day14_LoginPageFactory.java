package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day14_LoginPageFactory {
	@FindBy(id = "txtLoginUsername")
	private WebElement txtLoginUserName;

	@FindBy(id = "txtLoginPassword")
	private WebElement txtLoginPass;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnLogin;
	
	private WebDriver driver;

	public Day14_LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void LoginWithNewPassword(String email, String password) {
		txtLoginUserName.sendKeys(email);
		txtLoginPass.sendKeys(password);
		btnLogin.click();
	}
	
	public void Login(String email, String password) {
		txtLoginUserName.sendKeys(email);
		txtLoginPass.sendKeys(password);
		btnLogin.click(); 
	}
}
