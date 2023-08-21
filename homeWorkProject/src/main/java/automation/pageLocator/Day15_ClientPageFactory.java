package automation.pageLocator;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day15_ClientPageFactory {

//	@FindBy(xpath = "(//span[@class = 'menu-text '])[2]")
//	private WebElement linkClient;

	@FindBy(xpath = "//a[@title = 'Add client']")
	private WebElement btnAddClient;

	@FindBy(id = "type_organization")
	private WebElement radioOrganization;

	@FindBy(id = "type_person")
	private WebElement radioPerson;

	@FindBy(xpath = "//input[@id = 'company_name']")
	private WebElement txtCompany;

	// xpath của Owner dropdownlist
	@FindBy(xpath = "//div[@id='s2id_created_by']")
	private WebElement dropdownOwner;
	// Giá trị của từng Owner trong màn Add Client
	@FindBy(xpath = "(//ul[@role='listbox'])[2]/li[1]")
	private WebElement ownerValue1;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "city")
	private WebElement txtCity;

	@FindBy(id = "state")
	private WebElement txtState;

	@FindBy(id = "zip")
	private WebElement txtZip;

	@FindBy(id = "country")
	private WebElement txtCountry;

	@FindBy(id = "vat_number")
	private WebElement txtVat_number;

	@FindBy(id = "gst_number")
	private WebElement txtGst_number;

	@FindBy(id = "s2id_autogen2")
	private WebElement txtClient_group;

	@FindBy(id = "select2-chosen-1")
	private WebElement dropdownCurrency;

	@FindBy(id = "currency_symbol")
	private WebElement txtCurrency_symbol;

	@FindBy(id = "s2id_client_labels")
	private WebElement txtLabel;

	@FindBy(id = "disable_online_payment")
	private WebElement checkboxDisable_online_payment;

	@FindBy(xpath = "//button[@class = 'btn btn-primary']")
	private WebElement btnSaveAndClose;

	@FindBy(xpath = "//a[text() = 'Clients']")
	private WebElement clientTag;
	
	@FindBy(xpath = "(//input[@placeholder = 'Search'])[2]")
	private WebElement searchBox;
	
	@FindBy(xpath = "//td[@class = ' all']//a[text()='PersonDemo']")
	private WebElement searchResult;
	
	private WebDriver driver;

	public Day15_ClientPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AddClient(String personName) throws InterruptedException {
		DashBoardPage dashboard = new DashBoardPage();
		driver.findElement(dashboard.clientlink).click();
//		btnAddClient.click();
		((JavascriptExecutor) driver).executeScript("arguments [0].click();", btnAddClient);
		Thread.sleep(4000);
		radioPerson.click();
		txtCompany.sendKeys(personName);
		dropdownOwner.click();
		ownerValue1.click();
		btnSaveAndClose.click();
		((JavascriptExecutor) driver).executeScript("arguments [0].click();", clientTag);
		Thread.sleep(4000);
		searchBox.sendKeys(personName);
		Thread.sleep(4000);
		assertTrue(searchResult.isDisplayed());
	}
}
