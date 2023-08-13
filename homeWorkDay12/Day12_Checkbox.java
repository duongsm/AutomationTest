package automation.testsuite;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_Checkbox extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}

	@Test
	public void handleCheckbox() {
		WebElement thisCheckbox = driver.findElement(By.xpath("//div//input[@id='isAgeSelected']"));
		boolean check = thisCheckbox.isSelected();
		if (check == false)
			thisCheckbox.click();
		System.out.println("Element is selected: " + thisCheckbox.isSelected());

	}
}
