package automation.testsuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_Button extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}

	@Test
	public void handleButton() {
		WebElement element = driver.findElement(By.xpath("//input[@id = 'check1']"));
		element.click();

		List<WebElement> listCheckbox = driver
				.findElements(By.xpath("(//div[@class ='panel-body'])[3]//div[@class = 'checkbox']//input"));
		System.out.println("Tong so luong checkbox: " + listCheckbox.size());
		for (int i = 0; i < listCheckbox.size(); i++) {
			boolean isCheckboxSelected = listCheckbox.get(i).isSelected();
			if (isCheckboxSelected == true) {
				System.out.println("All checkbox are selected");
			}
		}
	}
}
