package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage {
	public By dashboardText = By.xpath("//span[text() = 'Dashboard']");
	public By logoutText = By.xpath("//h2[text() = 'Sign in']");
}
