package automation.testsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.constant.AccountConstant;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public final class SearchFlights_Day16 extends automation.common.CommonBase {
	@BeforeTest
	public void openApplication() {
		driver = initFirefoxDriverTest(AccountConstant.webURL_4);
	}

	@Test
	public void ChooseDatePicker() {
		WebElement dateBox = driver.findElement(
				By.xpath("(//label[text()='Departing']/following-sibling::div//input[@name='daterange-single'])[1]"));
		WebElement searhbtn = driver
				.findElement(By.xpath("(//a[@class = 'theme-btn w-100 text-center margin-top-20px'])[2]"));
		// Fill date as dd/mm/yyyy as 25/09/2024
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", dateBox);
		// Press tab to shift focus to time field
		dateBox.clear();
		dateBox.sendKeys("25092024");
		dateBox.sendKeys(Keys.TAB);
		((JavascriptExecutor) driver).executeScript("arguments [0].click();", searhbtn);
		pause(4000);
		WebElement result = driver.findElement(By.xpath("//h2[text() = 'Flight Search Result']"));
		assertTrue(result.isDisplayed());
	}

//	@Test
//	public void ChooseDatePickerRoundTrip() {
//
//		WebElement dateBox = driver.findElement(By.xpath("(//input[@name = 'daterange'])[1]"));
//		WebElement RoundTripRadio = driver.findElement(By.xpath("//a[@id= 'round-trip-tab']"));
//		// Fill date as dd/mm/yyyy as 25/09/2024 - 25/10/2024
//		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", dateBox);
//		// Press tab to shift focus to time field
//		((JavascriptExecutor) driver).executeScript("arguments [0].click();", RoundTripRadio);
//		dateBox.clear();
//		dateBox.sendKeys("25092024-25102024");
//		dateBox.sendKeys(Keys.TAB);
//	}

	@AfterTest
	public void closeBrowserTest() {
		// quitDriver(driver);
	}

}