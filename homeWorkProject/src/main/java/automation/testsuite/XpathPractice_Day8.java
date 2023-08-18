package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class XpathPractice_Day8  extends CommonBase{
	@BeforeTest
	public void openPage() {
		driver = initFirefoxDriverTest("https://bepantoan.vn/danh-muc/may-hut-mui");
	}
	@Test
	public void findById() {
		driver.findElement(By.id("email"));
		System.out.println("Found email element by ID");
		driver.findElement(By.id("password"));
		System.out.println("Found password element by ID");		
	}
	@Test
	public void findByName() {
		driver.findElement(By.name("email"));
		System.out.println("Found email element by Name");
		driver.findElement(By.name("password"));
		System.out.println("Found password element by Name");
	}
	@Test
	public void findByLinkText() {
		driver.findElement(By.linkText("Máy Hút Mùi Ống Khói"));
		System.out.println("Found element by LinkText");
		driver.findElement(By.partialLinkText("Ống Khói"));
		System.out.println("Found element by PartialLinkText");	
		driver.findElement(By.linkText("Máy Hút Mùi Cổ Điển"));
		System.out.println("Found element by LinkText");
		driver.findElement(By.partialLinkText("Cổ Điển"));
		System.out.println("Found element by PartialLinkText");	
	}
	@Test
	public void findByTagName() {
		driver.findElement(By.tagName("input"));
		System.out.println("Found element by TagName");	
	}
	@Test
	public void findByClassName() {
		driver.findElement(By.className("cursor-pointer checkbox-control"));
		System.out.println("Found element by ClassName");
	}
	@AfterTest
	public void quitDriver() {
		//driver.close();
	}
}
