package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class HomeWorkDay8_2 extends CommonBase{
	@BeforeTest
	public void openPage() {
		driver = initChromeDriver("https://automationfc.github.io/basic-form/index.html");
	}
	@Test
	public void findById() {
		driver.findElement(By.id("name"));
		System.out.println("Found name element by ID");
		driver.findElement(By.id("address"));
		System.out.println("Found address element by ID");		
		driver.findElement(By.id("email"));
		System.out.println("Found email element by ID");
		driver.findElement(By.id("password"));
		System.out.println("Found password element by ID");	
	}
	@Test
	public void findByName() {
		driver.findElement(By.name("name"));
		System.out.println("Found name element by Name");
		driver.findElement(By.name("address"));
		System.out.println("Found address element by Name");		
		driver.findElement(By.name("email"));
		System.out.println("Found email element by Name");
		driver.findElement(By.name("password"));
		System.out.println("Found password element by Name");	
	}
	@AfterTest
	public void quitDriver() {
		driver.close();
	}
}
