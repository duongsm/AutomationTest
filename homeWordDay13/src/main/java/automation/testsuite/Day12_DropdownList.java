package automation.testsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_DropdownList extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
	}

	@Test
	public void handleDropdownList() {
		Select singleSelect = new Select(driver.findElement(By.id("select-demo")));
		System.out.println("Size is: " + singleSelect.getOptions().size());
		WebElement dropDayElement = driver.findElement(By.id("select-demo"));
		dropDayElement.click();
		// Cách 1: SelectByVisibleText
//		singleSelect.selectByVisibleText("Monday");
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//		Assert.assertEquals("Monday", singleSelect.getFirstSelectedOption().getText());
		// Cách 2: SelectByIndex
//		singleSelect.selectByIndex(3);
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//		Assert.assertEquals("Tuesday", singleSelect.getFirstSelectedOption().getText());
		// Cách 3: SelectByValue
		singleSelect.selectByValue("Sunday");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals("Sunday", singleSelect.getFirstSelectedOption().getText());
	}
}
