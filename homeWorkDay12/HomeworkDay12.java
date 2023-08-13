package automation.testsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class HomeworkDay12 extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("http://demo.seleniumeasy.com/input-form-demo.html");
	}

	@Test
	public void handleTextBox() {

		// Chọn Dropdown List State
		Select stateSelect = new Select(driver.findElement(By.xpath("//select[@name = 'state']")));
		stateSelect.selectByVisibleText("Alaska");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals("Alaska", stateSelect.getFirstSelectedOption().getText());

		// Chọn Yes Radio Button
		WebElement yesRadioButton = driver.findElement(By.xpath("//input[@value='yes']"));
		boolean isYesCheck = yesRadioButton.isSelected();
		if (isYesCheck == false) {
			yesRadioButton.click();
		} else {
			WebElement noRadioButton = driver.findElement(By.xpath("(//input[@value='no']"));
			noRadioButton.click();
		}
	}
}
