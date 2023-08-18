package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import automation.common.CommonBase;
import org.openqa.selenium.WebElement;

public class Day12_MultiCheckbox extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}

	@Test
	public void MultiCheckbox() throws InterruptedException {
		List<WebElement> listCheckbox = driver
				.findElements(By.xpath("(//div[@class ='panel-body'])[3]//div[@class = 'checkbox']//input"));
		System.out.println("Tong so luong checkbox: " + listCheckbox.size());
		for (int i = 0; i < listCheckbox.size(); i++) {
			System.out.println("Checkbox ở vị trí " + i + " Checked " + listCheckbox.get(i).isSelected());
			boolean isCheckboxSelected = listCheckbox.get(i).isSelected();
			if (isCheckboxSelected == false) {
				listCheckbox.get(i).click();
				System.out.println("Vị trí thứ " + (i + 1) + " is checked");
			}
		}
		// Lấy ra từng element cụ thể
		System.out.println("---------");
		for (int i = 0; i < listCheckbox.size(); i++) {
			WebElement itemCheckbox = driver.findElement(
					By.xpath("((//div[@class ='panel-body'])[3]//div[@class = 'checkbox']//input)[" + (i + 1) + "]"));
			System.out.println(itemCheckbox.isSelected());
		}
	}
}