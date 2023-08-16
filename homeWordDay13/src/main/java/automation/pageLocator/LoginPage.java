package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private By txtemail = By.id("email");
	private By txtpassword = By.id("password");
	private By buttonLogin = By.xpath("//button[text() = 'Sign in']");
	private By buttonLogout = By.xpath("(//a[@class = 'dropdown-item'])[4]");
	private By dropUser = By.xpath("//a[@id = 'user-dropdown']");
		
	private WebDriver driver;
	public By authenFailText = By.xpath("//div[normalize-space()='Authentication failed!' and @role='alert']");

	public LoginPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void LoginFunction(String email, String password) {
		WebElement textboxEmail = driver.findElement(txtemail);
		if (textboxEmail.isDisplayed()) {
			textboxEmail.clear(); // Do trang Login duoc nhap san nen can phai clear
			textboxEmail.sendKeys(email);
		}

		WebElement textboxPassword = driver.findElement(txtpassword);
		if (textboxPassword.isDisplayed()) {
			textboxPassword.clear(); // Do trang Login duoc nhap san nen can phai clear
			textboxPassword.sendKeys(password);

			WebElement btnLogin = driver.findElement(buttonLogin);
			if (btnLogin.isDisplayed()) {
				btnLogin.click();
			}

		}
	}
	public void LogoutFunction() {
		WebElement drUser = driver.findElement(dropUser);
		drUser.click();
		WebElement btnLogout = driver.findElement(buttonLogout);
		btnLogout.click();
	}
}
