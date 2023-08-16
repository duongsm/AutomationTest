package automation.testsuite;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_RadioButton extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
	}

	@Test
	public void handleRadioButton() {
		WebElement maleRadioButton = driver.findElement(By.xpath("(//input[@value='Male' and @type = 'radio'])[1]"));
		boolean isMaleCheck = maleRadioButton.isSelected();
		if (isMaleCheck == false) {
			maleRadioButton.click();
			System.out.println("Male radio button is selected: " + maleRadioButton.isSelected());
		} else {
			WebElement feMaleRadioButton = driver.findElement(By.xpath("(//input[@value='Female' and @type = 'radio'])[1]"));
			feMaleRadioButton.click();
			System.out.println("Female radio button is selected: " + feMaleRadioButton.isSelected());
		}
	}
}
