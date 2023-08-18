package automation.testsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_PracticeDemo extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("http://demo.seleniumeasy.com/input-form-demo.html");
	}

	@Test
	public void handleTextBox() {
		// Nhập First Name
		WebElement firstNameElement = driver.findElement(By.xpath("//input[@name = 'first_name']"));
		firstNameElement.sendKeys("First Name");

		// Nhập Last Name
		WebElement lastNameElement = driver.findElement(By.xpath("//input[@name = 'last_name']"));
		lastNameElement.sendKeys("Last Name");

		// Nhập Email
		WebElement emailAddressElement = driver.findElement(By.xpath("//input[@name = 'email']"));
		emailAddressElement.sendKeys("Email@gmail.com");

		// Nhập Phone Number
		WebElement phoneNumberElement = driver.findElement(By.xpath("//input[@name = 'phone']"));
		phoneNumberElement.sendKeys("0967896789");

		// Nhập Address
		WebElement addressElement = driver.findElement(By.xpath("//input[@name = 'address']"));
		addressElement.sendKeys("66b Nguyễn Sỹ Sách");

		// Nhập City
		WebElement cityElement = driver.findElement(By.xpath("//input[@name = 'city']"));
		cityElement.sendKeys("Phường 15, quận Tân Bình");

		// Chọn Dropdown List State
		Select stateSelect = new Select(driver.findElement(By.xpath("//select[@name = 'state']")));
		stateSelect.selectByVisibleText("Alaska");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals("Alaska", stateSelect.getFirstSelectedOption().getText());

		// Nhập Zip Code
		WebElement zipCodeElement = driver.findElement(By.xpath("//input[@name = 'zip']"));
		zipCodeElement.sendKeys("6789");

		// Nhập Domain
		WebElement domainNameElement = driver.findElement(By.xpath("//input[@name = 'website']"));
		domainNameElement.sendKeys("binhduong.com.vn");

		// Chọn Yes Radio Button
		WebElement yesRadioButton = driver.findElement(By.xpath("//input[@value='yes']"));
		boolean isYesCheck = yesRadioButton.isSelected();
		if (isYesCheck == false) {
			yesRadioButton.click();
		} else {
			WebElement noRadioButton = driver.findElement(By.xpath("(//input[@value='no']"));
			noRadioButton.click();
		}

		// Nhập Comment
		WebElement projectDescriptionElement = driver.findElement(By.xpath("//textarea[@name = 'comment']"));
		projectDescriptionElement.sendKeys("No Comment");

		// Submit
		WebElement submitButton = driver.findElement(By.xpath("//button[@class = 'btn btn-default']"));
		submitButton.submit();

	}
}
