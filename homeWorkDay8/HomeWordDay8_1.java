package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class HomeWordDay8_1 extends CommonBase{
	@BeforeTest
	public void openPage() {
		driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
	}
	@Test
	public void findById() {
		driver.findElement(By.id("userId"));
		System.out.println("Found email element by ID");
		driver.findElement(By.id("pass"));
		System.out.println("Found password element by ID");
	}
	@Test
	public void findByName() {
		driver.findElement(By.name("email"));
		System.out.println("Found email element by Name");
		driver.findElement(By.name("Password"));
		System.out.println("Found password number element by Name");
		driver.findElement(By.name("company"));
		System.out.println("Found company element by Name");
		driver.findElement(By.name("moblie number"));
		System.out.println("Found moblie number element by Name");		
	}
	@Test
	public void findByClassName() {
		driver.findElement(By.className("selectors-input jsSelector"));
		System.out.println("Found element by ClassName");
		driver.findElement(By.className("form-control"));
		System.out.println("Found element by ClassName");
	}
	@AfterTest
	public void quitDriver() {
		driver.close();
	}
}
